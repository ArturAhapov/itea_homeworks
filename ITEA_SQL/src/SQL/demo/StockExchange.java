package SQL.demo;

import SQL.demo.repository.ShareRates;
import SQL.demo.repository.Shares;
import SQL.demo.repository.TraiderShareActions;
import SQL.demo.repository.Traiders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StockExchange {
    public static final String DB_URL = "jdbc:h2:D:\\Developing\\study\\ITEA_SQL\\db\\stockExchanger";
    public static final String DB_Driver = "org.h2.Driver";

    private Shares shares;
    private ShareRates shareRates;
    private Traiders traiders;
    private TraiderShareActions traiderShareActions;

    public StockExchange() throws ClassNotFoundException, SQLException {
        Class.forName(DB_Driver);
        this.shares = new Shares();
        this.shareRates = new ShareRates();
        this.traiders = new Traiders();
        this.traiderShareActions = new TraiderShareActions();

    }

    public static void main(String[] args) {
        try {
            StockExchange stockExchange = new StockExchange();
            stockExchange.createTables();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("JDBC драйвер для СУБД не найден");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка SQL!");
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL);
        System.out.println("Создание СУБД выполнено");
        return connection;
    }

    private void createTables() throws SQLException {
        shares.createTable();
        shareRates.createTable();
        traiders.createTable();
        traiderShareActions.createTable();

        shareRates.createForeignKeys();
        traiderShareActions.createForeignKeys();
    }

}
