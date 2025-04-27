package JDBCTutorial;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        try{
            String url = "jdbc:mysql://localhost:3306/MyWork";
            String username = "root";
            String password = "13soumyodip2002";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection(url, username, password);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
