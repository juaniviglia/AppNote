package AppNote.controllers;

import AppNote.common.EntityDtoConverter;
import AppNote.dtos.UserResponse;
import AppNote.entities.User;
import AppNote.services.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @Autowired
    private UserService userService;

    @Autowired
    private EntityDtoConverter entityDtoConverter;

    @GetMapping("/User/login/{username}/{password}")
    public ResponseEntity<UserResponse> login(@PathVariable String username, @PathVariable String password) throws Exception{
        User u = userService.login(username,password);
        return new ResponseEntity<>(entityDtoConverter.convertUserToUserResponse(u), HttpStatus.OK);
    }

}
