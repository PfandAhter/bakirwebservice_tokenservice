package com.bws.tokenservice.model.constants;

public class PropertyConstants {
    //MICROSERVICE PATHS

    public static final String REST_TEMPLATE_REQUEST_MICROSERVICE_USER_SERVICE_FIND_BY_USERNAME = "${app.routesMicroservices.userService.findByUsername}";




    //CONTROLLER PATHS
    public static final String REQUEST_TOKENSERVICE = "${app.routesController.requestmapping.tokenServiceController}";

    public static final String REQUEST_GENERATETOKEN = "${app.routesController.token.generateToken}";

    public static final String REQUEST_EXTRACTUSERNAME = "${app.routesController.token.extractUsername}";

}
