package com.hotelmanagement.constant;

public interface MessageCodes {

    public String SUCCESS = "200";
    public String SUCCESS_MSG = "SUCCESS";

    public String REQUEST_ERROR= "Invalid Request";
    public String ERROR= "400";
    public String ERROR_MSG = "ERROR";
    public String NOT_FOUND = "404";
    public String UNPROCESSABLE="422";
    public String UNPROCESSABLE_desc="Unprocessable Entity";

    public String NON_AUTHORATIVE_INFORMATION = "203";
    public String NON_AUTHORATIVE_INFORMATION_MSG = "Non Authorative Response";
    public String NON_AUTHORATIVE_INFORMATION_DESC = "Non Authorative Response Error. Please try again later";

    public String INTERNAL_SERVER_ERROR = "500";
    public String INTERNAL_SERVER_ERROR_MSG = "Internal Server Error";
    public String INTERNAL_SERVER_ERROR_DESC = "Internal Server Error. Please try again later.";

    public String INVALID_RESPONSE = "502";
    public String INVALID_RESPONSE_MSG = "INVALID_RESPONSE";
    public String INVALID_RESPONSE_DESC = "Internal Response. Please try again later";

    public String BAD_REQUEST = "400";
    public String BAD_REQUEST_MSG = "BAD_REQUEST";
    public String BAD_REQUEST_DESC = "Invalid Request. Please provide valid request.";

    public String REQUEST_TIMEOUT = "408";
    public String REQUEST_TIMEOUT_MSG = "REQUEST_TIMEOUT";
    public String REQUEST_TIMEOUT_DESC = "Request Time Out. Please try again later.";

    public String GATEWAY_TIMEOUT = "504";
    public String GATEWAY_TIMEOUT_MSG = "GATEWAY_TIMEOUT";
    public String GATEWAY_TIMEOUT_DESC = "Gateway Time Out. Please try again later.";

    public String UN_AUTHORISATION = "401";
    public String UN_AUTHORISATION_MSG = "UN_AUTHORISATION";
    public String UN_AUTHORISATION_DESC = "Unauthrised data. Please provide valid authorization request.";

    public String UNSUPPORTED_MEDIA_TYPE = "415";
    public String UNSUPPORTED_MEDIA_TYPE_MSG = "INVALID_JSON_FORMAT";
    public String UNSUPPORTED_MEDIA_TYPE_DESC = "Unsupported Media Type. Please provide valid JSON format.";

    public String HEALTH_CHECK_RES_DESC = "Health check successful";

    public String ADD_MENU_SUCCESS_DESC ="Menu Item Added SuccessFully";
    public String ADD_MENU_ERROR_DESC ="Menu Item Failed to add";
    public String GET_MENU_SUCCESS_DESC ="Menu Item retrieved SuccessFully";
    public String GET_MENU_ERROR_DESC ="Menu Item Failed to retrieve";
    public String DELETE_MENU_SUCCESS_DESC ="Menu Item deleted SuccessFully";
    public String DELETE_MENU_ERROR_DESC ="Menu Item Failed to delete";

    public String ADD_USER_SUCCESS_DESC ="New user added SuccessFully";
    public String ADD_USER_ERROR_DESC ="Failed to add new user";
    public String DELETE_USER_SUCCESS_DESC ="User deleted SuccessFully";
    public String DELETE_USER_ERROR_DESC ="Failed to delete user";
    public String FETCH_USER_SUCCESS_DESC ="User details retrieved SuccessFully";
    public String FETCH_USER_ERROR_DESC ="Failed to retrieve user details";

    public String LOGIN_SUCCESS_DESC ="Loggedin SuccessFully";
    public String LOGIN_ERROR_DESC ="Failed to login";
    public String INVALID_CREDENTIAL_DESC ="Invalid Credential";
    public String ADD_TABLE_SUCCESS_DESC ="New Table added SuccessFully";
    public String ADD_TABLE_ERROR_DESC ="Failed to add new Table";

    public String DELETE_TABLE_SUCCESS_DESC ="Table deleted SuccessFully";
    public String DELETE_TABLE_ERROR_DESC ="Failed to delete Table";
    public String UPDATE_ORDER_SUCCESS_DESC ="Order Updated SuccessFully";
    public String UPDATE_ORDER_ERROR_DESC ="Order Failed to update";

    public String ORDER_DETAIL_SUCCESS_DESC ="Order details received SuccessFully";
    public String ORDER_DETAIL_ERROR_DESC ="Failed to get Order details";

    public String BILLING_SUCCESS_DESC ="Billed SuccessFully";
    public String BILLING_ERROR_DESC ="Failed to bill";

    public String BILLED_SUCCESS_DESC ="Billed retrieved SuccessFully";
    public String BILLED_ERROR_DESC ="Failed to retrieve bill";

    public String TABLE_Detail_SUCCESS_DESC ="Table Details retrieved SuccessFully";
    public String TABLE_Detail_ERROR_DESC ="Failed to retrieve Table Details";

}
