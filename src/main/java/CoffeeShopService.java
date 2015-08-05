import com.mongodb.DB;
import com.mongodb.LazyDBList;
import com.mongodb.MongoClient;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.assets.AssetsBundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import resources.CoffeeShopResource;

/**
 * Created by biju on 7/14/2015.
 */

public class CoffeeShopService extends Service<SampleConfiguration> {

    public static void main(String[] args) throws Exception {
        new CoffeeShopService().run(args);
    }
    @Override
    public void initialize(Bootstrap<SampleConfiguration> bootstrap) {
        bootstrap.setName("coffeeApp");
        AssetsBundle bundle = new AssetsBundle("/html","/");
        bootstrap.addBundle(bundle);
    }

    @Override
    public void run(SampleConfiguration sampleConfiguration, Environment environment) throws Exception {
        MongoClient mongoClient = new MongoClient();
        DB database = mongoClient.getDB("coffeeShop");
        environment.addResource(new CoffeeShopResource(database));
    }
}
