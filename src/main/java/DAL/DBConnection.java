package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DBConnection {
    private static DBConnection instance = null;
    private Connection con = null;

    private static DBConnection getInstance(){
        if (instance == null)
            instance = new DBConnection();
        return instance;
    }

    private DBConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost/rasmus?user=root&password=password");
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public static ResultSet executeSql(String query){
        ResultSet rs = null;
        return rs;
    }

    public static Connection getConnection(){
        return getInstance().con;
    }
}
