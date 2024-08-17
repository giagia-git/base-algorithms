package org.example.oceanapplication.Constants;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class MessageDigestConstants {
    public static final List<String> algorithms = new ArrayList<>();
    public static final String SHA256 = "SHA256";
    public static final String SHA384 = "SHA384";
    public static final String SHA512 = "SHA512";
    public static final int JWTDots = 3;

    public enum AlgorithmCategory {
        JWT("JWT");

        private String value;

        AlgorithmCategory(String value) {
            this.value = value;
        }

        private String getValue() {
            return this.value;
        };
    }

    static {
        algorithms.add(SHA256);
        algorithms.add(SHA384);
        algorithms.add(SHA512);
    }

    public static boolean validateAlgorithm(String algorithm) {
        if (algorithm == null) {
            log.error("algorithm is invalid");
            throw new NullPointerException("Algorithm cannot be null");
        }
        return algorithms.contains(algorithm);
    }

    public static boolean validateJwtDots(String[] s) {
        if (s == null) {
            return false;
        }
        return s.length == JWTDots;
    }
}
