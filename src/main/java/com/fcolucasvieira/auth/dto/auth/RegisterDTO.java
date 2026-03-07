package com.fcolucasvieira.auth.dto.auth;

import com.fcolucasvieira.auth.domain.user.UserRole;

public record RegisterDTO(String login,
                          String password,
                          UserRole role) {
}
