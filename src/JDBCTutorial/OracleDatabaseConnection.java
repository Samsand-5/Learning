package JDBCTutorial;

import java.sql.*;
import java.util.*;

public class OracleDatabaseConnection {

    String url = "jdbc:oracle:thin:@localhost:1521:xe"; // Database details

    // Username and password to access DB
    String user = "system";
    String pass = "12345";

    // Entering the data
    Scanner k = new Scanner(System.in);
    String name = k.next();
    int roll = k.nextInt();
    String cls = k.next();

    // Inserting data using SQL query
    String sql = "insert into student1 values('" + name + "'," + roll + ",'" + cls + "')";

    // Connection class object
    Connection con = null;

        try {
        // Registering drivers
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());

        // Establish connection
        con = DriverManager.getConnection(url, user, pass);

        // Create a statement
        Statement st = con.createStatement();

        // Execute the query
        int m = st.executeUpdate(sql);
        if (m == 1)
            System.out.println("Inserted successfully: " + sql);
        else
            System.out.println("Insertion failed");
        con.close();
    } catch (Exception ex) {
        System.err.println(ex);
    }
}


