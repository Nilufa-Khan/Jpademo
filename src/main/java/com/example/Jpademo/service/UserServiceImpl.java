package com.example.Jpademo.service;

import com.example.Jpademo.domain.User;
import com.example.Jpademo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    UserRepository userRepository;
    @Autowired
    UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getUser() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User updateUser(User user, int userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            return null;
        }
        User existingUser = optionalUser.get();
        if(user.getEmail()!=null){
            existingUser.setEmail(user.getEmail());
        }
        if(user.getFirstName()!=null){
            existingUser.setFirstName(user.getFirstName());
        }
        if(user.getLastName()!=null){
            existingUser.setLastName(user.getLastName());
        }
        if(user.getPassword()!=null){
            existingUser.setPassword(user.getPassword());
        }


//    Optional is a interface     Optional is a predefined object we r storing data based on id       built in package of util,
//        http://localhost:8080/userdata/v1/nilu@12@gmail.com or we can provide (id) here email is primary key

        return userRepository.save(existingUser);
    }

    @Override
    public boolean deleteUserById(int userId) {
       userRepository.deleteById(userId);
       return true;

    }

    @Override
    public List<User> getUserByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

}
