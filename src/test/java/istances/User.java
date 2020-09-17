package istances;

public class User {

    private String fullName;
    private String email;
    private String address;
    private String city;
    private String state;
    private int zip;
    private String nameOnCard;
    private String creditCardNumber;
    private String expMonth;
    private int expYear;
    private int CVV;

    public User() {
        setFullName("Turchenka Dzmitry");
        setEmail("dzmitry_turchenka@epam.com");
        setAddress("Dzerzhinskogo 91, Minsk");
        setCity("Minsk");
        setState("MSQ");
        setZip(210260);
        setNameOnCard("Dzmitry Turchenka");
        setCreditCardNumber("1111222233334444");
        setExpMonth("September");
        setExpYear(2020);
        setCVV(456);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getExpMonth() {
        return expMonth;
    }

    public void setExpMonth(String expMonth) {
        this.expMonth = expMonth;
    }

    public int getExpYear() {
        return expYear;
    }

    public void setExpYear(int expYear) {
        this.expYear = expYear;
    }

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }
}
