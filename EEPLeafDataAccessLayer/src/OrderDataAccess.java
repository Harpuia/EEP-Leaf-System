import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rachel
 */
public class OrderDataAccess extends DataAccessBase {
    
    public OrderDataAccess(String sqlServerIP) {
        super(sqlServerIP, "order");
    }
    
        public String CreateAndInsertOrder(String log, String firstName, String lastName, String customerAddress, String phoneNumber, String sTotalCost, String[] items) 
    {
        //log=null;
        Connection connection = null;
        if(firstName.length()>0 && lastName.length()>0 && phoneNumber.length()>0 && customerAddress.length()>0)
        {
         connection = this.ConnectToOrderInfoDb(log);
        }
        else
        {
            log =  "\nMissing customer information!!!\n";
            return log;
        }
        
        String SQLstatement = null;
        Statement statement = null;
        String orderItem = null; 
        int executeUpdateVal=-1;
        int beginIndex=0;
        int endIndex=0;
        String productID=null;
        String description=null;
        String sPerUnitCost=null;
        String orderTableName=null;
        Float perUnitCost;
        float fCost;
        
        if (connection != null) {
            
            Calendar rightNow = Calendar.getInstance();

            int TheHour = rightNow.get(rightNow.HOUR_OF_DAY);
            int TheMinute = rightNow.get(rightNow.MINUTE);
            int TheSecond = rightNow.get(rightNow.SECOND);
            int TheDay = rightNow.get(rightNow.DAY_OF_WEEK);
            int TheMonth = rightNow.get(rightNow.MONTH);
            int TheYear = rightNow.get(rightNow.YEAR);
            orderTableName = "order" + String.valueOf(rightNow.getTimeInMillis());

            String dateTimeStamp = TheMonth + "/" + TheDay + "/" + TheYear + " "
                    + TheHour + ":" + TheMinute  + ":" + TheSecond;
            
            beginIndex = sTotalCost.indexOf("$",beginIndex)+1;
            sTotalCost = sTotalCost.substring(beginIndex, sTotalCost.length());
            fCost = Float.parseFloat(sTotalCost);
            try {
                
                statement = connection.createStatement();
                SQLstatement = ( "CREATE TABLE " + orderTableName +
                            "(item_id int unsigned not null auto_increment primary key, " +
                            "product_id varchar(20), description varchar(80), " +
                            "item_price float(7,2) );");
                executeUpdateVal = statement.executeUpdate(SQLstatement);
            }catch (Exception e) {

                log =  "\nProblem creating order table " + orderTableName +":: " + e;
                return log;

            } // try
            
            if(executeUpdateVal!=-1)
            {
                try
                {
                    SQLstatement = ( "INSERT INTO orders (order_date, " + "first_name, " +
                        "last_name, address, phone, total_cost, shipped, " +
                        "ordertable) VALUES ( '" + dateTimeStamp + "', " +
                        "'" + firstName + "', " + "'" + lastName + "', " +
                        "'" + customerAddress + "', " + "'" + phoneNumber + "', " +
                        fCost + ", " + false + ", '" + orderTableName +"' );");

                    executeUpdateVal = statement.executeUpdate(SQLstatement);
                    
                } catch (Exception e1) {

                    log =  "\nProblem with inserting into table orders:: " + e1;
                    executeUpdateVal = -1;

                    try
                    {
                        SQLstatement = ( "DROP TABLE " + orderTableName + ";" );
                        executeUpdateVal = statement.executeUpdate(SQLstatement);

                    } catch (Exception e2) {

                        log +=  "\nProblem deleting unused order table:: " +
                                orderTableName + ":: " + e2;
                        return log;

                    } // try
                    
                    return log;

                } // try
            }
            
            if(connection != null && executeUpdateVal != -1)
            {
                for (int i = 0; i < items.length; i++ )
            {
                orderItem = items[i];
            
                  if (orderItem.length() > 0 )
                {
                    // Parse out the product id
                    beginIndex = 0;
                    endIndex = orderItem.indexOf(" : ",beginIndex);
                    productID = orderItem.substring(beginIndex,endIndex);

                    // Parse out the description text
                    beginIndex = endIndex + 3; //skip over " : "
                    endIndex = orderItem.indexOf(" : ",beginIndex);
                    description = orderItem.substring(beginIndex,endIndex);

                    // Parse out the item cost
                    beginIndex = endIndex + 4; //skip over " : $"
                    //endIndex = orderItem.indexOf(" : ",orderItem.length());
                    //sPerUnitCost = orderItem.substring(beginIndex,endIndex);
                    sPerUnitCost = orderItem.substring(beginIndex,orderItem.length());
                    perUnitCost = Float.parseFloat(sPerUnitCost);

                    SQLstatement = ( "INSERT INTO " + orderTableName +
                        " (product_id, description, item_price) " +
                        "VALUES ( '" + productID + "', " + "'" +
                        description + "', " + perUnitCost + " );");
                    try
                    {
                        executeUpdateVal = statement.executeUpdate(SQLstatement);
                     //   log =  "\nORDER SUBMITTED FOR: " + firstName + " " + lastName;
                            
                    } catch (Exception e) {

                        log =  "\nProblem with inserting into table " + orderTableName +
                            ":: " + e;
                        return log;

                    } // try

                } // line length check
            }
                
           
            }
    }
        return log;
}
}
