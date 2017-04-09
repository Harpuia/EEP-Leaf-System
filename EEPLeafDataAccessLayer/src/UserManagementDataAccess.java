
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Yuchao Zhou
 */
public class UserManagementDataAccess extends DataAccessBase{
    /** Constructor **/
    public UserManagementDataAccess(String sqlServerIP){
        super(sqlServerIP, "administration");
    }

    public LoginInfo selectLoginInfoByUsername(String log, String username, String password) {
        log = null;
        List<LoginInfo> result = new ArrayList<>();
        LoginInfo item;
        Connection connection = this.ConnectToDb(log);
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                ResultSet queryResult = statement.executeQuery("Select * from user_management where username = '" + username + "'");
                
                //Display the data in the textarea
                while (queryResult.next()) {
                    item = new LoginInfo(queryResult.getString(1), queryResult.getString(2));
                    result.add(item);
                }
                return result.get(0);
            } catch (Exception e) {
                log = "\nProblem getting order : " + e;
                return null;
            }
        } else {
            return null;
        }
    }
}
