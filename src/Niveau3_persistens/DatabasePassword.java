package Niveau3_persistens;

public class DatabasePassword {

    // STRINGS
    private final String JdbcUrl;
    private final String username;
    private final String password;

    // CONSTRUCTOR
    protected DatabasePassword() {
        this.JdbcUrl = "jdbc:mysql://localhost:3306/biblo?serverTimezone=CET&useSSL=false";
        this.username = "root";

        // passwords to be used on local computers
        this.password = "lortekode";
        //this.password = "Lampen04aug";
        //this.password = "Mysql1238Code18";
        //this.password = "Solskin#12";
    }

    // Method to return the sql url connection
    public String getJdbcUrl() {
        return this.JdbcUrl;
    }

    // Getter to get the username
    public String getUsername() {
        return this.username;
    }

    // Getter to get the password
    public String getPassword() {
        return this.password;
    }
}
