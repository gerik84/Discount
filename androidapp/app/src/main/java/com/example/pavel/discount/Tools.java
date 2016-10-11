package com.example.pavel.discount;

import java.util.Objects;

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
}
