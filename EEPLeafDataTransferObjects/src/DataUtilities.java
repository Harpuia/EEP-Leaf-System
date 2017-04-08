/**
 * ****************************************************************************
 *
 * This class defines the information of a specific item type..
 *
 *****************************************************************************
 */
/**
/**
 *
 * @author yazid
 */
public class DataUtilities {

    /**
     * Retrieve the table name for the specified item type.
     */
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
    /**
     * Retrieve the displayed table name for the specified item type.
     */
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

    /**
     * Retrieve the database name for the specified item type.
     */
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
    
    /**
     * Retrieve the column name for the specified item type.
     */
    public static String GetIdColumnName(ItemType itemType) {
        String columnName = null;
        switch (itemType) {
            case CULTUREBOXES:
            case GENOMICS:
            case PROCESSING:
            case REFERENCE_MATERIALS:
                columnName = "productid";
                break;
            case SEEDS:
            case SHRUBS:
            case TREES:
                columnName = "product_code";
                break;
        }
        return columnName;
    }
    /**
     * Retrieve the quantity column name for the specified item type.
     */
    public static String GetQuantityColumnName(ItemType itemType){
        String columnName = null;
        switch (itemType) {
            case CULTUREBOXES:
            case GENOMICS:
            case PROCESSING:
            case REFERENCE_MATERIALS:
                columnName = "productquantity";
                break;
            case SEEDS:
            case SHRUBS:
            case TREES:
                columnName = "quantity";
                break;
        }
        return columnName;
    }
}
