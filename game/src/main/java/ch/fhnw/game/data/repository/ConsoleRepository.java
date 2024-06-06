package ch.fhnw.game.data.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ch.fhnw.game.data.domain.Console;

@Repository
public interface ConsoleRepository extends JpaRepository<Console, Long> {

    List<Console> findByIsOnSpecial(boolean isOnSpecial);
  
    // Find a console by its model
    Console findByModel(String model);

    // Find consoles by manufacturer
    List<Console> findByManufacturer(String manufacturer);

    // Find consoles within a specific price range
    List<Console> findByPriceBetween(Double minPrice, Double maxPrice);

}
