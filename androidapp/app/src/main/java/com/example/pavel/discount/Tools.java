package com.example.pavel.discount;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Pavel G on 10.10.2016.
 */
public class Tools {

    public static void checkNullPoint(Object obj) {
        checkNullPoint(obj, null);
    }

    public static void checkNullPoint(Object obj, String msg) {
        if (obj == null)
            throw new NullPointerException(msg == null ? "can not be zero" : msg);
    }

    private static Context sContext;

    public static void init(Context context) {
        sContext = context;
    }

    public static Context appContext() {
        checkNullPoint(sContext);
        return sContext;
    }

    public static boolean isNotNullString(String input) {
        return TextUtils.isEmpty(input);
    }

    public static String joinQueryList(Map<String, ? extends Object> params) {
        if (params == null || params.size() == 0) return "";
        try {
            StringBuilder str = new StringBuilder();
            Set<String> keys = params.keySet();
            for (String key : keys) {
                if (key == null || key.length() == 0) continue;
                Object valVar = params.get(key);
                if (valVar instanceof Collection<?>) {
                    Collection<?> arr = (Collection<?>) valVar;
                    Iterator i = arr.iterator();
                    while (i.hasNext()) {
                        String val;
                        Object o = i.next().toString();
                        if (o != null) val = o.toString();
                        else val = "";
                        str.append(URLEncoder.encode(key, "UTF-8"));
                        str.append("=");
                        str.append(URLEncoder.encode(val, "UTF-8"));
                        str.append("&");
                    }
                } else {
                    String val = valVar.toString();
                    if (val == null) val = "";
                    str.append(URLEncoder.encode(key, "UTF-8"));
                    str.append("=");
                    str.append(URLEncoder.encode(val, "UTF-8"));
                    str.append("&");
                }
            }
            if (str.length() > 0) str.deleteCharAt(str.length() - 1);
            return str.toString();
        } catch (UnsupportedEncodingException e) {
            Log.wtf("UTILS", "ENCODE TO UTF8: " + params.toString());
            return null;
        }
    }

}
