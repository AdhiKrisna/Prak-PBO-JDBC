package connector;

import java.sql.*;

public class Connector {
    String dbUrl = "jdbc:mysql://localhost:3306/biodata_db";
    String dbUsername = "root";
    String dbPassword = "";
    String dbDriver = "com.mysql.cj.jdbc.Driver";

    Connection conn;
    // Statement statement;
    PreparedStatement preparedStatement;

    public Connector() {
        try{
            Class.forName(dbDriver);
            conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            if(conn != null){
                System.out.println("Connection to database successfully!");
            } else {
                System.out.println("Failed to connect to the database.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertData(String nama, int umur, String agama, String gender, String skills){
        try{
            String query = "INSERT INTO biodata (nama, umur, agama, gender, skills) VALUES (?, ?, ?, ?, ?)";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, nama);
            preparedStatement.setInt(2, umur);
            preparedStatement.setString(3, agama);
            preparedStatement.setString(4, gender);
            preparedStatement.setString(5, skills);

            int rowsInserted = preparedStatement.executeUpdate();
            if(rowsInserted > 0){
                System.out.println("Data inserted successfully!");
            }
            else{
                System.out.println("Failed to insert data.");
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }


}
