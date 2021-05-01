package service;



import model.Fare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import repository.Farerepository;

@Service
public class FareService {

    @Autowired
    Farerepository fareRepository;

    @Autowired
    private RestTemplate template;

    @Autowired
    private SequenceIdService sequenceIdService;


    public Object fareEstimator(@RequestBody Fare fare) {
        try {
            fare.setGst(0.18);
            fare.setConvenienceFee(0.2);

            if (fare.getExtraLuggage() == 0)
            {
                double bookingfares = (fare.getPrice() + fare.getPrice() * fare.getConvenienceFee()
                        + fare.getPrice() * fare.getGst());
                fare.setTotalbookingPrice(bookingfares);
                fareRepository.save(fare);
                return bookingfares;
            }
            else if (fare.getExtraLuggage() > 0 && fare.getExtraLuggage() < 30) {
                double bookingfares = (fare.getPrice() + fare.getPrice() * fare.getConvenienceFee()+
                        fare.getPrice() * fare.getGst()) 
                          + fare.getExtraLuggage() * 40;
                fare.setTotalbookingPrice(bookingfares);
                fareRepository.save(fare);
                return bookingfares;
            }
            else
            {
                throw new Exception();
            }
        }
        catch (Exception e)
        {

            return new ResponseEntity<>("Luggage exceded the maximum weight", HttpStatus.BAD_REQUEST);

        }
    }


    public void saveFare(@RequestBody Fare fare)
    {
        fareRepository.save(fare);
    }

}
