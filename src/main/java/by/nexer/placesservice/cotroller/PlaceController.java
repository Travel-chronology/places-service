package by.nexer.placesservice.cotroller;

import by.nexer.placesservice.entity.PlaceEntity;
import by.nexer.placesservice.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/place")
@RequiredArgsConstructor
public class PlaceController {
    private final PlaceService placeService;

    @GetMapping()
    public List<PlaceEntity> getAll() {
        return placeService.getAll();
    }

    @GetMapping("/{id}")
    public PlaceEntity getPlacesById(@PathVariable Long id) {
        return placeService.getPlacesById(id);
    }

    @GetMapping("/{id}/images")
    public String getImagesForPlace(@PathVariable Long id) {
        return placeService.getImagesForPlace(id);
    }

    @PostMapping()
    public PlaceEntity createPlace(@RequestBody PlaceEntity place) {
        return placeService.createPlace(place);
    }

    @PostMapping("/{id}")
    public PlaceEntity updatePlace(@RequestBody PlaceEntity place) {
        return placeService.updatePlace(place);
    }

    @DeleteMapping("/{id}")
    public String deletePlace(@PathVariable Long id) {
        placeService.deletePlace(id);
        return "The place was deleted";
    }

    @GetMapping("/filter")
    public List<PlaceEntity> getPlacesWithFilter(@RequestParam(required = false) Long tripId,
                                                 @RequestParam(required = false) String country,
                                                 @RequestParam(required = false) String email,
                                                 @RequestParam(required = false) String startDate,
                                                 @RequestParam(required = false) String endDate) {
        return placeService.getPlacesWithFilter(tripId, country, email, startDate, endDate);
    }
}

