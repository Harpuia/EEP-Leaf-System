
import java.util.List;


/**
 * DTO object for retrieving shipping order
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
    
    //private List<

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
     * determine whether this order has been shipped
     * @return 
     */
    public boolean isShipped(){
        if(shippedStatus == 1){
            return true;
        }else{
            return false;
        }
    }
    public void markShipped(){
        if(shippedStatus == 0){
            shippedStatus = 1;
        }
    }
    
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
