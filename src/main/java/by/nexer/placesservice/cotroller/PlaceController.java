package by.nexer.placesservice.cotroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/place")
public class PlaceController {

    @GetMapping()
    public String getPlace(){
        return "1,2,3";
    }
}

