package controller;




import model.Fare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import service.FareService;

@RestController
@RequestMapping("/price")
public class fareController {
	
	
    @Autowired
    FareService fareService;

    @PostMapping("/flights/Fare")

    public Object getFareEstimator(@RequestBody Fare fare)
    {


        return fareService.fareEstimator(fare);
    }

    @PostMapping("/flights/addFare")
    public ResponseEntity<?> saveFlightDetails(@RequestBody Fare fare) {
        fareService.saveFare(fare);
        return new ResponseEntity<>("Added fare with number: "+fare.getFareId(), HttpStatus.OK);
    }
}
