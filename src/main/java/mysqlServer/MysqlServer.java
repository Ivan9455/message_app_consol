package mysqlServer;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class MysqlServer {


    private final String URL = "jdbc:mysql://localhost:3306/dbproject";
    private final String USERNAME = "root";
    private final String PASSWORD = "00862610shSH";
    private Connection connection;
    private Statement statement;

//    public Connection getConnection() {
//        return connection;
//    }
//
//    public void setConnection(Connection connection) {
//        this.connection = connection;
//    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    private void conectDB(){
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            this.statement = connection.createStatement();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public MysqlServer() {
        conectDB();
    }
}