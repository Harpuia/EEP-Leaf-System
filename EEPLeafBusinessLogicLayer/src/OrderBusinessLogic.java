
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

    public String GetTrees() {
        StringBuilder result = new StringBuilder();
        InventoryDataAccess inventory = new InventoryDataAccess(this.sqlServerIp);
        String log = null;
        Collection<InventoryItem> trees = inventory.SelectTreeInventory(log);
        if (trees != null) {
            for (InventoryItem item : trees) {
                result.append(item.toString() + "\n");
            }
            return result.toString();
        } else {
            return log;
        }
    }
}