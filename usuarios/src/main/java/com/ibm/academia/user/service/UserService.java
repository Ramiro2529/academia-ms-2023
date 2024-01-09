package com.ibm.academia.user.service;


import com.ibm.academia.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findUserById(Long id);
    List<User> findAllUsers();
    void deleteUserById(Long id);
    User createUser(User user);

    User updateUser(User user, Long id);






}
