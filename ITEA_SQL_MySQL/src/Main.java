import com.mysql.cj.jdbc.ConnectionImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";//D:\Developing\study\ITEA_SQL_MySQL\.idea\lib\mysql-connector-java-8.0.27.jar!\
    public static final String DB_URL = "jdbc:mysql://localhost:3306/university";

    public static void main(String[] args) {

        try{
            Main main = new Main();
            Class.forName(DB_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL, "root", User.password);
            System.out.println("Соединение с БД выполнено");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("ClassNotFoundException DB_DRIVER не найден");
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("SQLException");
        }
    }
}
