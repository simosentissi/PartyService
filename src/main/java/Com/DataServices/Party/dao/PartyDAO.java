package Com.DataServices.Party.dao;

/**
 * Created by mark on 10/08/14.
 */
import Com.DataServices.Party.dao.mappers.PartyMapper;
import Com.DataServices.Party.Representations.Party;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

public interface PartyDAO {

    @Mapper(PartyMapper.class)
    @SqlQuery("select * from party where id = :id")
    Party getPartyById(@Bind("id") int id);

    @GetGeneratedKeys
    @SqlUpdate("insert into party (firstName, lastName, email, phone) values (:firstName, :lastName, :email, :phone)")
    int createParty(@Bind("firstName") String firstName, @Bind("lastName") String lastName, @Bind("email") String email, @Bind("phone") String phone);

    @SqlUpdate("update party set firstName = :firstName, lastName = :lastName, phone = :phone where id = :id")
    void updateParty(@Bind("id") int id, @Bind("firstName") String firstName, @Bind("lastName") String lastName,@Bind("email") String email, @Bind("phone") String phone);

    @SqlUpdate("delete from party where id = :id")
    void deleteParty(@Bind("id") int id);


}
