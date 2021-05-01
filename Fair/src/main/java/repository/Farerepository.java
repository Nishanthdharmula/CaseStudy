package repository;


import model.Fare;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Farerepository extends MongoRepository<Fare, Integer> {
}
