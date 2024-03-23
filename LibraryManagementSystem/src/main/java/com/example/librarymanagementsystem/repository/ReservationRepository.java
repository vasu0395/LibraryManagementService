package com.example.librarymanagementsystem.repository;

import com.example.librarymanagementsystem.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<ReservationEntity,Integer> {
    Optional<ReservationEntity> getReservationEntitiesByIdAndStatus(Integer id, boolean status);
    List<ReservationEntity> getReservationEntitiesByUserEntity_Id(Integer userId);
}
