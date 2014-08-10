package Com.DataServices.Party.Resources;

/**
 * Created by mark on 10/08/14.
 */

import Com.DataServices.Party.Representations.Party;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import org.skife.jdbi.v2.DBI;
import Com.DataServices.Party.dao.PartyDAO;
import java.net.URI;
import java.net.URISyntaxException;

@Path("/Party")
@Produces(MediaType.APPLICATION_JSON)
public class PartyResource
{

    private final PartyDAO partyDao;

        public PartyResource(DBI jdbi) {
            partyDao = jdbi.onDemand(PartyDAO.class);
        }

        @GET
        @Path("/{id}")
        public Response getParty(@PathParam("id") int id) {
            // retrieve information about the contact with the provided id
            Party party = partyDao.getPartyById(id);
            return Response
                    .ok(party)
                    .build();
        }

        @POST
        public Response createParty(Party party) throws URISyntaxException {
            // store the new contact
            int newPartyId = partyDao.createParty(party.getFirstName(), party.getLastName(),party.getEmail(), party.getPhone());
            return Response.created(new URI(String.valueOf(newPartyId))).build();
        }

        @DELETE
        @Path("/{id}")
        public Response deleteParty(@PathParam("id") int id) {
            // delete the contact with the provided id
            partyDao.deleteParty(id);
            return Response.noContent().build();
        }

        @PUT
        @Path("/{id}")
        public Response updateParty(@PathParam("id") int id, Party party) {
            // update the contact with the provided ID
            partyDao.updateParty(id, party.getFirstName(),
                    party.getLastName(), party.getEmail(),party.getPhone());
            return Response.ok(
                    new Party(id, party.getFirstName(), party.getLastName(), party.getEmail(),
                            party.getPhone())).build();
        }

}