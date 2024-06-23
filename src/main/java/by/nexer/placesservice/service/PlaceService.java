package by.nexer.placesservice.service;

import by.nexer.placesservice.entity.PlaceEntity;
import by.nexer.placesservice.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceService {
    private final PlaceRepository placeRepository;

    public List<PlaceEntity> getAll() {
        return placeRepository.findAll();
    }

    public PlaceEntity getPlacesById(Long id) {
        return placeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Place not found for id: " + id));
    }

    public String getImagesForPlace(Long id){
        PlaceEntity placeEntity = placeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Place not found for id: " + id));
        return placeEntity.getPhotoUrl();
    }
    public PlaceEntity createPlace(PlaceEntity entity) {
        return placeRepository.save(entity);
    }

    public PlaceEntity updatePlace(PlaceEntity entity) {
        return placeRepository.save(entity);
    }

    public void deletePlace(Long id) {
        placeRepository.deleteById(id);
    }

    public List<PlaceEntity> getPlacesWithFilter(Long tripId, String country, String email, String startDate, String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDateFormat = LocalDate.of(1900, 12, 31);
        LocalDate endDateFormat = LocalDate.of(2200, 12, 31);

        if (startDate != null && !startDate.isEmpty()) {
            startDateFormat = LocalDate.parse(startDate, formatter);
        }

        if (endDate != null && !endDate.isEmpty()) {
            endDateFormat = LocalDate.parse(endDate, formatter);
        }

        return placeRepository.findAllByTripIdAndCountyAndEmailAndDate(tripId, country, email, startDateFormat, endDateFormat);
    }
}
