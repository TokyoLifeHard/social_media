package ru.em.tt.registration.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.em.tt.registration.entity.User;
import ru.em.tt.registration.payload.SingUpRequest;
import ru.em.tt.registration.payload.SingUpResponse;
import ru.em.tt.registration.service.UserService;
import ru.em.tt.registration.validations.ResponseErrorValidation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController("api/v1/singup")
public class SingUpController {

    private UserService userService;


    public SingUpController(UserService userService) {
        this.userService = userService;

    }

    @PostMapping
    public ResponseEntity<Object> singUp(@RequestBody SingUpRequest singUpRequest, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                errors.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return new ResponseEntity<Object>(errors, HttpStatusCode.valueOf(400));
        }


        User user = new User();
        user.setUsername(singUpRequest.getUsername());
        user.setEmail(singUpRequest.getEmail());
        user.setPassword(user.getPassword());

        this.userService.saveUser(user);

        return ResponseEntity.ok(new SingUpResponse("User registered successfully", 200));
    }
}
