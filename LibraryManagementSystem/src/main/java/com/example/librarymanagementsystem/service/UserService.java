package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.entity.BookEntity;
import com.example.librarymanagementsystem.entity.UserEntity;
import com.example.librarymanagementsystem.helpers.ReservationHelper;
import com.example.librarymanagementsystem.repository.UserRepository;
import com.example.librarymanagementsystem.request.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ReservationHelper reservationHelper;
    public UserEntity getUserByName(String userName) throws Exception{
        Optional<UserEntity> userEntity = userRepository.findByName(userName);
        if(userEntity.isPresent()){
            return userEntity.get();
        }

        throw new Exception("Entity Not Found");
    }

    public UserEntity createUser(CreateUserRequest request, boolean isLibrarian) throws Exception{
        try {
            Integer accessCardNumber = getAccessCardNumber();
            UserEntity user = UserEntity.builder().name(request.getName()).isLibrarian(isLibrarian).accessCardNumber(accessCardNumber).build();
            return userRepository.save(user);
        }catch (Exception e){
            throw new Exception("Unable to create new entity");
        }
    }
    public List<BookEntity> getReservedBooks(Integer userId) throws Exception{
        return reservationHelper.getReservedBooksByUserId(userId);
    }

    private Integer getAccessCardNumber(){
        Long currentTime = System.currentTimeMillis();
        Long accessCardSalt = (long) (Math.random() % 1e5);

        return (int) ((currentTime + accessCardSalt) % 1e5);
    }
}
