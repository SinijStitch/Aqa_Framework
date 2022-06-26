package entity;

import javax.persistence.*;

@Entity
@Table(name = "price_data")
public class PriceData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String item_name;

    private String price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
