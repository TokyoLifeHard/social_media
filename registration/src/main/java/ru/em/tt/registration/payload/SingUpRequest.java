package ru.em.tt.registration.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import ru.em.tt.registration.annotations.ValidEmail;

public class SingUpRequest {

    @NotBlank(message = "Username is required")
    private String username;

    @Email(message = "It shoud have email format")
    @NotBlank(message = "Email is required")
    @ValidEmail
    private String email;

    @NotEmpty
    @Size(min = 6)
    private String password;

    @NotEmpty
    @Size(min = 6)
    private String confirmPassword;

    public SingUpRequest(String username, String email, String password, String confirmPassword) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
