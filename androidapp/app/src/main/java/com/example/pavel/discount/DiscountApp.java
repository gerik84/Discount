package com.example.pavel.discount;

import android.app.Application;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.pavel.discount.works.api.CloudApiManager;
import com.example.pavel.discount.works.api.GetRoomsRequest;

import org.json.JSONArray;

/**
 * Created by Pavel G on 11.10.2016.
 */
public class DiscountApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Tools.init(this);

        GetRoomsRequest request = GetRoomsRequest.request(new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.e("","");

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("","");
            }
        });
        CloudApiManager.sendRequest(request);
    }
}
