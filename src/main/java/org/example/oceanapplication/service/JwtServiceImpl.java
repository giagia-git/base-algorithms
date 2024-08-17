package org.example.oceanapplication.service;

import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.example.oceanapplication.Constants.MessageDigestConstants;
import org.example.oceanapplication.model.jwt.dto.*;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Service
@Slf4j
public class JwtServiceImpl implements JwtService{
    public JwtResponse parseJwt(@NotNull JwtRequest rq) throws NullPointerException, UnsupportedEncodingException, NoSuchAlgorithmException {
        if (!MessageDigestConstants.validateAlgorithm(rq.getAlgorithm())) {
            log.error("invalid algorithm");
            return null;
        }
        String[] parts = rq.getToken().split("\\.");
        if (!MessageDigestConstants.validateJwtDots(parts)) {
            log.error("invalid token format");
            return null;
        }
        JwtResponse jwtResponse = new JwtResponse();
        Base64.Decoder decoder = Base64.getDecoder();
        for (int i = 0 ; i < parts.length-1 ; i++) {
            byte[] bytes = decoder.decode(parts[i]);
            String data = new String(bytes);
            switch(i) {
                case 0:
                    HeaderJwt headerJwt = HeaderJwt.builder()
                            .typ(MessageDigestConstants.AlgorithmCategory.JWT.name())
                            .alg(rq.getAlgorithm())
                            .build();
                    jwtResponse.setHeader(headerJwt);
                    break;
                case 1:
                    PayloadJwt payloadJwt = PayloadJwt.builder()
                            .body(data)
                            .build();
                    jwtResponse.setPayload(payloadJwt);
                    break;
                default:
            }
        }
        String signatureJwt = "SIGNATURE";
        jwtResponse.setSignature(signatureJwt);
        jwtResponse.setToken(rq.getToken());
        return jwtResponse;
    };
}
