package ch.fhnw.game.data.domain;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "game")
public class Game {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Hidden // This annotation hides the id field from the swagger documentation
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "genre")
    private String genre;

    @Column(name = "developer")
    private String developer;

    @Column(name = "price")
    private Double price;

    @Column(name = "discountedPrice")
    private Double discountedPrice;

    @Column(name = "category")
    private String category;

    @Column(name = "image")
    private String image;

    @Column(name = "specialOffer")
    private Boolean specialOffer;

    @Column(name = "is_on_special")
    private boolean isOnSpecial;

    @ManyToOne
    private Catalog catalog;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getSpecialOffer() {
        return specialOffer;
    }
    
    public void setSpecialOffer(Boolean specialOffer) {
        this.specialOffer = specialOffer;
    }

    public boolean getIsOnSpecial() {
        return isOnSpecial;
    }

    public void setIsOnSpecial(boolean isOnSpecial) {
        this.isOnSpecial = isOnSpecial;
    }

    public Double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(Double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }
}