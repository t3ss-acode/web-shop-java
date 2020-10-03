package DAL;

import java.sql.*;
import java.util.ArrayList;

public class DBConnection {
    private static DBConnection instance = null;
    private static Connection con = null;
    private static String url;
    private static String user;
    private static  String password;

    private static DBConnection getInstance(){
        if (instance == null)
            instance = new DBConnection();
        return instance;
    }

    private DBConnection(){
        url = "jdbc:mysql://213.21.125.156:3306/webshopDB?useLegacyDatetimeCode=false&serverTimezone=Europe/Stockholm";
        //url = "jdbc:mysql://192.168.1.245:3306/webshopDB?useLegacyDatetimeCode=false&serverTimezone=Europe/Stockholm";
        user = "admin";
        password = "password123";

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url,user,password);
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public static ResultSet executeSql(String query, ArrayList<Object> pp){
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        Connection con = getConnection();

        try {
            pstmt = con.prepareStatement(query);
            if (pp != null) {
                for (int i = 1;i<=pp.size();i++)
                    pstmt.setObject(i,pp.get(i-1));
            }
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static void executeUpdateSql(String query, ArrayList<Object> pp) throws SQLException {
        PreparedStatement pstmt = null;
        Connection con = getConnection();

        try {
            pstmt = con.prepareStatement(query);
            if (pp != null) {
                for (int i = 1;i<=pp.size();i++)
                    pstmt.setObject(i,pp.get(i-1));
            }
            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return getInstance().con;
    }
}
