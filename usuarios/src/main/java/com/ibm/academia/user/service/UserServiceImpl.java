package com.ibm.academia.user.service;

import com.ibm.academia.user.exception.NotFoundException;
import com.ibm.academia.user.model.User;
import com.ibm.academia.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findUserById(Long id) {
        Optional<User> foundUser =repository.findById(id);

        foundUser.orElseThrow(()->new NotFoundException("user with id "+id+" not found"));

        return foundUser;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAllUsers() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {

        repository.deleteById(id);
    }

    @Override
    @Transactional
    public User createUser(User user) {

        return repository.save(user);
    }

    @Override
    public User updateUser(User user, Long id) {
        Optional<User> userUpdated=repository.findById(id);
        userUpdated.orElseThrow(()->new NotFoundException("user with id "+id+" not found"));
            User existingUser=userUpdated.get();
            existingUser.setName(user.getName());
            existingUser.setLastName(user.getLastName());
            existingUser.setAge(user.getAge());
            existingUser.setEmail(user.getEmail());
            return repository.save(existingUser);
    }
}
