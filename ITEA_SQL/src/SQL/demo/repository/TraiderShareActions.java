package SQL.demo.repository;

import java.sql.SQLException;

public class TraiderShareActions extends BaseTable implements TableOperations{
    public TraiderShareActions() throws SQLException {
        super("traider_share_actions");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS traider_share_actions(" +
                "id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                "operation INTEGER NOT NULL," +
                "traider_id BIGINT NOT NULL," +
                "share_rate_id BIGINT NOT NULL," +
                "amount BIGINT NOT NULL);", "Созданная таблица " + getTableName());
    }

    @Override
    public void createForeignKeys() throws SQLException {
        super.executeSqlStatement("ALTER TABLE traider_share_actions ADD FOREIGN KEY(traider_id) REFERENCES traiders(id);"+
                "ALTER TABLE traider_share_actions ADD FOREIGN KEY(share_rate_id) REFERENCES shares(id);",
                "Создана ссылка на акцию traider_share_actions.share_rate_id > shares.id.");
    }
}
