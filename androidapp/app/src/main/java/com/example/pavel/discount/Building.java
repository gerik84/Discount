package com.example.pavel.discount;


public final class Building {

    // servers
    public static final boolean USE_SSL = false;
    public static final String SERVER_SCHEME = USE_SSL ? "https://" : "http://";
    public static final String BACKEND_URL = SERVER_SCHEME + BuildConfig.BACKEND_URL;


}
