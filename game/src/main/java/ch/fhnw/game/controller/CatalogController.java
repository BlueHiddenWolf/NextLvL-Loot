package ch.fhnw.game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import ch.fhnw.game.business.service.CatalogService;
import ch.fhnw.game.data.domain.Catalog;
import ch.fhnw.game.data.domain.Game;
import ch.fhnw.game.data.domain.Console;

import java.util.List;

@RestController
@RequestMapping(path="/catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @GetMapping(path="/games/{id}", produces = "application/json")
    public ResponseEntity getGame(@PathVariable Long id) {
        try {
            Game game = catalogService.findGameById(id);
            return ResponseEntity.ok(game);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No game found with given id");
        }
    }

    @GetMapping(path="/games", produces = "application/json")
    public List<Game> getGameList() {
        List<Game> gameList = catalogService.getAllGames();
        return gameList;
    }

    @PostMapping(path="/games", consumes="application/json", produces = "application/json")
    public ResponseEntity addGame(@RequestBody Game game) {
        try {
            game = catalogService.addGame(game);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Game already exists with given name");
        }
        return ResponseEntity.ok(game);
    }

    @PutMapping(path="/games/{id}", consumes="application/json", produces = "application/json")
    public ResponseEntity updateGame(@PathVariable Long id, @RequestBody Game game) {
        try {
            game = catalogService.updateGame(id, game);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("No game found with given id");
        }
        return ResponseEntity.ok(game);
    }

    @DeleteMapping(path="/games/{id}")
    public ResponseEntity<String> deleteGame(@PathVariable Long id) {
        try {
            catalogService.deleteGame(id);
            return ResponseEntity.ok("Game with id " + id + " deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Game not found");
        }
    }

    @GetMapping(path="/consoles/{id}", produces = "application/json")
    public ResponseEntity<Console> getConsoleById(@PathVariable Long id) {
        try {
            Console console = catalogService.findConsoleById(id); 
            return ResponseEntity.ok(console);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping(path="/consoles", produces = "application/json")
    public List<Console> getAllConsoles() {
        return catalogService.findAllConsoles();
    }

    @PostMapping(path="/consoles", produces = "application/json")
    public ResponseEntity<Console> addConsole(@RequestBody Console console) {
        try {
            Console savedConsole = catalogService.addConsole(console);
            return ResponseEntity.ok(savedConsole);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping(path="/consoles/{id}", produces = "application/json")
    public ResponseEntity<Console> updateConsole(@PathVariable Long id, @RequestBody Console console) {
        try {
            Console updatedConsole = catalogService.updateConsole(id, console);
            return ResponseEntity.ok(updatedConsole);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path="/consoles/{id}")
    public ResponseEntity<?> deleteConsole(@PathVariable Long id) {
        try {
            catalogService.deleteConsole(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint for getting catalog by category with current offers
    @GetMapping(path="/offers/{category}")
    public ResponseEntity<Catalog> getCatalogByCategory(@PathVariable String category) {
        Catalog catalog = catalogService.getCatalogByCategory(category);
        return ResponseEntity.ok(catalog);
    }

    // Endpoint for getting bundle offers
    @GetMapping(path="/bundle-offers/{category}")
    public ResponseEntity<Catalog> getBundleOffers(@PathVariable String category) {
        Catalog catalog = catalogService.getBundleOffers(category);
        return ResponseEntity.ok(catalog);
    }
    
}