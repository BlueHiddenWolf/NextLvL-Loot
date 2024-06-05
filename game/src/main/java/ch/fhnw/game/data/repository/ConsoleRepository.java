package ch.fhnw.game.data.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ch.fhnw.game.data.domain.Console;

@Repository
public interface ConsoleRepository extends JpaRepository<Console, Long> {
    // Find a console by its model
    Console findByModel(String model);

    // Find consoles by manufacturer
    List<Console> findByManufacturer(String manufacturer);

    // Find consoles within a specific price range
    List<Console> findByPriceBetween(Double minPrice, Double maxPrice);

    // If consoles have categories or special offers, you can include methods like these:
    // List<Console> findByCategory(String category);
    // List<Console> findBySpecialOfferTrue();
}
