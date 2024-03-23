package com.example.librarymanagementsystem.helpers;

import com.example.librarymanagementsystem.entity.BookEntity;
import com.example.librarymanagementsystem.entity.ReservationEntity;
import com.example.librarymanagementsystem.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ReservationHelper {
    private final ReservationRepository reservationRepository;
    public List<BookEntity> getReservedBooksByUserId(Integer userId) throws Exception{
        try {
            List<ReservationEntity> reservationEntities = reservationRepository.getReservationEntitiesByUserEntity_Id(userId);
            return reservationEntities.stream().map(ReservationEntity::getBookEntity).collect(Collectors.toList());
        }catch (Exception e){
            throw new Exception("unable to fetch records");
        }
    }
}
