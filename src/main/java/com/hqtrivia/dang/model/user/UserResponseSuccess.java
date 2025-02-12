package com.hqtrivia.dang.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserResponseSuccess {
    @JsonProperty
    private Long id;

    @JsonProperty
    private String username;

    @JsonProperty
    private String email;

    @JsonProperty
    private String role;

    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDateTime created_at;

    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDateTime updated_at;

    private String jwt_token;
}
