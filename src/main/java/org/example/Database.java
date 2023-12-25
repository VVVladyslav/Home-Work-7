package org.example;
import java.sql.*;

public class Database {
        public static final Database INSTANCE = new Database();
        private Connection connection;
        public Database(){
            try {
                String connectionUrl = "jdbc:h2:./test";
                connection = DriverManager.getConnection(connectionUrl);

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        public static Database getInstance(){
            return INSTANCE;
        }
        public Connection getConnection(){
            return connection;
        }
        public int executeUpdate(String sql){
           try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
               return preparedStatement.executeUpdate();
            } catch (SQLException e) {
               e.printStackTrace();
                return -1;
           }
        }
    public ResultSet executeQuery(String sql) {
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
