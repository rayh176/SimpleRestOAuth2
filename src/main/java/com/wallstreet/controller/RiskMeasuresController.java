package com.wallstreet.controller;

import com.wallstreet.auth.RiskMeasureAuthenticator;
import com.wallstreet.rest.RiskMeasure;
import com.wallstreet.service.JsonToRiskMeasureObject;
import com.wallstreet.service.RiskMeasureCache;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@RestController
@RequestMapping("/")
public class RiskMeasuresController implements RiskMeasureAuthenticator {

    @Autowired
    ObjectFactory<HttpServletRequest> httpRequestFactory;

    @Autowired
    JsonToRiskMeasureObject jsonToObjectHelper;

    @Autowired
    RiskMeasureCache riskMeasureCache;

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @PostMapping("/{version}/risk-measures")
    public ResponseEntity<RiskMeasure> registerRiskMeasure(@RequestBody RiskMeasure riskMeasureInfo,
                                                           @HeaderParam("user") String user,
                                                           UriComponentsBuilder builder) throws ServletException, IOException {

        HttpServletRequest request = httpRequestFactory.getObject();

        String accessToken = riskMeasureCache.getTokenFromCache(ACCESS_TOKEN);

        if (accessToken == null) {

            authenticateCallback(request, riskMeasureCache);
        }

        RiskMeasure fileBasedRiskMeasure = jsonToObjectHelper.constructRiskMeasureFromFile();

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.buildAndExpand(fileBasedRiskMeasure.getName()).toUri());
        return new ResponseEntity<>(fileBasedRiskMeasure, headers, HttpStatus.CREATED);
    }

}
