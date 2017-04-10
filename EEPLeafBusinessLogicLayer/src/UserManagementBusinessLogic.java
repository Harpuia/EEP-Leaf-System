/**
 * The class providing business logic for user management.
 * This includes login and logout.
 * @author Yuchao Zhou
 */
public class UserManagementBusinessLogic {
    private String sqlServerIp;
    private UserManagementDataAccess dao;
    
    /** A simple session stored on the business logic layer */
    private LoginInfo loginSession;
    
    private LogItem item;
    private final int success;
    private final int failure;
    
    /**
     * The constructor of UserManagementBusinessLogic class.
     * @param sqlServerIp IP Address of the database server.
     */
    public UserManagementBusinessLogic(String sqlServerIp) {
        this.sqlServerIp = sqlServerIp;
        success = 1;
        failure = 0;
    }
    
    /**
     * The business logic of user login.
     * @param username The input username
     * @param password The input password
     * @return The response massage to the user
     */
    public String login(String username, String password) {
        dao = new UserManagementDataAccess(this.sqlServerIp);
        item = new LogItem("login", username, password, failure);
        String log = null;
        
        // Query the corresponding user account from the database
        loginSession = dao.selectLoginInfoByUsername(username, password, log);
        
        // Insert login attempt to the log table in every operation
        if(loginSession == null) {
            dao.insertLogItem(item, log);
            return "Your username or password was entered incorrecly. Please try again.";
        } else if(loginSession.getIsLoggedIn()) {
            dao.insertLogItem(item, log);
            return "User " + username + " has already logged in.";
        } else if(loginSession.verifyLoginInfo(username, password) == true) {
            loginSession.setIsLoggedIn(true);
            item.setSuccess(success);
            dao.insertLogItem(item, log);
            return "true";
        } else {
            dao.insertLogItem(item, log);
            return "Your username or password was entered incorrecly. Please try again.";
        }
    }
    
    /**
     * The business logic of user logout.
     * @param log The log message from the data access layer.
     * @return If logout is successful or not
     */
    public boolean logout(String log) {
        // Get user account information from the cached session.
        String username = loginSession.getUsername();
        String password = loginSession.getPassword();
        
        try {
            loginSession.setIsLoggedIn(false);
            
            // Insert logout attemp to the log table
            item = new LogItem("logout", username, password, success);
            dao.insertLogItem(item, log);
            return true;
        } catch(Exception e) {
            // Insert failed logout attemp to the log table
            item = new LogItem("logout", username, password, failure);
            dao.insertLogItem(item, log);
            log = log + "\nProblem occured logging out:: " + e;
            return false;
        } 
    }
}
