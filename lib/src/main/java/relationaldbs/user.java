package relationaldbs;

public class user {

    // Fields
    private String name;
    private String password;
    private int age;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String country;
    private double balance;

    // CONSTRUCTOR
    public user(String name, String password, String string, String email,
                String phone, String address, String city, String country, double balance) {

        this.name = name;
        this.password = password;
        this.age = string;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.country = country;
        this.balance = balance;
    }

    // GETTERS

    public String getName() { return name; }
    public String getPassword() { return password; }
    public int getAge() { return age; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }
    public String getCity() { return city; }
    public String getCountry() { return country; }
    public double getBalance() { return balance; }

    // SETTERS

    public void setName(String name) { this.name = name; }
    public void setPassword(String password) { this.password = password; }
    public void setAge(int age) { this.age = age; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setAddress(String address) { this.address = address; }
    public void setCity(String city) { this.city = city; }
    public void setCountry(String country) { this.country = country; }
    public void setBalance(double balance) { this.balance = balance; }
}