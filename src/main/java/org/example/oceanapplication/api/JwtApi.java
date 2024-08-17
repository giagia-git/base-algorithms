package org.example.oceanapplication.api;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.oceanapplication.model.jwt.dto.JwtRequest;
import org.example.oceanapplication.model.jwt.dto.JwtResponse;
import org.example.oceanapplication.service.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/jwt")
public class JwtApi {
    private final JwtService jwtService;

    private JwtApi(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "API not found")
    })
    @RequestMapping(value = "/decode", method = RequestMethod.POST)
    public ResponseEntity<JwtResponse> decodeJsonWebToken(JwtRequest rq) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (!rq.validate()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(this.jwtService.parseJwt(rq), HttpStatus.OK);
    }
}
