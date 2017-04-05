
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author yazid
 */
public class DataAccessBase {

    private final String sqlServerUserName = "remote";
    private final String sqlServerPassword = "remote_pass";
    private String sqlServerIP;
    protected String databaseName;

    public DataAccessBase() {

    }

    /**
     *
     * @param databaseIp
     * @param databaseName
     */
    public DataAccessBase(String sqlServerIP, String databaseName) {
        this.sqlServerIP = sqlServerIP;
        this.databaseName = databaseName;
    }

    /**
     * Creates a connection to the database
     *
     * @param log Used to output the messages
     * @return Null if connection failed, connection otherwise
     */
    protected Connection ConnectToDb(String log) {
        Connection DBConn = null;           // MySQL connection handle
        String errString = null;            // String for displaying errors
        String msgString = null;            // String for displaying non-error messages
        StringBuilder output = new StringBuilder();

        // Connect to the inventory database
        try {
            msgString = ">> Establishing Driver...";
            output.append("\n" + msgString);

            //Load J Connector for MySQL - explicit loads are not needed for 
            //connectors that are version 4 and better
            //Class.forName( "com.mysql.jdbc.Driver" );
            msgString = ">> Setting up URL...";
            output.append("\n" + msgString);

            //define the data source
            String sourceURL = "jdbc:mysql://" + sqlServerIP + ":3306/inventory";

            msgString = ">> Establishing connection with: " + sourceURL + "...";
            output.append("\n" + msgString);

            //create a connection to the db
            DBConn = DriverManager.getConnection(sourceURL, sqlServerUserName, sqlServerPassword);

        } catch (Exception e) {
            errString = "\nProblem connecting to database:: " + e;
            output.append(errString);
        }
        log = output.toString();
        return DBConn;
    }
        /**
     * Creates a connection to the database
     *
     * @param log Used to output the messages
     * @return Null if connection failed, connection otherwise
     */
    protected Connection ConnectToDb(boolean useDifDatabase, String log) {
        Connection DBConn = null;           // MySQL connection handle
        String errString = null;            // String for displaying errors
        String msgString = null;            // String for displaying non-error messages
        StringBuilder output = new StringBuilder();

        // Connect to the inventory database
        try {
            msgString = ">> Establishing Driver...";
            output.append("\n" + msgString);

            //Load J Connector for MySQL - explicit loads are not needed for 
            //connectors that are version 4 and better
            //Class.forName( "com.mysql.jdbc.Driver" );
            msgString = ">> Setting up URL...";
            output.append("\n" + msgString);

            //define the data source
            String sourceURL = "jdbc:mysql://" + sqlServerIP + ":3306/" + databaseName;

            msgString = ">> Establishing connection with: " + sourceURL + "...";
            output.append("\n" + msgString);

            //create a connection to the db
            DBConn = DriverManager.getConnection(sourceURL, sqlServerUserName, sqlServerPassword);

        } catch (Exception e) {
            errString = "\nProblem connecting to database:: " + e;
            output.append(errString);
        }
        log = output.toString();
        return DBConn;
    }
    
    protected Connection ConnectToOrderInfoDb(String log) {
        Connection DBConn = null;           // MySQL connection handle
        String errString = null;            // String for displaying errors
        String msgString = null;            // String for displaying non-error messages
        StringBuilder output = new StringBuilder();

        // Connect to the inventory database
        try {
            msgString = ">> Establishing Driver...";
            output.append("\n" + msgString);

            //Load J Connector for MySQL - explicit loads are not needed for 
            //connectors that are version 4 and better
            //Class.forName( "com.mysql.jdbc.Driver" );
            msgString = ">> Setting up URL...";
            output.append("\n" + msgString);

            //define the data source
            String sourceURL = "jdbc:mysql://" + sqlServerIP + ":3306/orderinfo";

            msgString = ">> Establishing connection with: " + sourceURL + "...";
            output.append("\n" + msgString);

            //create a connection to the db
            DBConn = DriverManager.getConnection(sourceURL, sqlServerUserName, sqlServerPassword);

        } catch (Exception e) {
            errString = "\nProblem connecting to database:: " + e;
            output.append(errString);
        }
        log = output.toString();
        return DBConn;
    }
}
