package org.example.oceanapplication.model.jwt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtRequest {
    private String token;
    private String algorithm;

    public boolean validate() {
        if (this.token == null || this.token.isEmpty()) {
            return false;
        }
        if (this.algorithm == null || this.algorithm.isEmpty()) {
            return false;
        }
        return true;
    }
}
