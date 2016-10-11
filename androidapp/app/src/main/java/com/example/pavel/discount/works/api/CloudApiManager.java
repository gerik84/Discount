package com.example.pavel.discount.works.api;


import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.Volley;
import com.example.pavel.discount.Building;
import com.example.pavel.discount.Tools;

import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.util.Map;

public class CloudApiManager {
    static final String PROTOCOL_CHARSET = "utf-8";

    private static RequestQueue sRequestsQueue;
    private static RequestQueue sOrdersStatusManagerRequestsQueue;

    public static String buildApiRequest(String command, Map<String, ? extends Object> query) {
        StringBuilder sb = new StringBuilder(Building.BACKEND_URL);
        sb.append(command);

        if (query != null && query.size() > 0) {
            sb.append("?").append(Tools.joinQueryList(query));
        }
        return sb.toString();
    }

    public static void sendRequest(Request request) {
        sendRequest(request, defaultRequestsQueue());
    }

    public static void sendRequest(Request request, RequestQueue queue) {
        if (queue == null) {
            queue = defaultRequestsQueue();
        }

        String method = "1";
        switch (request.getMethod()) {
            case Request.Method.GET:
                method = "GET";
                break;
            case Request.Method.POST:
                method = "POST";
                break;
            case Request.Method.PUT:
                method = "PUT";
                break;
            case Request.Method.DELETE:
                method = "DELETE";
                break;
            default:
                method = String.valueOf(request.getMethod());
        }
        Log.i("Api", "Request> Method=" + method + " Url=" + request.getUrl());
        queue.add(request);
    }

    public static void logApiResponse(Request request, NetworkResponse response) {
        StringBuilder sb = new StringBuilder();
        sb.append("Response> url: ").append(request.getUrl());
        if (response != null) {
            sb.append("\ncode: ").append(response.statusCode);
        }
        Log.i("Api", sb.toString());
    }

    public static void logApiError(Request request, VolleyError error) {
        StringBuilder sb = new StringBuilder();
        sb.append("Error> url: ").append(request.getUrl());
        if (error != null) {
            sb.append("\nmessage: ").append(error.getMessage());
            if (error.networkResponse != null) {
                sb.append("\ncode: ").append(error.networkResponse.statusCode);
                sb.append("\nbody: ");
                if (error.networkResponse.data != null) {
                    String body = "null";
                    try {
                        body = new String(error.networkResponse.data,
                                HttpHeaderParser.parseCharset(error.networkResponse.headers, PROTOCOL_CHARSET));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    sb.append(body);
                }
            }
        }
        Log.e("Api", sb.toString());
    }

    public static int responseStatusCode(VolleyError error) {
        if (error != null) {
            if (error.networkResponse != null) {
                return error.networkResponse.statusCode;
            }
            if (Tools.isNotNullString(error.getMessage())) {
                if (error.getMessage().equalsIgnoreCase("java.io.IOException: No authentication challenges found")) {
                    return HttpURLConnection.HTTP_UNAUTHORIZED;
                }
            }
        }
        return -1;
    }

    public static RequestQueue defaultRequestsQueue() {
        if (sRequestsQueue == null) {
            sRequestsQueue = Volley.newRequestQueue(Tools.appContext());
        }
        return sRequestsQueue;
    }

    public static RequestQueue ordersStatusManagerRequestsQueue() {
        if (sOrdersStatusManagerRequestsQueue == null) {
            sOrdersStatusManagerRequestsQueue = Volley.newRequestQueue(Tools.appContext());
        }
        return sOrdersStatusManagerRequestsQueue;
    }

    public enum COMMAND {

        REQUEST_ACCESS("/wk/api_v1/reception/access"),

        REGISTER_DEVICE("/api_v1/deviceRegistration"),
        REGISTER_APNS("/api_v1/registerAPNS"),
        CHATS("/wk/api_v1/complaintList"),
        CHAT_MESSAGES("/wk/api_v1/complaint/Messages"),
        CHAT_SEND_MESSAGE("/wk/api_v1/complaint/SendMessage"),

        ORDER_ROOMS("/api_v1/hotels"),
        ORDERS("/wk/api_v1/orders"),
        ORDER_PENDING("/wk/api_v1/orders/statusPending"),
        ORDER_DONE("/wk/api_v1/orders/statusDone"),
        ORDER_DECLINE("/wk/api_v1/orders/statusDecline"),
        ORDER_EDIT("/wk/api_v1/orders/modify"),

        PUSH_DATA("/api_v1/pushData"),

        ROOMS("/wk/api_v1/device"),

        SETTINGS("/api_v1/setting"),

        CATEGORY("/wk/api_v1/category"),

        USERS("/wk/api_v1/guest"),
        TEST("/search");



        public String command;
        public int method;

        COMMAND(String command) {
            this(command, Request.Method.POST);
        }

        COMMAND(String command, int method) {
            this.command = command;
            this.method = method;
        }

        @Override
        public String toString() {
            return command;
        }
    }

    public static interface PARAM {
        public static final String OBJECT_ID = "id";
        public static final String UUID = "uuid";

        public static final String ORDER_STATUS = "status";
        public static final String ORDER_AMOUNT = "amount";
        public static final String ORDER_DATE = "date";
        public static final String ORDER_TO_DATE = "by_date";
        public static final String ORDER_MESSAGE = "message";
        public static final String ORDER_COMMENT = "comment";

    }
}
