package sample.users.sql_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;

/**
 * @author Paul Nicowski
 *
 * Source: https://youtu.be/YqTe8Eks_qk
 *
 * */

@SuppressWarnings("Duplicates")
public class JdbcIntegration {

  public void derbyJdbc () {

    /*
     * TO DO:
     *
     * Paul:
     * Load the organization table into the gui table. When the organization
     * is populated, and you click on one of the fields,
     * the fields in the profile window needs to be populated with information from the database.
     *
     * Optional:
     * Display profile picture for that organization in the window.
     *
     * Carlos & Charly:
     * Make the search function.
     *
     * 1. Ensure basic database functions are working.
     * (a.) Create table? [y]
     * (b.) Modify/search existing records? []
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

    /*jdbc:derby:your/path/folder/database;create=true
    *
    * jdbc:derby:library/jdbc_db;create=true
    *
    * connect to a database in the classpath:
    * jdbc:derby:classpath:jdbc_db
    *
    * connect to jdbc_db database inside a jar(inside classpath)
    * jdbc:derby:jar:webdb
    *
    * ...(not in the classpath)
    * jdbc:derby:jar:(C:/path/to/my.jar)webdb
    *
    * Shutdown current database:
    * jdbc:derby:;shutdown=true
    *
    *
    *
    *
    *
    * */


    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    try {
      try {
        // initiate new instance of embedded driver
        DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
      } catch (SQLException e) {
        e.printStackTrace();
      }
      try {
        // establish connection
            // establish location of the db
        conn = DriverManager.getConnection("jdbc:derby:sql_database/test;create=true");
        stmt = conn.createStatement();
      } catch (SQLException e) {
        e.printStackTrace();
      }


      // remove table "test"
      String sql = "DROP TABLE test";
      try {
        stmt.executeUpdate(sql);
      } catch (SQLException e) {      // throws an exception if a table does not exist
        if (((SQLSyntaxErrorException) e).getSQLState().equals("42Y55"))    // sql derby error code 42Y55
          System.out.println("Database doesn't exist");
        }
        // create a new table
        try {
          stmt.execute("CREATE TABLE test(id INT PRIMARY KEY ,"
              + "first_name VARCHAR(100) NOT NULL ,last_name VARCHAR(100) NOT NULL ,"
              + "age INT NOT NULL)");
        } catch (SQLException e) {
          e.printStackTrace();
        }

        System.out.println("Table created");
        sql = "INSERT INTO test(id, first_name, last_name, age) VALUES(1, 'Jan', 'Dallas', 21),"
            + "(3, 'Tammy', 'Phelps', 32), (4, 'Hannah', 'Cole', 28), (5, 'Phillip', 'Jensen', 26)";


        int insertedRows = 0;
        try {
          insertedRows = stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);      // not working?
        } catch (SQLException e) {
          e.printStackTrace();
        }
        System.out.println("Rows inserted: " + insertedRows);

        try {
          rs = stmt.getGeneratedKeys();
        } catch (SQLException e) {
          e.printStackTrace();
        }
        try {
          if (rs != null) {
            while (rs.next())
              System.out.println("Inserted row with ID: " + rs.getInt(1));
          }
          sql = "UPDATE test SET first_name='John' WHERE id=1";
          stmt.executeUpdate(sql);

          sql = "SELECT * FROM test";
          rs = stmt.executeQuery(sql);
          while (rs.next()) {

            int id = rs.getInt(rs.findColumn("id"));
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            int age = rs.getInt("age");
            System.out.printf("%d: %s %s, %d years old\n", id, firstName, lastName, age);

          }
        } catch (Exception e) {
          e.printStackTrace();
        }
    } finally {
        try {
          if (stmt != null)
            stmt.close();
          if (rs != null)
            stmt.close();
          if (conn != null)
            conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }

  }

}
