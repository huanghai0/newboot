package com.example.newboot.utils;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * ParamUtils
 *
 * @author gcx
 * @date 2020/4/24
 */
public class ParamUtils {

    public static boolean isEmpty(Object value) {
        if (value == null) {
            return true;
        } else if (value instanceof CharSequence) {
            return ((CharSequence) value).length() == 0;
        } else if (value instanceof Collection) {
            return ((Collection) value).isEmpty();
        } else if (value instanceof Map) {
            return ((Map) value).isEmpty();
        } else if (value.getClass().isArray()) {
            return Array.getLength(value) == 0;
        }
        return false;
    }

    public static boolean isNotEmpty(Object value) {
        return !isEmpty(value);
    }
}
