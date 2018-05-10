Overview
The project cover a REST API proxy service, that provides a single (unauthenticated) API endpoint that receives JSON data, and calls
an internal (authenticated) API service to perform statistical analysis of that data and return the results. The internal service requires
authentication which is obtained from our OAuth2 identity service.

Technologies
------------
Java 1.8
Spring (4.3)
Spring boot
EhCache
OAuth
Rest

Note:
----
The example will tend to achieve a simple task as soon as it receive a request to store risk measure,
first authenticate the request, cache it and proceed to provide response by read risk measure from the file
and send back to the client.

All request should be posted via http://localhost:8080/v.1.1/risk-measures any other request is routed to error page

Added support for cache that hold auth token up to 24 hours

Remarque:
--------
1- I considered using redirection by using sending response to a different view but for simplicity
it wasn't added
2- No use of Cookies was added.
3- Convert Json to Html page not finished
4- I didn't add Cucumber or more tests due to lack of time

Edit
----
Project with any IDE but preferably IntelliJ

Build project
-------------
mvn clean install

Start the server
----------------
[please have Java on PATH] - run the below
startUp.sh

Run the client
--------------
curl -v -H "Content-Type: application/json" -d '{"name": "PRIIP-1eq-autocall", "issueDate": "10/05/2018", "maturityDate": "10/05/2019", "horizon": 3.0011530927963577, "riskfreeRateSettlement": "USD", "equities": { "etickers": "UKX Index", "riskfreeRateEquities": [ "USD"], "underlyingCurrency": [null], "entryCost": 1, "IHP1midbid": 0.5, "IHP2midbid": 0.5, "exitCost": 0.2, "ongoingTransaction": 0, "ongoingInsurance": 0, "ongoingOther": 0.3, "performanceFee": 0, "carriedInterest": 0 }' http://localhost:3000/v.1.1/risk-measures
                                                                                                                                                                                                                                                                                                                 "carriedInterest": 0},"

