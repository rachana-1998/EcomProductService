package com.rachana.EcomProductService.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class JwtPayloadDTO {
    @JsonProperty("createdAt")
    private Long createdAt;
    @JsonProperty("expiryAt")
    private Long expiryAt;
    @JsonProperty("userId")
    private int userId;
    @JsonProperty("roles")
    private String[] roles;
}
