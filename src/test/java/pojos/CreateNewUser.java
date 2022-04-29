package pojos;

public class CreateNewUser {

/*
    {
            "login": "hakankemal",
            "firstName": "Hakan",
            "lastName": "Can",
            "ssn": "782-81-8844",
            "email": "hakankemal@gmail.com",

    }

 */

//  1- variable ları private tanımlıyoruz

    private String login;
    private String firstName;
    private String lastName;
    private String ssn;
    private String email;

    // 2- parametreli ve parametresiz constructor tanımlıyoruz

    public CreateNewUser() {
    }

    public CreateNewUser(String login, String firstName, String lastName, String ssn, String email) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.email = email;

    }

    // 3- gettter-setter yapıyoruz

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // 4- toString() yapıyoruz

    @Override
    public String toString() {
        return "CreateNewUser{" +
                "login='" + login + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ssn='" + ssn + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
