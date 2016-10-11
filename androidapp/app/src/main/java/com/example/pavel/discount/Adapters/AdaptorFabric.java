package com.example.pavel.discount.Adapters;

import android.annotation.TargetApi;
import android.os.Build;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Pavel G on 11.10.2016.
 */
public class AdaptorFabric {

    public static <T extends BaseAdapter> T getInstance(Class<? extends BaseAdapter> _class) {
        Class<?> clazzsss = null;
        String name = _class.getName();
        Object object = null;
        try {
            clazzsss = Class.forName(name);
            Constructor<?> ctor = clazzsss.getConstructor();
            object = ctor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (T) object;
    }
}
