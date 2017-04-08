
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * This class is used to access orderinfo database and get order shipping
 * information
 *
 * @author Jiawei Li
 */
public class ShippingDataAccess extends DataAccessBase {

   /** Constructor **/
    public ShippingDataAccess(String sqlServerIP) {
        super(sqlServerIP, "orderinfo");
    }

    public List<ShippingOrder> selectShippingOrder(String log) {
        log = null;
        List<ShippingOrder> result = new ArrayList<ShippingOrder>();
        ShippingOrder item;
        Connection connection = this.ConnectToDb(log);
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                ResultSet queryResult = statement.executeQuery("Select * from orders");

                //Display the data in the textarea
                while (queryResult.next()) {
                    item = new ShippingOrder(queryResult.getString(1), queryResult.getString(2), queryResult.getString(3), queryResult.getString(4),
                            queryResult.getString(5), queryResult.getString(6), queryResult.getString(7), queryResult.getString(8), queryResult.getString(9));
                    result.add(item);
                }
                return (result);
            } catch (Exception e) {
                log = "\nProblem getting order : " + e;
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * Get shipping orders, filtered by shipping status
     *
     * @param shipped
     * @param log
     * @return
     */
    public List<ShippingOrder> selectShippingOrderByShippingStatus(boolean shipped, String log) {
        log = null;
        List<ShippingOrder> result = new ArrayList<ShippingOrder>();
        ShippingOrder item;
        Connection connection = this.ConnectToDb(true, log);
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                ResultSet queryResult;
                if (shipped) {
                    queryResult = statement.executeQuery("Select * from orders where shipped = 1");
                } else {
                    queryResult = statement.executeQuery("Select * from orders where shipped != 1");
                }

                //Display the data in the textarea
                while (queryResult.next()) {
                    item = new ShippingOrder(queryResult.getString(1), queryResult.getString(2), queryResult.getString(3), queryResult.getString(4),
                            queryResult.getString(5), queryResult.getString(6), queryResult.getString(7), queryResult.getString(8), queryResult.getString(9));
                    result.add(item);
                }
                return (result);
            } catch (Exception e) {
                log = "\nProblem getting order : " + e;
                return null;
            }
        } else {
            return null;
        }
    }
    /**
     * Query a specific shipping order identified by order ID
     * @param orderId
     * @param log
     * @return 
     */
    public ShippingOrder selectShippingOrderByOrderId(String orderId, String log) {
        log = null;
        List<ShippingOrder> result = new ArrayList<ShippingOrder>();
        ShippingOrder item;
        Connection connection = this.ConnectToDb(true, log);
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                ResultSet queryResult;
                queryResult = statement.executeQuery("Select * from orders where order_id = " + Integer.parseInt(orderId));
                //Display the data in the textarea
                while (queryResult.next()) {
                    item = new ShippingOrder(queryResult.getString(1), queryResult.getString(2), queryResult.getString(3), queryResult.getString(4),
                            queryResult.getString(5), queryResult.getString(6), queryResult.getString(7), queryResult.getString(8), queryResult.getString(9));
                    result.add(item);
                }
                return result.get(0);
            } catch (Exception e) {
                log = "\nProblem getting order : " + e;
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * Get shipping order items, identified by order table item
     *
     * @param tableName
     * @param log
     * @return
     */
    public List<ShippingOrderItem> selectShippingOrderItemsByTableName(String tableName, String log) {
        log = null;
        List<ShippingOrderItem> result = new ArrayList<ShippingOrderItem>();
        ShippingOrderItem item;
        Connection connection = this.ConnectToDb(true, log);
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                ResultSet queryResult;
                queryResult = statement.executeQuery("Select * from  " + tableName);

                while (queryResult.next()) {
                    item = new ShippingOrderItem(queryResult.getString(1), queryResult.getString(2), queryResult.getString(3), queryResult.getString(4));
                    result.add(item);
                }
                return (result);
            } catch (Exception e) {
                log = "\nProblem getting order : " + e;
                return null;
            }
        } else {
            return null;
        }
    }
    /**
     * Update order status to shipped
     * @param orderId
     * @param log
     * @return 
     */
    public boolean updateOrderShippedByOrderId(String orderId, String log) {
        log = null;
        List<ShippingOrderItem> result = new ArrayList<ShippingOrderItem>();
        ShippingOrderItem item;
        Connection connection = this.ConnectToDb(true, log);
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                ResultSet queryResult;
                String SQLStatement = "UPDATE orders SET shipped=" + true + " WHERE order_id=" + orderId;
                int rows = statement.executeUpdate(SQLStatement);
                if (rows > 0) {
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e) {
                log = "\nProblem getting order : " + e;
                return false;
            }
        } else {
            return false;
        }
    }
}
