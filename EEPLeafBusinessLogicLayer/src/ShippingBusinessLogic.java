
import java.util.Collection;
import java.util.List;


/**
 * This class provides business logics for Shipping Application
 * @author Jiawei Li
 */
public class ShippingBusinessLogic {
    private String sqlServerIp;
    

    public ShippingBusinessLogic(String sqlServerIp ) {
        this.sqlServerIp = sqlServerIp;
    }
    
    public String getPendingOrders(){
        List<ShippingOrder> orders = getShippingOrders(false);
        return buildOutputFromCollection(orders);

    }
    
    public String getShippedOrders(){
        List<ShippingOrder> orders = getShippingOrders(true);
        return buildOutputFromCollection(orders);
    }
    /**
     * Build string output for shipping application
     * @param orders
     * @return 
     */
    public String buildOutputFromCollection(Collection<ShippingOrder> orders){
        if (orders != null) {
            StringBuilder result = new StringBuilder();
            for (ShippingOrder order : orders) {
                result.append(order.toString() + "\n");
            }
            return result.toString();
        } else {
            return null;
        }
    }
    /**
     * get shipping orders filtered by shipping status
     * @param hasShipped
     * @return 
     */
    private List<ShippingOrder> getShippingOrders(boolean hasShipped){
        //StringBuilder result = new StringBuilder();
        ShippingDataAccess shippingOrder = new ShippingDataAccess(this.sqlServerIp);
        String log = null;
        List<ShippingOrder> orders = shippingOrder.selectShippingOrderByShippingStatus(hasShipped,log);
        return orders;
    }
    /**
     * Get order information filtered by order ID
     * @param orderId
     * @return 
     */
    public ShippingOrder getOrderInfoByOrderId(String orderId){
        ShippingDataAccess shippingOrder = new ShippingDataAccess(this.sqlServerIp);
        String log = null;
        ShippingOrder order = shippingOrder.selectShippingOrderByOrderId(orderId, log);
        return order;
    }
    /**
     * Get order items via providing the order table name 
     * and convert the result to preferred output string format
     * @param tableName
     * @return 
     */
    public String getOrderItemsByTableName(String tableName){
        ShippingDataAccess shippingOrder = new ShippingDataAccess(this.sqlServerIp);
        String log = null;
        List<ShippingOrderItem> items = shippingOrder.selectShippingOrderItemsByTableName(tableName, log);
        if (items != null) {
            StringBuilder result = new StringBuilder();
            for (ShippingOrderItem order : items) {
                result.append(order.toString() + "\n");
            }
            return result.toString();
        } else {
            return null;
        }
    }
    /**
     * update an order's shipping status to shipped, identified by order ID
     * @param orderId
     * @return 
     */
    public boolean updateOrderShippedByOrderId(String orderId){
        ShippingDataAccess shippingOrder = new ShippingDataAccess(this.sqlServerIp);
        String log = null;
        boolean result =  shippingOrder.updateOrderShippedByOrderId(orderId, log);
        return result;
    }
}
