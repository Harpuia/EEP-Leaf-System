
import java.util.List;
/**
 * ****************************************************************************
 *
 * This class defines a DTO object for retrieving shipping order.
 *
 *****************************************************************************
 */

/**
 * @author Jiawei Li
 */
public class ShippingOrder {
    /** OrderInfo **/
    public int orderId;
    public String orderDate;
    // customer info
    public String firstName;
    public String lastName;
    public String address;
    public String phoneNum;
    public double totalCost;
    // order status
    private int shippedStatus;
    // the name of database table that stores order detail
    private String orderTable;
    
    
    /**
     * This constructor initiates the properties of a specific order.
     */
    public ShippingOrder(int orderId, String orderDate, String firstName, String lastName, String address, String phoneNum, double totalCost, int shippedStatus, String orderTable) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNum = phoneNum;
        this.totalCost = totalCost;
        this.shippedStatus = shippedStatus;
        this.orderTable = orderTable;
    }
    /**
     * This constructor initiates the properties of a specific order with different variable types.
     */
    public ShippingOrder(String orderId, String orderDate, String firstName, String lastName, String address, String phoneNum, String totalCost, String shippedStatus, String orderTable) {
        this.orderId = Integer.valueOf(orderId);
        this.orderDate = orderDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNum = phoneNum;
        this.totalCost = Double.valueOf(totalCost);
        this.shippedStatus = Integer.valueOf(shippedStatus);
        this.orderTable = orderTable;
    }
    /**
     * Determine whether this order has been shipped
     * @return boolean value to see if this order is shipped or not.
     */
    public boolean isShipped(){
        if(shippedStatus == 1){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Mark the order as shipped.
     */
    public void markShipped(){
        if(shippedStatus == 0){
            shippedStatus = 1;
        }
    }
    
    /**
     * Get the order table name.
     * @return the order table name.
     */
    public String getOrderTableName() {
        return orderTable;
    }

    @Override
    public String toString() {
        if(isShipped()){
            return "SHIPPED ORDER # " + orderId + " : " + orderDate + " : " + firstName + " : " + lastName;
        }else{
            return "ORDER # " + orderId + " : " + orderDate + " : " + firstName + " : " + lastName;
        }
        
    }
    
    
}
