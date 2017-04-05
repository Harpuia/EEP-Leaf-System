
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

    public InventoryBusinessLogic(String sqlServerIp) {
        this.sqlServerIp = sqlServerIp;
    }

    public String addInventoryItem(InventoryItem item) {
        String log;
        InventoryDataAccess inventory = new InventoryDataAccess(this.sqlServerIp, DataUtilities.GetDatabaseName(item.type));
        log = inventory.InsertInventoryItem(item);
        return log;
    }

    public String getInventoryItems(String sqlServerIpAddress, ItemType itemType) {
        String msgString = null;
        StringBuilder output = new StringBuilder();
        String databaseName = null;
        InventoryDataAccess inventory = new InventoryDataAccess(this.sqlServerIp, DataUtilities.GetDatabaseName(itemType));
        InventoryDataAccess inventoryData = new InventoryDataAccess(sqlServerIpAddress);
        Collection<InventoryItem> results = inventoryData.selectInventoryItems(itemType, msgString);
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

}
