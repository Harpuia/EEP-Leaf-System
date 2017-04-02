
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
    
    private List<ShippingOrder> getShippingOrders(boolean hasShipped){
        //StringBuilder result = new StringBuilder();
        ShippingDataAccess shippingOrder = new ShippingDataAccess(this.sqlServerIp);
        String log = null;
        List<ShippingOrder> orders = shippingOrder.selectShippingOrderByShippingStatus(hasShipped,log);
        return orders;
    }
    
    public ShippingOrder getOrderInfoByOrderId(String orderId){
        ShippingDataAccess shippingOrder = new ShippingDataAccess(this.sqlServerIp);
        String log = null;
        ShippingOrder order = shippingOrder.selectShippingOrderByOrderId(orderId, log);
        return order;
    }
    
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
    
    public boolean updateOrderShippedByOrderId(String orderId){
        ShippingDataAccess shippingOrder = new ShippingDataAccess(this.sqlServerIp);
        String log = null;
        boolean result =  shippingOrder.updateOrderShippedByOrderId(orderId, log);
        return result;
    }
}
