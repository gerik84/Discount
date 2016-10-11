package com.example.pavel.discount.works.api;


import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;

import java.util.HashMap;

public class GetRoomsRequest extends JsonArrayRequest {

    public static GetRoomsRequest request(Response.Listener<JSONArray> listener, Response.ErrorListener errorListener) {
        CloudApiManager.COMMAND command = CloudApiManager.COMMAND.TEST;
        HashMap<String, String> query = new HashMap<>();
        query.put("text", "Green");

        String url = CloudApiManager.buildApiRequest(command.command, query);
        return new GetRoomsRequest(url, listener, errorListener);
    }

    public GetRoomsRequest(String url, Response.Listener<JSONArray> listener, Response.ErrorListener errorListener) {
        super(url, listener, errorListener);
    }

    @Override
    protected Response<JSONArray> parseNetworkResponse(NetworkResponse response) {
//        Response<JSONArray> r = super.parseNetworkResponse(response);
//
//        DatabaseConnection dbConnection = Tools.dbManager().getDatabaseConnection();
//        dbConnection.beginSimpleTransaction();
//
//        dbConnection.clearTable(AppDatabaseConnection.Tables.ROOM);
//        try {
//            JSONArray data = r.result;
//            for (int i=0; i<data.length(); i++) {
//                try {
//                    JSONObject item = data.getJSONObject(i);
//                    RoomObject roomObject = new RoomObject(item);
//                    ContentValues cv = roomObject.contentValuesRepresentation();
//
//                    dbConnection.insertOrReplace(AppDatabaseConnection.Tables.ROOM, cv);
//                } catch (JSONException e) {
//                    Log.e("GetRoomsRequest", "Parsing error> ", e);
//                }
//            }
//            dbConnection.setTransactionSuccessful();
//        } finally {
//            dbConnection.endSimpleTransaction();
//        }

        Log.e("", "");
        return null;
    }


}
