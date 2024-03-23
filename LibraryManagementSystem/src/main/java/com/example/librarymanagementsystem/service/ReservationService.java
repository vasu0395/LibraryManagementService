package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.entity.BookEntity;
import com.example.librarymanagementsystem.entity.ReservationEntity;
import com.example.librarymanagementsystem.entity.UserEntity;
import com.example.librarymanagementsystem.helpers.BookHelper;
import com.example.librarymanagementsystem.helpers.UserHelper;
import com.example.librarymanagementsystem.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final BookHelper bookHelper;
    private final UserHelper userHelper;

    public ReservationEntity getReservationById(Integer reservationId) throws Exception{
        try {
            Optional<ReservationEntity> reservationEntity = reservationRepository.getReservationEntitiesByIdAndStatus(reservationId,true);
            if(reservationEntity.isPresent())
                return reservationEntity.get();

            throw new Exception("entity not found");
        }catch (Exception e){
            throw new Exception("unable to fetch reservation by Id");
        }
    }

    public ReservationEntity createReservation(Integer userId,Integer bookId) throws Exception{
        return updateReservation(userId,bookId,true);
    }

    public ReservationEntity removeReservation(Integer userId,Integer bookId) throws Exception{
        return updateReservation(userId,bookId,false);
    }

    private ReservationEntity updateReservation(Integer userId,Integer bookId,Boolean reservationStatus) throws  Exception{
        UserEntity userEntity = userHelper.getUserById(userId);
        BookEntity bookEntity = bookHelper.getBookById(bookId);
        ReservationEntity reservationEntity = ReservationEntity.builder().bookEntity(bookEntity).userEntity(userEntity).status(reservationStatus).build();
        reservationRepository.save(reservationEntity);
        return reservationEntity;
    }
}
