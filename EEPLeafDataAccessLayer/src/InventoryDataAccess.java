
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Allows access to the Orders Database
 *
 * @author yazid
 */
public class InventoryDataAccess extends DataAccessBase {

    public InventoryDataAccess(String sqlServerIP) {
        super(sqlServerIP, "order");
    }

    public Collection<InventoryItem> SelectTreeInventory(String log) {
        log = null;
        Collection<InventoryItem> result = new ArrayList<InventoryItem>();
        InventoryItem item;
        Connection connection = this.ConnectToDb(log);
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                ResultSet queryResult = statement.executeQuery("Select * from trees");

                //Display the data in the textarea
                while (queryResult.next()) {
                    item = new InventoryItem(ItemType.TREES, queryResult.getString(1), queryResult.getString(2), queryResult.getString(4), queryResult.getString(3));
                    result.add(item);
                }
                return (result);
            } catch (Exception e) {
                log = "\nProblem getting tree inventory:: " + e;
                return null;
            }
        } else {
            return null;
        }
    }
}
