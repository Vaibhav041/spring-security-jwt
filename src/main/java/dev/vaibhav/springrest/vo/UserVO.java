package dev.vaibhav.springrest.vo;

public class UserVO {
    private String username;
    private String password;

    public UserVO() {super();}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
