/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yazid
 */
public class InventoryItem {

    public ItemType type;
    public String productCode;
    public String description;
    public float quantity;
    public float price;

    public InventoryItem(ItemType type, String productCode, String description, float quantity, float price) {
        this.type = type;
        this.productCode = productCode;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public InventoryItem(ItemType type, String productCode, String description, String quantity, String price) {
        this.type = type;
        this.productCode = productCode;
        this.description = description;
        this.quantity = quantity == null ? null : Float.parseFloat(quantity);
        this.price = price == null ? null : Float.parseFloat(price);
    }

    @Override
    public String toString() {
        return this.productCode + " : " + this.description + " : $" + this.price + " : " + this.quantity + " units in stock";
    }
}
