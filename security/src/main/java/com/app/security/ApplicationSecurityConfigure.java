package com.app.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public interface ApplicationSecurityConfigure {
    void Configure(HttpSecurity http) throws Exception;
}
