package lv.javaguru.java3.core.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseCleaner {

    private List<String> getTableNames() {
        List<String> tableNames = new ArrayList<String>();
        tableNames.add("groups");
        tableNames.add("users");
        tableNames.add("users_groups");
        tableNames.add("user_log");
        return tableNames;
    }

    public void cleanDatabase() throws Exception {
        for (String tableName : getTableNames()) {
            Connection connection = getConnection();
            try {
                connection = getConnection();
                PreparedStatement preparedStatement = connection
                        .prepareStatement("delete from " + tableName);
                preparedStatement.executeUpdate();
            } catch (Throwable e) {
                System.out.println("Exception while execute cleanDatabase() for table " + tableName);
                e.printStackTrace();
                throw new Exception(e);
            } finally {
                closeConnection(connection);
            }
        }
    }

    protected Connection getConnection() throws Exception {
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/corpdeskdb", "root", "root");
        } catch (SQLException e) {
            System.out.println("Exciption while getting connection to database");
            e.printStackTrace();
            throw new Exception(e);
        }
    }

    protected void closeConnection(Connection connection) throws Exception {
        try {
            if(connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Exciption while closing connection to database");
            e.printStackTrace();
            throw new Exception(e);
        }
    }

}