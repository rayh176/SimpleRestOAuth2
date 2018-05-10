package com.wallstreet.service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wallstreet.rest.RiskMeasure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import org.springframework.core.io.Resource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class JsonToRiskMeasureObject {

    Logger LOGGER = LoggerFactory.getLogger(JsonToRiskMeasureObject.class);

    @Value("classpath:risk-message.json")
    private Resource res;

    /**
     * Read risk measure from the file
     * @return riskMeasure object
     */
    public RiskMeasure constructRiskMeasureFromFile() {
        ObjectMapper mapper = new ObjectMapper();
        RiskMeasure riskMeasure = null;
        try {

            InputStream fileStream = res.getInputStream();

            // Convert JSON string from file to Object
            riskMeasure = mapper.readValue(fileStream, RiskMeasure.class);

        } catch (JsonGenerationException e) {
            LOGGER.error("JsonGenerationException", e);
        } catch (JsonMappingException e) {
            LOGGER.error("JsonMappingException", e);
        } catch (IOException e) {
            LOGGER.error("IOException", e);
        }
        return riskMeasure;
    }
}
