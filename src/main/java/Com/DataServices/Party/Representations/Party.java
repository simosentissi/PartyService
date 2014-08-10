package Com.DataServices.Party.Representations;

/**
 * Created by mark on 10/08/14.
 */
public class Party {

    private final int id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phone;

    public Party() {
        this.id = 0;
        this.firstName = null;
        this.lastName = null;
        this.email = null;
        this.phone = null;
    }

    public Party(int id, String firstName, String lastName, String email, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }
    public String getEmail () {
        return email;
    }
}