package ch.fhnw.game.business.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.fhnw.game.data.domain.Catalog;
import ch.fhnw.game.data.domain.Console;
import ch.fhnw.game.data.domain.Game;
import ch.fhnw.game.data.domain.Accessory;
import ch.fhnw.game.data.repository.GameRepository;
import ch.fhnw.game.data.repository.AccessoryRepository;
import ch.fhnw.game.data.repository.ConsoleRepository;

@Service
public class CatalogService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private ConsoleRepository consoleRepository;

    @Autowired
    private AccessoryRepository accessoryRepository;

    public Game findGameById(Long id) {
        try {
            Optional<Game> game = gameRepository.findById(id);
            if (game.isPresent()) {
                return game.get();
            } else {
                throw new RuntimeException("Game with id " + id + " not found");
            }
        } catch (Exception e) {
            throw new RuntimeException("Game with id " + id + " not found", e);
        }
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Game addGame(Game game) throws Exception {
        if (game.getTitle() != null) {
            if (gameRepository.findByTitle(game.getTitle()) == null)
                return gameRepository.save(game);
            throw new Exception("Game " + game.getTitle() + " already exists");
        }
        throw new Exception("Invalid game title");
    }

    public Game updateGame(Long id, Game game) throws Exception {
        Optional<Game> gameToUpdate = gameRepository.findById(id);
        if (gameToUpdate.isPresent()) {
            Game updatedGame = gameToUpdate.get();
            if (game.getTitle() != null)
                updatedGame.setTitle(game.getTitle());
            if (game.getGenre() != null)
                updatedGame.setGenre(game.getGenre());
            if (game.getDeveloper() != null)
                updatedGame.setDeveloper(game.getDeveloper());
            if (game.getPrice() != null)
                updatedGame.setPrice(game.getPrice());
            return gameRepository.save(updatedGame);
        }
        throw new Exception("Game with id " + id + " does not exist");
    }

    public void deleteGame(Long id) throws Exception {
        if (gameRepository.existsById(id)) {
            gameRepository.deleteById(id);
        } else {
            throw new Exception("Game with id " + id + " does not exist");
        }
    }

    public List<Console> findAllConsoles() {
        return consoleRepository.findAll();
    }

    public Console addConsole(Console console) throws Exception {
        if (console.getModel() != null && consoleRepository.findByModel(console.getModel()) == null) {
            return consoleRepository.save(console);
        } else {
            throw new Exception("Console already exists or model is null");
        }
    }

    public Console updateConsole(Long id, Console console) throws Exception {
        Optional<Console> consoleToUpdate = consoleRepository.findById(id);
        if (consoleToUpdate.isPresent()) {
            Console updatedConsole = consoleToUpdate.get();
            if (console.getModel() != null) updatedConsole.setModel(console.getModel());
            if (console.getManufacturer() != null) updatedConsole.setManufacturer(console.getManufacturer());
            if (console.getPrice() != null) updatedConsole.setPrice(console.getPrice());
            if (console.getImage() != null) updatedConsole.setImage(console.getImage());
            return consoleRepository.save(updatedConsole);
        } else {
            throw new Exception("Console not found");
        }
    }

    public Console findConsoleById(Long id) throws Exception {
        Optional<Console> console = consoleRepository.findById(id);
        if (console.isPresent()) {
            return console.get();
        } else {
            throw new Exception("Console with id " + id + " not found");
        }
    }

    public void deleteConsole(Long id) throws Exception {
        if (consoleRepository.existsById(id)) {
            consoleRepository.deleteById(id);
        } else {
            throw new Exception("Console not found");
        }
    }

    public List<Console> findConsolesByManufacturer(String manufacturer) {
        return consoleRepository.findByManufacturer(manufacturer);
    }

    public List<Console> findConsolesByPriceRange(Double minPrice, Double maxPrice) {
        return consoleRepository.findByPriceBetween(minPrice, maxPrice);
    }

    public List<Accessory> findAllAccessories() {
        return accessoryRepository.findAll();
    }

    public Accessory addAccessory(Accessory accessory) throws Exception {
        if (accessory.getType() != null && accessoryRepository.findByType(accessory.getType()) == null) {
            return accessoryRepository.save(accessory);
        } else {
            throw new Exception("Accessory already exists or type is null");
        }
    }

    public Accessory updateAccessory(Long id, Accessory accessory) throws Exception {
        Optional<Accessory> accessoryToUpdate = accessoryRepository.findById(id);
        if (accessoryToUpdate.isPresent()) {
            Accessory updatedAccessory = accessoryToUpdate.get();
            if (accessory.getType() != null) updatedAccessory.setType(accessory.getType());
            if (accessory.getManufacturer() != null) updatedAccessory.setManufacturer(accessory.getManufacturer());
            if (accessory.getPrice() != null) updatedAccessory.setPrice(accessory.getPrice());
            if (accessory.getImage() != null) updatedAccessory.setImage(accessory.getImage());
            return accessoryRepository.save(updatedAccessory);
        } else {
            throw new Exception("Accessory not found");
        }
    }

    public Accessory findAccessoryById(Long id) throws Exception {
        Optional<Accessory> accessory = accessoryRepository.findById(id);
        if (accessory.isPresent()) {
            return accessory.get();
        } else {
            throw new Exception("Accessory with id " + id + " not found");
        }
    }

    public void deleteAccessory(Long id) throws Exception {
        if (accessoryRepository.existsById(id)) {
            accessoryRepository.deleteById(id);
        } else {
            throw new Exception("Accessory not found");
        }
    }

    public List<Accessory> findAccessoriesByManufacturer(String manufacturer) {
        return accessoryRepository.findByManufacturer(manufacturer);
    }

    public List<Accessory> findAccessoriesByPriceRange(Double minPrice, Double maxPrice) {
        return accessoryRepository.findByPriceBetween(minPrice, maxPrice);
    }

    // Business Logic to get current offer according to the category of the games
    private String getCurrentOffer(String category) {
        String currentOffer = "No special offer for your selected category. Do check back again.";
        if ("Action".equalsIgnoreCase(category))
            currentOffer = "20% off on all Action games!!!";
        else if ("RPG".equalsIgnoreCase(category))
            currentOffer = "Buy one RPG game, get one free!!!";
        return currentOffer;
    }

    public Catalog getCatalogByCategory(String category) {
        String currentOffer = getCurrentOffer(category);
        List<Game> gameList = gameRepository.findByCategory(category);
        Catalog catalog = new Catalog();
        catalog.setGameList(gameList);
        catalog.setCurrentOffer(currentOffer);
        return catalog;
    }


    // New business logic

    // Search games by developer
    public List<Game> getGamesByDeveloper(String developer) {
        return gameRepository.findByDeveloper(developer);
    }

    // Filter games by price range
    public List<Game> getGamesByPriceRange(Double minPrice, Double maxPrice) {
        return gameRepository.findByPriceBetween(minPrice, maxPrice);
    }

    public Catalog getBundleOffers(String category) {
        List<Game> games = gameRepository.findByCategory(category);
        List<Console> consoles = consoleRepository.findAll();  // This fetches all consoles, adjust if needed
        String offerDetails = "Special bundle offer: Buy any game with a console for extra savings!";

        Catalog catalog = new Catalog();
        catalog.setGameList(games);
        catalog.setConsoleList(consoles);
        catalog.setCurrentOffer(offerDetails);
        return catalog;
    }
}