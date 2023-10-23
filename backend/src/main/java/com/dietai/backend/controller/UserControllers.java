package com.dietai.backend.controller;

<<<<<<< HEAD
import com.dietai.backend.exceptions.PersonNotFoundException;
=======
>>>>>>> origin/main
import com.dietai.backend.model.dto.UserDto;
import com.dietai.backend.model.entities.User;
import com.dietai.backend.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
=======
import org.springframework.web.bind.annotation.PostMapping;
>>>>>>> origin/main
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserControllers {

  private UserServices userService;

  @Autowired
  public UserControllers(UserServices userService) {
    this.userService = userService;
  }

  @PostMapping
  public ResponseEntity<UserDto> createUser(@RequestBody User user) {

    User newUser = userService.createUser(user);
    UserDto userInfoReturned = newUser.toDto();

    return ResponseEntity.status(HttpStatus.CREATED).body(userInfoReturned);

  }

<<<<<<< HEAD
  @GetMapping("/{userId}")
  public ResponseEntity findUserById(@PathVariable Long userId) {

    try {

      User userFound = this.userService.getUserById(userId);
      UserDto userFoundReturned = userFound.toDto();

      return ResponseEntity.status(HttpStatus.OK).body(userFoundReturned);

    } catch (PersonNotFoundException exception) {
      return ResponseEntity.status(exception.getHttpStatusCode()).body(exception.getMessage());
    }

  }

  @PutMapping("/{userId}")
  public ResponseEntity updateUser(@PathVariable Long userId, @RequestBody User userToUpdate) {

    try {
      User userUpdated = this.userService.updateUser(userId, userToUpdate);
      UserDto userUpdatedResponse = userUpdated.toDto();

      return ResponseEntity.status(HttpStatus.OK).body(userUpdatedResponse);

    } catch (PersonNotFoundException exception) {

      return ResponseEntity.status(exception.getHttpStatusCode()).body(exception.getMessage());

    }

  }

=======
>>>>>>> origin/main
}
