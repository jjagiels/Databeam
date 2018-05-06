package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDatabase {
    //private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    //private static final String DB_URL = "jdbc:mysql://108.52.101.66:3306/databeam";

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://108.52.101.66:3306/databeam"; //Check for IP changes in Database
    //private static final String DB_URL = "jdbc:mysql://localhost/databeam";

    //Database Credentials
    private static final String USER = "sDesign2017";
    private static final String PASS = "DatabeamDatabase2017";

    static Connection conn = null;
    Statement stmt = null;

    public static void connectDatabase() {
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        } catch(SQLException se){
            //Handle JDBC Errors
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }
}
