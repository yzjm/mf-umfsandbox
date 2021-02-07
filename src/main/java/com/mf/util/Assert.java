package com.mf.util;

import java.util.Collection;

public class Assert {
    public static void isNull(Object obj) {
        isNull(obj, "[Assertion failed] - the object must be null");
    }

    public static void isNull(Object obj, String message) {
        if (obj != null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void notNull(Object obj) {
        notNull(obj, "[Assertion failed] - the object can't be null");
    }

    public static void notNull(Object obj, String message) {
        if (obj == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void notEmpty(Collection<?> collection, String message) {
        if (collection == null || collection.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void notEmpty(Collection<?> collection) {
        notEmpty(collection, "[Assertion failed] - the collection can't be empty");
    }

    public static void isEmpty(Collection<?> collection, String message) {
        if (collection != null && !collection.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void isEmpty(Collection<?> collection) {
        isEmpty(collection, "[Assertion failed] - the collection must be empty");
    }

    public static void isBlank(String str, String message) {
        if (str != null && !"".equals(str)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void isBlank(String str) {
        isBlank(str, "[Assertion failed] - the string must be blank");
    }

    public static void notBlank(String str, String message) {
        if (str == null || "".equals(str)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void notBlank(String str) {
        notBlank(str, "[Assertion failed] - the string can't be blank");
    }
}
