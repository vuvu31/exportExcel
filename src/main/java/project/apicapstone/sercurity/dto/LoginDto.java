package project.apicapstone.sercurity.dto;

import javax.validation.constraints.NotBlank;

public class LoginDto {
    @NotBlank(message = "Not blank")
    private String username;
    @NotBlank(message = "Not blank")
    private String password;

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
