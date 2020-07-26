package com.fashion.backendfinal.user.pojo;

import lombok.*;

@Data
public class UserAuth{
    String email;
    String pass;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
