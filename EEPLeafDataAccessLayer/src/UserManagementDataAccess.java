
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * The class providing business logic for user management.
 * This includes login and logout.
 * @author Yuchao Zhou
 */
public class UserManagementDataAccess extends DataAccessBase{
    /** Constructor of the class. **/
    public UserManagementDataAccess(String sqlServerIP){
        super(sqlServerIP, "administration");
    }

    /**
     * Select a user account of the specified username
     * @param username input username
     * @param password input password
     * @param log The log shown to the user
     * @return The encapsulated user info
     */
    public LoginInfo selectLoginInfoByUsername(String username, String password, String log) {
        log = null;
        List<LoginInfo> result = new ArrayList<>();
        LoginInfo item;
        Connection connection = this.ConnectToDb(log);
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                ResultSet queryResult = statement.executeQuery("Select * from user_management where username = '" + username + "'");
                
                while (queryResult.next()) {
                    item = new LoginInfo(queryResult.getString(1), queryResult.getString(2));
                    result.add(item);
                }
                // Only return the first item.
                return result.get(0);
            } catch (Exception e) {
                log = "\nProblem getting order : " + e;
                return null;
            }
        } 
        
        // Failed to connect to the database
        else {
            return null;
        }
    }
    
    /**
     * Insert login/logout attempt to the log database
     * @param item a data structure contains login/logout info
     * @param log The message shown to the user
     * @return If the operation is successful or not
     */
    public boolean insertLogItem(LogItem item, String log) {
        String sqlStatement = null;
        Connection connection = this.ConnectToDb(log);
        if (connection != null) {
            Statement statement;
            try {
                statement = connection.createStatement();
                sqlStatement = ("INSERT INTO log" + " (activity, "
                            + "username, password, is_success) VALUES ( '"
                            + item.getActivity() + "', " + "'" + item.getUsername() + "', '"
                            + item.getPassword() + "', " + item.getSuccess() + ");");
                // execute the update
                statement.executeUpdate(sqlStatement);
                return true;
            } catch (Exception e) {
                log = "\nProblem adding inventory:: " + e;
                return false;
            }
        } 
        
        // Fail to connect to the database
        else {
            log = ("Connection fails...");
            return false;
        }
    }
}
