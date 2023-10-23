package com.dietai.backend.service;

<<<<<<< HEAD
import com.dietai.backend.exceptions.PersonNotFoundException;
import com.dietai.backend.model.entities.User;
import com.dietai.backend.model.repositories.UserRepository;
import java.util.Optional;
=======
import com.dietai.backend.model.entities.User;
import com.dietai.backend.model.repositories.UserRepository;
>>>>>>> origin/main
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServices {

  private UserRepository userRepository;

  @Autowired
  public UserServices(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User createUser(User newUser) {
    String password = newUser.getPassword();
    String hashedString = new BCryptPasswordEncoder().encode(password);
    newUser.setPassword(hashedString);
    return this.userRepository.save(newUser);
  }

<<<<<<< HEAD
  public User getUserById(Long id) throws PersonNotFoundException {
    Optional<User> userOptional = this.userRepository.findById(id);

    if (userOptional.isEmpty()) {
      throw new PersonNotFoundException();
    }

    return userOptional.get();
  }

  public User updateUser(Long userToUpdateId, User userToUpdate) throws PersonNotFoundException {

    User userFound = this.getUserById(userToUpdateId);

    userFound.setUsername(userToUpdate.getUsername());
    userFound.setPassword(userToUpdate.getPassword());
    userFound.setDiets(userToUpdate.getDiets());

    return this.createUser(userFound);

  }

=======
>>>>>>> origin/main
}
