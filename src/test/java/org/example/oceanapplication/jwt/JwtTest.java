package org.example.oceanapplication.jwt;

import org.example.oceanapplication.Constants.MessageDigestConstants;
import org.example.oceanapplication.model.jwt.dto.HeaderJwt;
import org.example.oceanapplication.model.jwt.dto.JwtRequest;
import org.example.oceanapplication.model.jwt.dto.JwtResponse;
import org.example.oceanapplication.model.jwt.dto.PayloadJwt;
import org.example.oceanapplication.service.JwtService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@SpringBootTest
@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
public class JwtTest {
    @Autowired
    private JwtService jwtService;

    @Test
    public void testParseJwtSHA256Test() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";
        HeaderJwt headerJwt = HeaderJwt.builder()
                .typ(MessageDigestConstants.AlgorithmCategory.JWT.name())
                .alg(MessageDigestConstants.SHA256)
                .build();
        PayloadJwt payloadJwt = PayloadJwt.builder()
                .body("{\"sub\":\"1234567890\",\"name\":\"John Doe\",\"iat\":1516239022}")
                .build();
        JwtResponse responseExpected = JwtResponse.builder()
                .token(token)
                .header(headerJwt)
                .payload(payloadJwt)
                .signature("SIGNATURE")
                .build();
        JwtRequest rq = new JwtRequest();
        rq.setAlgorithm(MessageDigestConstants.SHA256);
        rq.setToken(token);
        JwtResponse response = jwtService.parseJwt(rq);
        Assert.assertEquals(responseExpected, response);
    }

    @Test
    public void testParseJwtSHA384Test() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";
        HeaderJwt headerJwt = HeaderJwt.builder()
                .typ(MessageDigestConstants.AlgorithmCategory.JWT.name())
                .alg(MessageDigestConstants.SHA384)
                .build();
        PayloadJwt payloadJwt = PayloadJwt.builder()
                .body("{\"sub\":\"1234567890\",\"name\":\"John Doe\",\"iat\":1516239022}")
                .build();
        JwtResponse responseExpected = JwtResponse.builder()
                .token(token)
                .header(headerJwt)
                .payload(payloadJwt)
                .signature("SIGNATURE")
                .build();
        JwtRequest rq = new JwtRequest();
        rq.setAlgorithm(MessageDigestConstants.SHA384);
        rq.setToken(token);
        JwtResponse response = jwtService.parseJwt(rq);
        Assert.assertEquals(responseExpected, response);
    }

    @Test
    public void testParseJwtSHA512Test() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";
        HeaderJwt headerJwt = HeaderJwt.builder()
                .typ(MessageDigestConstants.AlgorithmCategory.JWT.name())
                .alg(MessageDigestConstants.SHA512)
                .build();
        PayloadJwt payloadJwt = PayloadJwt.builder()
                .body("{\"sub\":\"1234567890\",\"name\":\"John Doe\",\"iat\":1516239022}")
                .build();
        JwtResponse responseExpected = JwtResponse.builder()
                .token(token)
                .header(headerJwt)
                .payload(payloadJwt)
                .signature("SIGNATURE")
                .build();
        JwtRequest rq = new JwtRequest();
        rq.setAlgorithm(MessageDigestConstants.SHA512);
        rq.setToken(token);
        JwtResponse response = jwtService.parseJwt(rq);
        Assert.assertEquals(responseExpected, response);
    }
}
