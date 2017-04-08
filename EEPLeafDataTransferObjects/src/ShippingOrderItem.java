/**
 * ****************************************************************************
 *
 * This class defines a DTO for conveying information of items in an order.
 *
 *****************************************************************************
 */

/**
 * @author Jiawei Li
 */
public class ShippingOrderItem {
    public int itemId;
    public String productId;
    public String description;
    public double itemPrice;

    /**
     * This constructor initiates the properties of a specific order.
     */
    public ShippingOrderItem(int itemId, String productId, String description, double itemPrice) {
        this.itemId = itemId;
        this.productId = productId;
        this.description = description;
        this.itemPrice = itemPrice;
    }
    
    /**
     * This constructor initiates the properties of a specific order with different varia types.
     */
    public ShippingOrderItem(String itemId, String productId, String description, String itemPrice) {
        this.itemId = Integer.valueOf(itemId);
        this.productId = productId;
        this.description = description;
        this.itemPrice = Double.valueOf(itemPrice);
    }

    @Override
    public String toString() {
        return itemId + ": PRODUCT ID: " + productId + "  DESCRIPTION: " + description + "  PRICE $" + itemPrice;
    }
    
    
}
