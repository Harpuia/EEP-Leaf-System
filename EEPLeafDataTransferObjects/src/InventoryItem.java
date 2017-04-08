
/**
 * ****************************************************************************
 *
 * This class defines the information for an inventory item.
 *
 *****************************************************************************
 */
/**
 *
 * /**
 *
 * @author yazid
 */
public class InventoryItem {

    public ItemType type;
    public String productCode;
    public String description;
    public float quantity;
    public float price;

    /**
     * This constructor initiates the properties of a specific item type.
     *
     * @param type
     * @param productCode
     * @param description
     * @param quantity
     * @param price
     */
    public InventoryItem(ItemType type, String productCode, String description, float quantity, float price) {
        this.type = type;
        this.productCode = productCode;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * This constructor initiates the properties of a specific item type with
     * different variable type.
     *
     * @param type
     * @param productCode
     * @param description
     * @param quantity
     * @param price
     */
    public InventoryItem(ItemType type, String productCode, String description, String quantity, String price) {
        this.type = type;
        this.productCode = productCode;
        this.description = description;
        this.quantity = quantity == null ? null : Float.parseFloat(quantity);
        this.price = price == null ? null : Float.parseFloat(price);
    }

    /**
     * Format the output.
     *
     * @return
     */
    @Override
    public String toString() {
        return this.productCode + " : " + this.description + " : $" + this.price + " : " + this.quantity + " units in stock";
    }
}
