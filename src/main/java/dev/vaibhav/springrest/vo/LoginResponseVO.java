package dev.vaibhav.springrest.vo;

import dev.vaibhav.springrest.entity.ApplicationUser;

public class LoginResponseVO {
    private ApplicationUser user;
    private String jwt;

    public LoginResponseVO() {}

    public LoginResponseVO(ApplicationUser user, String jwt) {
        this.user = user;
        this.jwt = jwt;
    }

    public ApplicationUser getUser() {
        return user;
    }

    public void setUser(ApplicationUser user) {
        this.user = user;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
