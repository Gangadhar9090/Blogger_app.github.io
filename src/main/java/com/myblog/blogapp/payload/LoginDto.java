package com.myblog.blogapp.payload;

import lombok.Data;

@Data
public class LoginDto {
    private String username0rEmail;
    private String password;

    public String getUsername0rEmail() {
        return username0rEmail;
    }

    public void setUsername0rEmail(String username0rEmail) {
        this.username0rEmail = username0rEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
