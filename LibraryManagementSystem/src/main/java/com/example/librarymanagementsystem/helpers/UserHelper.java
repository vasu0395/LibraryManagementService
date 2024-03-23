package com.example.librarymanagementsystem.helpers;

import com.example.librarymanagementsystem.entity.UserEntity;
import com.example.librarymanagementsystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserHelper {
    private final UserRepository userRepository;
    public UserEntity getUserById(Integer userId){
        UserEntity userEntity = userRepository.getById(userId);
        return userEntity;
    }
}
