import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/dbproject";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "00862610shSH";
    public static void main(String[] args) {
        String n = "user2";
        Connection connection;
            try {
                Driver driver = new FabricMySQLDriver();
                DriverManager.registerDriver(driver);
                connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
                Statement statement  = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT name from user WHERE name='"+ n + "';") ;
                while (resultSet.next()){
                    System.out.println(resultSet.getString("name"));
                }
            }
            catch (SQLException e){
                e.printStackTrace();
            }

    }
}
