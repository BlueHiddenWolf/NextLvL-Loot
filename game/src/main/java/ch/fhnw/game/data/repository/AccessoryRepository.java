package ch.fhnw.game.data.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ch.fhnw.game.data.domain.Accessory;

@Repository
public interface AccessoryRepository extends JpaRepository<Accessory, Long> {
    
    // Find an accessory by its type
    Accessory findByType(String type);

    // Find accessories by manufacturer
    List<Accessory> findByManufacturer(String manufacturer);

    // Find accessories within a specific price range
    List<Accessory> findByPriceBetween(Double minPrice, Double maxPrice);

}
