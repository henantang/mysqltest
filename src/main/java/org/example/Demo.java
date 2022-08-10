package org.example;

import java.sql.*;

public class Demo {
    public static void main(String[] args) throws SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/vueblog?useUnicode=true&useSSL=false&characterEncoding=utf8";
        String user = "root";
        String password = "root";
        Connection conn = null;
        Statement sql = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        }catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            sql = conn.createStatement();
        }catch (SQLException e){
            e.printStackTrace();
        }
        String sqll = "select * from m_user";
        try {
            ResultSet rs = sql.executeQuery(sqll);
            while(rs.next()){
                int id = rs.getInt("id");
                System.out.println(id);
            }
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        sql.close();
        conn.close();

    }
}
