package ch.fhnw.game.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.fhnw.game.data.domain.Console;
import ch.fhnw.game.data.domain.Game;
import ch.fhnw.game.data.repository.GameRepository;
import ch.fhnw.game.data.repository.ConsoleRepository;


@Service
public class SpecialOfferService {

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private ConsoleRepository consoleRepository;

    private static final Logger logger = LoggerFactory.getLogger(SpecialOfferService.class);

    @Scheduled(cron = "0 0 0 * * MON") // Runs every Monday at midnight
    public void generateWeeklySpecialOffer() {
        logger.info("Automatically running special offers update task.");
        clearPreviousOffers();
        generateSpecialOffer();
    }

    public void createSpecialOfferNow() {
        logger.info("Manually triggering special offer creation.");
        clearPreviousOffers();
        generateSpecialOffer();
    }

    private double lastTotalDiscountedPrice = 0.0;

    // Centralized method to generate special offers
    private void generateSpecialOffer() {
        Random random = new Random();
        List<Console> consoles = consoleRepository.findAll();
        List<Game> games = gameRepository.findAll();

        if (!consoles.isEmpty() && !games.isEmpty()) {
            Console console = consoles.get(random.nextInt(consoles.size()));
            Game game = games.get(random.nextInt(games.size()));

            // Mark both as on special and calculate discounted prices
            game.setIsOnSpecial(true);
            gameRepository.save(game);

            console.setIsOnSpecial(true);
            double totalOriginalPrice = console.getPrice() + game.getPrice();
            lastTotalDiscountedPrice = totalOriginalPrice * 0.9; // Apply 10% discount

            console.setDiscountedPrice(lastTotalDiscountedPrice); // Assuming Console has a setDiscountedPrice method
            consoleRepository.save(console);

            logger.info("Special Offer Generated: Console '{}' and Game '{}' with total discounted price ${}", 
                        console.getModel(), game.getTitle(), String.format("%.2f", lastTotalDiscountedPrice));
        }
    }

    public double getLastTotalDiscountedPrice() {
        return lastTotalDiscountedPrice;  // Method to retrieve the last calculated discounted price
    }

    private void clearPreviousOffers() {
        gameRepository.findAll().forEach(game -> {
            game.setIsOnSpecial(false);
            gameRepository.save(game);
        });
        consoleRepository.findAll().forEach(console -> {
            console.setIsOnSpecial(false);
            consoleRepository.save(console);
        });
    }
}
