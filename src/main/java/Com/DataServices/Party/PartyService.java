package Com.DataServices.Party;

import Com.DataServices.Party.Resources.PartyResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;
import io.dropwizard.jdbi.DBIFactory;

/**
 * Created by mark on 10/08/14.
 */
public class PartyService extends Application<PartyServiceConfiguration> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PartyService.class);

    public static void main(String[] args) throws Exception {
        new PartyService().run(args);
    }

    @Override
    public void initialize(Bootstrap<PartyServiceConfiguration> b) {
    }

    @Override
    public void run(PartyServiceConfiguration c, Environment e) throws Exception {
        LOGGER.info("Method App#run() called");

        System.out.println(c.getAdditionalMessage());

        // Create a DBI factory and build a JDBI instance
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory
                .build(e, c.getDataSourceFactory(), "mysql");
        // Add the resource to the environment
        e.jersey().register(new PartyResource(jdbi));
    }
}
