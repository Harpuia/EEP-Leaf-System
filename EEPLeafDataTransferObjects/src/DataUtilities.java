/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yazid
 */
public class DataUtilities {

    public static String GetTableName(ItemType itemType) {
        String name = null;
        switch (itemType) {
            case CULTUREBOXES:
                name = "cultureboxes";
                break;
            case GENOMICS:
                name = "genomics";
                break;
            case PROCESSING:
                name = "processing";
                break;
            case REFERENCE_MATERIALS:
                name = "referencematerials";
                break;
            case SEEDS:
                name = "seeds";
                break;
            case SHRUBS:
                name = "shrubs";
                break;
            case TREES:
                name = "trees";
                break;
        }
        return name;
    }

    public static String GetTableDisplayName(ItemType itemType) {
        String name = null;
        switch (itemType) {
            case CULTUREBOXES:
                name = "CULTURE BOXES";
                break;
            case GENOMICS:
                name = "GENOMICS";
                break;
            case PROCESSING:
                name = "PROCESSING";
                break;
            case REFERENCE_MATERIALS:
                name = "REFERENCE MATERIALS";
                break;
            case SEEDS:
                name = "SEEDS";
                break;
            case SHRUBS:
                name = "SHRUBS";
                break;
            case TREES:
                name = "TREES";
                break;
        }
        return name;
    }

    public static String GetDatabaseName(ItemType itemType) {
        String databaseName = null;
        switch (itemType) {
            case CULTUREBOXES:
            case GENOMICS:
            case PROCESSING:
            case REFERENCE_MATERIALS:
                databaseName = "leaftech";
                break;
            case SEEDS:
            case SHRUBS:
            case TREES:
                databaseName = "inventory";
                break;
        }
        return databaseName;
    }
}
