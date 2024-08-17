package org.example.oceanapplication.service;

import jakarta.validation.constraints.NotNull;
import org.example.oceanapplication.model.jwt.dto.JwtRequest;
import org.example.oceanapplication.model.jwt.dto.JwtResponse;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public interface JwtService {
    JwtResponse parseJwt(@NotNull JwtRequest rq) throws UnsupportedEncodingException, NoSuchAlgorithmException;
}
