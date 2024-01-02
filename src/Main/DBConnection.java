package Main;

import java.sql.*;

public class DBConnection {
    
    //static final String DB_URL="jdbc:mysql://localhost:3306";
    static final String DB_URL = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL";
    static final String USER = "root";
    static final String PASS = "12345678";


    public  static Connection connectDB() {
        Connection conn= null;
       // jdbc:mysql://localhost:3306/?useSSL=false&allowPublicKeyRetrieval=true


       //try {
          //  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/?useSSL=false&serverTimezone=Asia/Dhaka", "root", "12345678");
            // Your database operations here
       //} catch (SQLException e) {
          //  e.printStackTrace();

            // Handle the exception here, e.g., show an error message to the user
       // }

          try{
        //Class.forName("com.mysql.cj.jdbc.Driver");
         conn = DriverManager.getConnection(DB_URL,USER, PASS);
       return conn;
          }catch(Exception ex){
         System.out.println("There were errors while connectiong to db");
        return null;
        }


       // return null;
    }
}