package sample.users.database;

import java.sql.*;

public class DBConnect {

  /*
  * TO DO:
  * Load the organization table into the gui table. When the organization
  * is populated, and you click on one of the fields,
  * the fields in the profile window needs to be populated with information from the database.
  *
  * Optional:
  * Display profile picture for that organization in the window.
  *
  * 1. Ensure basic database functions are working.
  * (a.) Create table? []
  * (b.) Modify existing records? []
  * (c.) I/O records and specific fields? []
  * (d.) Load database when program is running? []
  * 2. Map each existing method created in class DBConnect
  * to an appropriate button when clicked in the program.
  * (a.) Set all buttons to appropriate actions? []
  * (b.) Custom actions (make methods for these)? []
  *
  *
  *
  * */

    public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    // relative path
    public static final String JDBC_URL = "jdbc:derby:library\\DBuser";
    Connection conn;


    // constructor which checks to see if a connection was made to the
    // database.
    public DBConnect() {
        try {
            Connection conn = DriverManager.getConnection(JDBC_URL);
            if (this.conn != null) {
                System.out.println("Connected!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createUserTable() {

        try {
            //String type, String userName, String password,  String firstName,
            // String lastName, String email, String city,  String tags, String gender
            conn.createStatement()
                    .execute("Create TABLE UserTable1 (type varchar(20), "
                        + "userName varchar(50), password varchar(50)," +
                            " firstName varchar(50),lastName varchar(50), "
                        + "email varchar(50), city varchar, tags varchar(150),  "
                        + "gender varchar(8))");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void createOrganizationTable() {

        try {
            conn.createStatement()
                    .execute("Create TABLE EventTable1 (Name varchar(50),Age INT,gender char(1)), "
                        + "tags varchar(150)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertIntoUserTable(String type, String userName, String password,  String firstName,
                                    String lastName, String email, String city, String gender) {
        try {
            conn.createStatement()
                    //String type, String userName, String password,  String firstName, String lastName, String email, String city, String gender
                    .execute("INSERT INTO UserTable1 VALUES ('" + type + "'," + userName + ",'" + password + "'" +
                            ",'" + firstName + "','" + lastName + "','" + email + "','" + city + "','" + gender + "')");
            //INSERT INTO UserTable1 VALUES ('type', 'userName');
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertIntoEventTable(String name, int age, char gender) {
        try {
            conn.createStatement()
                    .execute("INSERT INTO EventTable1 VALUES ('" + name + "'," + age + ",'" + gender + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printAllUser() {

        try {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM UserTable1");
            while (res.next()) {
                System.out.println(res.getString("Name") + " " + res.getString("Age") + " " + res.getString("Gender"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void printAllEvent() {

        try {
            Statement statement = this.conn.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM EventTable1");
            while (res.next()) {
                System.out.println(res.getString("Name") + " " + res.getString("Age") + " " + res.getString("Gender"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Trying to Verify name hasn't been used in the Table
    public boolean verifyExist(String userName, String password){
        try {
            Statement statement = this.conn.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM UserTable1");
            while (res.next()) {
                if (userName.equals(res.getString("userName")) && password.equals(res.getString("password")) ){
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}