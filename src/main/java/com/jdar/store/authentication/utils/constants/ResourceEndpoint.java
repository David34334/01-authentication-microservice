package com.jdar.store.authentication.utils.constants;

public class ResourceEndpoint {

    private ResourceEndpoint() {super();}

    // Api Version
    public static final String API_PREFIX = "/api";
    public static final String API_VERSION = "/v1";
    public static final String AUTHENTICATION = "/auth";
    public static final String AUTHENTICATION_USER = "/user-auth";


    // Routes
    public static final String API_AUTHENTICATION_ENDPOINT = API_PREFIX + API_VERSION + AUTHENTICATION;
    public static final String API_AUTHENTICATION_USER_ENDPOINT = API_PREFIX + API_VERSION + AUTHENTICATION_USER;


    // Endpoints
    public static final String AUTHENTICATION_VALIDATE_ENDPOINT = "/validate";


    // Headers
    public static final String AUTHORIZATION_HEADER = "Authorization";

}
