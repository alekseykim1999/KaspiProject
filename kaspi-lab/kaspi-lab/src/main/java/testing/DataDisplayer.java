package testing;

import kz.kaspi.lab.db.DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DataDisplayer {
    private List<String> information;
    private List<String> positions;
    ResultSet resultSet = null;
    DBConnector connector=DBConnector.getDBConnector();

    Connection connection= connector.getConnection();

    public List<String> getInformation() {
        return information;
    }

    public List<String> getPositions() {
        return positions;
    }


    public void setDataFromServer() throws SQLException {
        Statement statement = connection.createStatement();

        String query = "SELECT a.*, b.Name AS Position " +
                "FROM People a, Positions WHERE a.PositionId = b.Id";
        resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            information.add(resultSet.getString(1));
            positions.add(resultSet.getString(2));
        }
    }

}
