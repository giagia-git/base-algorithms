package org.example.oceanapplication.utils;

import org.springframework.stereotype.Component;

@Component
public class StringUtils {
    public static boolean validateString(String s) {
        return s != null && !s.isEmpty();
    }
}
