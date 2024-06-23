package by.nexer.placesservice.repository;

import by.nexer.placesservice.entity.PlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PlaceRepository extends JpaRepository<PlaceEntity, Long> {
    @Query("SELECT p FROM PlaceEntity p " +
            "JOIN TripEntity t ON p.trip.id = t.id " +
            "JOIN t.users u " +
            "WHERE (:tripId IS NULL OR p.trip.id = :tripId) " +
            "AND (:country IS NULL OR p.country = :country)" +
            "AND (:email IS NULL OR u.email = :email) " +
            "AND p.visitDate BETWEEN :startDate and :endDate ")
    List<PlaceEntity> findAllByTripIdAndCountyAndEmailAndDate(@Param("tripId") Long tripId,
                                             @Param("country") String country,
                                             @Param("email") String email,
                                             @Param("startDate") LocalDate startDate,
                                             @Param("endDate") LocalDate endDate);
}
