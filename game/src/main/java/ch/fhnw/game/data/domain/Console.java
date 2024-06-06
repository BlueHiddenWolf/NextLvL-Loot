package ch.fhnw.game.data.domain;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;

@Entity
@Table(name = "console")
public class Console {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Hidden
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "price")
    private Double price;
    
    @Column(name = "discountedPrice")
    private Double discountedPrice;

    @Column(name = "image")
    private String image;

    @Column(name = "is_on_special")
    private boolean isOnSpecial;

    @ManyToOne
    private Catalog catalog;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
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

