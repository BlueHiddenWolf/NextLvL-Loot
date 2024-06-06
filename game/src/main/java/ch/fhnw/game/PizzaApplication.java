package ch.fhnw.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.fhnw.game.business.service.CatalogService;
import ch.fhnw.game.business.service.SpecialOfferService;
import ch.fhnw.game.data.domain.Game;
import ch.fhnw.game.data.domain.Accessory;
import ch.fhnw.game.data.domain.Console;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
@RestController
@EnableScheduling
@Hidden // Hide this controller from the Swagger UI
public class PizzaApplication {

	@Autowired
    private CatalogService catalogService;

    @Autowired
    private SpecialOfferService specialOfferService;

	public static void main(String[] args) {
		SpringApplication.run(PizzaApplication.class, args);
	}
	

	// Use this method to initialize placeholder data without using Postman
	// If you are persisting data in a file (see application.properties), initializing data that already exists will cause an error during starting the application
	// To resolve the error, delete the file and restart the application
	@PostConstruct
	private void initPlaceholderData() throws Exception {

		// Action-Adventure
        Game game = new Game();
        game.setTitle("The Legend of Zelda: Breath of the Wild");
        game.setGenre("Action-Adventure");
        game.setDeveloper("Nintendo");
        game.setPrice(59.99);
        game.setImage("https://upload.wikimedia.org/wikipedia/en/c/c6/The_Legend_of_Zelda_Breath_of_the_Wild.jpg");
        catalogService.addGame(game);

        game = new Game();
        game.setTitle("Uncharted 4: A Thief's End");
        game.setGenre("Action-Adventure");
        game.setDeveloper("Naughty Dog");
        game.setPrice(19.99);
        game.setImage("https://m.media-amazon.com/images/M/MV5BMTYzYzIxMjktMDM4NS00MTM5LWJlMDgtNDRhMDNhOGRmY2EwXkEyXkFqcGdeQXVyMTk2OTAzNTI@._V1_.jpg");
        catalogService.addGame(game);

        // RPG
        game = new Game();
        game.setTitle("The Witcher 3: Wild Hunt");
        game.setGenre("RPG");
        game.setDeveloper("CD Projekt Red");
        game.setPrice(39.99);
        game.setImage("https://upload.wikimedia.org/wikipedia/en/thumb/0/0c/Witcher_3_cover_art.jpg/220px-Witcher_3_cover_art.jpg");
        catalogService.addGame(game);

        game = new Game();
        game.setTitle("Final Fantasy XV");
        game.setGenre("RPG");
        game.setDeveloper("Square Enix");
        game.setPrice(29.99);
        game.setImage("https://upload.wikimedia.org/wikipedia/en/5/5a/FF_XV_cover_art.jpg");
        catalogService.addGame(game);

        // Shooter
        game = new Game();
        game.setTitle("Call of Duty: Modern Warfare");
        game.setGenre("Shooter");
        game.setDeveloper("Infinity Ward");
        game.setPrice(59.99);
        game.setImage("https://image.api.playstation.com/vulcan/ap/rnd/202306/2400/ac505d57a46e24dd96712263d89a150cb443af288c025ff2.jpg");
        catalogService.addGame(game);

        game = new Game();
        game.setTitle("Overwatch");
        game.setGenre("Shooter");
        game.setDeveloper("Blizzard Entertainment");
        game.setPrice(39.99);
        game.setImage("https://upload.wikimedia.org/wikipedia/en/thumb/5/51/Overwatch_cover_art.jpg/220px-Overwatch_cover_art.jpg");
        catalogService.addGame(game);

        // Sports
        game = new Game();
        game.setTitle("FIFA 24");
        game.setGenre("Sports");
        game.setDeveloper("EA Sports");
        game.setPrice(49.99);
        game.setImage("https://www.gamechampions.com/media/kfbj4edv/fifa-24-standard-edition-cover-fc-24.webp?rmode=max&width=770&height=770");
        catalogService.addGame(game);

        game = new Game();
        game.setTitle("NBA 2K24");
        game.setGenre("Sports");
        game.setDeveloper("Visual Concepts");
        game.setPrice(59.99);
        game.setImage("https://upload.wikimedia.org/wikipedia/en/4/48/NBA_2K24_cover_art.jpg");
        catalogService.addGame(game);

        // Strategy
        game = new Game();
        game.setTitle("Civilization VI");
        game.setGenre("Strategy");
        game.setDeveloper("Firaxis Games");
        game.setPrice(29.99);
        game.setImage("https://upload.wikimedia.org/wikipedia/en/3/3b/Civilization_VI_cover_art.jpg");
        catalogService.addGame(game);

        game = new Game();
        game.setTitle("StarCraft II");
        game.setGenre("Strategy");
        game.setDeveloper("Blizzard Entertainment");
        game.setPrice(39.99);
        game.setImage("https://upload.wikimedia.org/wikipedia/en/2/20/StarCraft_II_-_Box_Art.jpg");
        catalogService.addGame(game);

        Console console = new Console();
        console.setModel("Nintendo Switch");
        console.setManufacturer("Nintendo");
        console.setPrice(299.99);
        console.setImage("https://upload.wikimedia.org/wikipedia/commons/thumb/7/76/Nintendo-Switch-Console-Docked-wJoyConRB.jpg/640px-Nintendo-Switch-Console-Docked-wJoyConRB.jpg");
        catalogService.addConsole(console);

        console = new Console();
        console.setModel("PlayStation 4");
        console.setManufacturer("Sony");
        console.setPrice(249.99);
        console.setImage("https://upload.wikimedia.org/wikipedia/commons/5/56/PS-4-Pro.jpg?20191215095448");
        catalogService.addConsole(console);

        console = new Console();
        console.setModel("PlayStation 5");
        console.setManufacturer("Sony");
        console.setPrice(499.99);
        console.setImage("https://upload.wikimedia.org/wikipedia/commons/thumb/8/88/Immagine_Playstation_5.jpg/640px-Immagine_Playstation_5.jpg");
        catalogService.addConsole(console);

        console = new Console();
        console.setModel("Xbox One");
        console.setManufacturer("Microsoft");
        console.setPrice(229.99);
        console.setImage("https://upload.wikimedia.org/wikipedia/commons/thumb/5/5a/Xbox-One-Console-wController-FL.jpg/640px-Xbox-One-Console-wController-FL.jpg");
        catalogService.addConsole(console);

        console = new Console();
        console.setModel("Xbox Series X");
        console.setManufacturer("Microsoft");
        console.setPrice(499.99);
        console.setImage("https://static.digitecgalaxus.ch/productimages/9/9/1/3/8/4/3/1/8/4/6/8/1/9/7/1/5/1/b9fc3b20-7343-40dc-8805-65bff62261d0_cropped.jpg");
        catalogService.addConsole(console);

        console = new Console();
        console.setModel("Xbox Series S");
        console.setManufacturer("Microsoft");
        console.setPrice(299.99);
        console.setImage("https://assets.xboxservices.com/assets/0b/28/0b2854b9-a7e7-47dd-b4f8-a371567854b2.png?n=Xbox-Series-S_Buy-Box_0_01_829x799.png");
        catalogService.addConsole(console);

        Accessory accessory = new Accessory();
        accessory.setType("Nintendo Switch Dock");
        accessory.setManufacturer("Nintendo");
        accessory.setPrice(89.99);
        accessory.setImage("https://media.gamestop.com/i/gamestop/10147700/Nintendo-Switch-Dock-Set?$pdp$");
        catalogService.addAccessory(accessory);

        accessory = new Accessory();
        accessory.setType("DualShock Controller");
        accessory.setManufacturer("Sony");
        accessory.setPrice(59.99);
        accessory.setImage("https://m.media-amazon.com/images/I/71Liv-br3iL._AC_UF894,1000_QL80_.jpg");
        catalogService.addAccessory(accessory);

        accessory = new Accessory();
        accessory.setType("Xbox Wireless Controller");
        accessory.setManufacturer("Microsoft");
        accessory.setPrice(59.99);
        accessory.setImage("https://m.media-amazon.com/images/I/51ilQN1AEnL._AC_UF894,1000_QL80_.jpg");
        catalogService.addAccessory(accessory);

        accessory = new Accessory();
        accessory.setType("PlayStation VR Headset");
        accessory.setManufacturer("Sony");
        accessory.setPrice(199.99);
        accessory.setImage("https://m.media-amazon.com/images/I/71N0gyzmPZL._AC_UF894,1000_QL80_.jpg");
        catalogService.addAccessory(accessory);

    }
    
}
