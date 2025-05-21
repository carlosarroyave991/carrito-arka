package com.arka.microservice.usuarios.domain.config;

import java.util.regex.Pattern;

/**
 * General constants
 */
public class Const {

    //PATTERNS
    public static final Pattern PATTERN_PASSWORD = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$");
    public static final Pattern PATTERN_USERNAME = Pattern.compile("^[a-zA-Z][a-zA-Z0-9_-]{2,19}$");
    public static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    public static final Pattern PATTERN_PHONE = Pattern.compile("^[0-9]{6,10}$");

    public static final Pattern PATTERN_ZIPCODE = Pattern.compile("^\\d{5}$");
}
