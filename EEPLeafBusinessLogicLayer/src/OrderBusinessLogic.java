
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
    
        public String GetSeeds() {
        StringBuilder result = new StringBuilder();
        InventoryDataAccess inventory = new InventoryDataAccess(this.sqlServerIp);
        String log = null;
        Collection<InventoryItem> seeds = inventory.SelectSeedsInventory(log);
        if (seeds != null) {
            for (InventoryItem item : seeds) {
                result.append(item.toString() + "\n");
            }
            return result.toString();
        } else {
            return log;
        }
    }
        
        public String GetShrubs() {
        StringBuilder result = new StringBuilder();
        InventoryDataAccess inventory = new InventoryDataAccess(this.sqlServerIp);
        String log = null;
        Collection<InventoryItem> shrubs = inventory.SelectShrubsInventory(log);
        if (shrubs != null) {
            for (InventoryItem item : shrubs) {
                result.append(item.toString() + "\n");
            }
            return result.toString();
        } else {
            return log;
        }
    }
       public String Orders(String firstName, String lastName, String customerAddress, String phoneNumber, String sTotalCost, String[] items)
       {
           OrderDataAccess inventory = new OrderDataAccess(this.sqlServerIp);
           String log = null;
           String result=inventory.CreateAndInsertOrder(log, firstName, lastName, customerAddress, phoneNumber, sTotalCost, items); 
           return result;
       }
}