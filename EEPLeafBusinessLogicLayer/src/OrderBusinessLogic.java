
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
public class OrderBusinessLogic {

    private String sqlServerIp;

    public OrderBusinessLogic(String sqlServerIp) {
        this.sqlServerIp = sqlServerIp;
    }

    public String GetInventoryItems(ItemType itemType) {
        StringBuilder result = new StringBuilder();
        InventoryDataAccess inventory = new InventoryDataAccess(this.sqlServerIp);
        String log = null;
        Collection<InventoryItem> trees = inventory.selectInventoryItems(itemType, log);
        if (trees != null) {
            for (InventoryItem item : trees) {
                result.append(item.toString() + "\n");
            }
            return result.toString();
        } else {
            return log;
        }
    }

    public String CreateOrder(String firstName, String lastName, String customerAddress, String phoneNumber, String sTotalCost, String[] items) {
        OrderDataAccess orders = new OrderDataAccess(this.sqlServerIp);
        String log = null;
        String result = orders.CreateAndInsertOrder(log, firstName, lastName, customerAddress, phoneNumber, sTotalCost, items);
        return result;
    }
}
