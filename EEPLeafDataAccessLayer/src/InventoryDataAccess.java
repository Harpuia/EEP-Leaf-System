
import java.sql.Connection;
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
        super(sqlServerIP, "inventory");
    }

    public InventoryDataAccess(String sqlServerIP, ItemType itemType) {
        super(sqlServerIP, DataUtilities.GetDatabaseName(itemType));
    }

    public String insertInventoryItem(InventoryItem item) {
        StringBuilder log = new StringBuilder();
        int executeUpdateVal;
        String logLine = null, sqlStatement = null, tableSelected = null;
        Connection connection = this.ConnectToDb(logLine);
        if (connection != null) {
            Statement statement;
            try {
                statement = connection.createStatement();
                if (item.type.equals(ItemType.CULTUREBOXES)
                        || item.type.equals(ItemType.GENOMICS)
                        || item.type.equals(ItemType.PROCESSING)
                        || item.type.equals(ItemType.REFERENCE_MATERIALS)) {
                    sqlStatement = ("INSERT INTO " + DataUtilities.GetTableName(item.type) + " (productid, "
                            + "productdescription, productquantity, productprice) VALUES ( '"
                            + item.productCode + "', " + "'" + item.description + "', "
                            + item.quantity + ", " + item.price + ");");
                } else {
                    sqlStatement = ("INSERT INTO " + DataUtilities.GetTableName(item.type) + " (product_code, "
                            + "description, quantity, price) VALUES ( '"
                            + item.productCode + "', " + "'" + item.description + "', "
                            + item.quantity + ", " + item.price + ");");
                }
                tableSelected = DataUtilities.GetTableDisplayName(item.type);

                // execute the update
                executeUpdateVal = statement.executeUpdate(sqlStatement);

                // let the user know all went well
                log.append("\nINVENTORY UPDATED... The following was added to the " + tableSelected + " inventory...\n");
                log.append("\nProduct Code:: " + item.productCode);
                log.append("\nDescription::  " + item.description);
                log.append("\nQuantity::     " + item.quantity);
                log.append("\nUnit Cost::    " + item.price);

            } catch (Exception e) {
                logLine = "\nProblem adding inventory:: " + e;
                log.append(logLine);
                return log.toString();
            }
        } else {
            log.append(logLine);
        }
        return log.toString();
    }

    public Collection<InventoryItem> selectInventoryItems(ItemType itemType, String log) {
        //Initializing variables
        String tableSelected = null;
        String tableName = null;
        InventoryItem item;
        Collection<InventoryItem> result = new ArrayList<InventoryItem>();
        Connection connection = this.ConnectToDb(log);
        ResultSet results;

        if (connection != null) {
            try {
                //Getting parameters
                tableName = DataUtilities.GetTableName(itemType);
                tableSelected = DataUtilities.GetTableDisplayName(itemType);

                //Executing query
                Statement statement = connection.createStatement();
                results = statement.executeQuery("Select * from " + tableName);

                //Parsing results
                while (results.next()) {
                    item = new InventoryItem(itemType, results.getString(1), results.getString(2), results.getString(3), results.getString(4));
                    result.add(item);
                }
            } catch (Exception e) {
                log = "\nProblem with " + tableSelected + " query:: " + e;
                result = null;
            }
        }
        return result;
    }

    public int deleteInventoryItem(String id, ItemType itemType, String log) {
        StringBuilder output = new StringBuilder();
        String logLine = null, sqlStatement = null;
        Connection connection = this.ConnectToDb(logLine);
        int executeUpdateVal;
        
        if (connection != null) {
            Statement statement;
            try {
                statement = connection.createStatement();
                sqlStatement = ("DELETE FROM " + DataUtilities.GetTableName(itemType) + " WHERE " + DataUtilities.GetIdColumnName(itemType) + " = '" + id + "';");
                // execute the update
                executeUpdateVal = statement.executeUpdate(sqlStatement);

                // let the user know all went well
                output.append("\n\n" + id + " deleted...");
                output.append("\n Number of items deleted: " + executeUpdateVal);

            } catch (Exception e) {
                executeUpdateVal = -1;
                logLine = "\nProblem adding inventory:: " + e;
                output.append(logLine);
            }
        } else {
            executeUpdateVal = -1;
            output.append(logLine);
        }
        log= output.toString();
        return executeUpdateVal;
    }
}
