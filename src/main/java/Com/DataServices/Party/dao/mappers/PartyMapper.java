package Com.DataServices.Party.dao.mappers;

/**
 * Created by mark on 10/08/14.
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import Com.DataServices.Party.Representations.Party;

public class PartyMapper implements ResultSetMapper<Party> {
    public Party map(int index, ResultSet r, StatementContext ctx)
            throws SQLException {
        return new Party(
                r.getInt("id"), r.getString("firstName"),
                r.getString("lastName"),r.getString("email"),r.getString("phone"));
    }
}