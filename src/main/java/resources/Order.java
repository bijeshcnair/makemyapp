package resources;

import org.mongojack.ObjectId;
import org.mongojack.Id;
import javax.persistence.IdClass;

/**
 * Created by biju on 7/31/2015.
 */

/**
 * {
 "type": {
 "name": "Americano",
 "family": "coffee"
 },
 "size": "Medium",
 "drinker": "Biju"
 }
 */
public class Order {


    @ObjectId
    @Id
    private String id;
    private long coffeeShopId;
    private String size;
    private String drinker;
    private DrinkType type;
    private String selectedOptions[];
    public String getOrderId() {
        return id;
    }

    public void setCoffeeShopId(long coffeeShopId) {
        this.coffeeShopId = coffeeShopId;
    }

    public long getCoffeeShopId() {
        return coffeeShopId;
    }

    public String getId() {
        return id;
    }

    public String getSize() {
        return size;
    }

    public String getDrinker() {
        return drinker;
    }

    public DrinkType getType() {
        return type;
    }

    public String[] getSelectedOptions() {
        return selectedOptions;
    }

    public void setId(String id) {
        this.id = id;
    }
}
