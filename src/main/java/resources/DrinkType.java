package resources;

/**
 * Created by biju on 8/3/2015.
 */

/**
 * "type": {
 "name": "Americano",
 "family": "coffee"
 }
 */
public class DrinkType {
    private String name;
    private String family;


    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "DrinkType{name='"+name+"'}";
    }
}
