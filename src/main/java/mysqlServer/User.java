package mysqlServer;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class User {
    private int id;
    private String name;
    private String password;
    private String dialog = null;
    private String error;
    private MysqlServer mysqlServer;
    private ResultSet resultSet = null;

    public String getDialog() {
        return dialog;
    }

    public void setDialog(String dialog) {
        this.dialog = dialog;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }


    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.mysqlServer = new MysqlServer();
    }

    public void login() {
        if (checkUserName()) {
            String query = "SELECT * FROM user WHERE name='" + this.name + "' AND password='" + this.password + "';";
            try {
                this.resultSet = mysqlServer.getStatement().executeQuery(query);
                resultSet.next();
                setId(Integer.parseInt(resultSet.getString("id")));
                setDialog(resultSet.getString("dialog"));

            } catch (SQLException e) {
                setError("Не верный пароль!");
                //e.printStackTrace();
            }
        } else {
            setError("Не верное мимя пользователя");
        }
    }

    public void register() {
        if (!checkUserName()) {
            String query = "INSERT INTO user (id,name,password) VALUES (NULL ,'" + name + "','" + password + "')";
            try {
                mysqlServer.getStatement().executeUpdate(query);
            } catch (SQLException e) {
                //e.printStackTrace();
                setError("Произошла неведомая хуйня");
            }
        }
    }

    public boolean checkUserName() {
        String query = "SELECT * FROM user WHERE name='" + this.name + "';";
        try {
            resultSet = mysqlServer.getStatement().executeQuery(query);
            if (resultSet.next()) {
                return true;
            }

        } catch (SQLException e) {
            setError("Ошибка в checkUser");
            e.printStackTrace();
        }
        return false;
    }

    public void newDialog() {

    }


}
