import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import resources.HelloResource;

/**
 * Created by biju on 7/14/2015.
 */

public class sampleService extends Service<SampleConfiguration> {

    public static void main(String[] args) throws Exception {
        new sampleService().run(args);
    }
    @Override
    public void initialize(Bootstrap<SampleConfiguration> bootstrap) {

    }

    @Override
    public void run(SampleConfiguration sampleConfiguration, Environment environment) throws Exception {
        environment.addResource(HelloResource.class);
    }
}
