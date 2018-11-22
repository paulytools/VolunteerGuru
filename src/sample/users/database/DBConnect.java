package sample.users.database;

import java.sql.*;

public class DBConnect {

    public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    //relative path
    public static final String JDBC_URL = "jdbc:derby:library\\DBuser";
    Connection conn;

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
            //String type, String userName, String password,  String firstName, String lastName, String email, String city,  String tags, String gender
            conn.createStatement()
                    .execute("Create TABLE UserTable1 (type varchar(20), userName varchar(50), password varchar(50)," +
                            " firstName varchar(50),lastName varchar(50), email varchar(50), city varchar, tags varchar(150),  gender varchar(8))");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void createEventTable() {

        try {
            conn.createStatement()
                    .execute("Create TABLE EventTable1 (Name varchar(50),Age INT,gender char(1))");
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
            Statement statement = this.conn.createStatement();
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