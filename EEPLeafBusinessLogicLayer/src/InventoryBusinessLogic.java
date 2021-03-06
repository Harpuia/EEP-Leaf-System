
import java.util.Collection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author yazid
 */
public class InventoryBusinessLogic {
    
    private String sqlServerIp;
    /** Constructor **/
    public InventoryBusinessLogic(String sqlServerIp) {
        this.sqlServerIp = sqlServerIp;
    }
    
    public String addInventoryItem(InventoryItem item) {
        String log;
        InventoryDataAccess inventory = new InventoryDataAccess(this.sqlServerIp, item.type);
        log = inventory.insertInventoryItem(item);
        return log;
    }

    public String getInventoryItems(ItemType itemType) {
        String msgString = null;
        StringBuilder output = new StringBuilder();
        InventoryDataAccess inventory = new InventoryDataAccess(this.sqlServerIp, itemType);
        Collection<InventoryItem> results = inventory.selectInventoryItems(itemType, msgString);
        String tableSelected = DataUtilities.GetTableDisplayName(itemType);
        if (results != null) {
            for (InventoryItem result : results) {
                msgString = tableSelected + ">>" + result.productCode + "::" + result.description
                        + " :: " + result.quantity + "::" + result.price;
                output.append("\n" + msgString);
            }
            return output.toString();
        } else {
            return msgString;
        }
    }
    /**
     * Delete inventory item, identified by id and item type
     * @param id
     * @param itemType
     * @param log
     * @return 
     */
    public int deleteInventoryItem(String id, ItemType itemType, String log) {
        int executeUpdateValue;
        InventoryDataAccess inventory = new InventoryDataAccess(this.sqlServerIp, itemType);
        executeUpdateValue = inventory.deleteInventoryItem(id, itemType, log);
        return executeUpdateValue;
    }
    /**
     * Decrement inventory item, identified by id and item type
     * @param id
     * @param itemType
     * @param log
     * @return 
     */
    public int decrementInventoryItem(String id, ItemType itemType, String log) {
        int executeUpdateValue;
        InventoryDataAccess inventory = new InventoryDataAccess(this.sqlServerIp, itemType);
        executeUpdateValue = inventory.decrementInventoryItem(id, itemType, log);
        return executeUpdateValue;
    }
}
