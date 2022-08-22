package controllers;

import common.EntityDtoConverter;
import dtos.UserResponse;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import services.UserService.UserService;

@RestController
public class UsersController {

    @Autowired
    private UserService userService;

    @Autowired
    private EntityDtoConverter entityDtoConverter;

    @GetMapping("/User/login/{username}/{password}")
    public ResponseEntity<UserResponse> login(@PathVariable String username,@PathVariable String password) throws Exception{
        User u = userService.login(username,password);
        return new ResponseEntity<>(entityDtoConverter.convertUserToUserResponse(u), HttpStatus.OK);
    }

}
