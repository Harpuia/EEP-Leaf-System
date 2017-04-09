/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yuchao
 */
public class UserManagementBusinessLogic {
    private String sqlServerIp;
    private UserManagementDataAccess dao;
    private LoginInfo loginSession;
    private LogItem item;
    private final int success;
    private final int failure;
    
    
    public UserManagementBusinessLogic(String sqlServerIp) {
        this.sqlServerIp = sqlServerIp;
        success = 1;
        failure = 0;
    }
    
    public String login(String username, String password) {
        dao = new UserManagementDataAccess(this.sqlServerIp);
        item = new LogItem("login", username, password, failure);
        String log = null;
        loginSession = dao.selectLoginInfoByUsername(username, password, log);
        
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
    
    public boolean logout(String log) {
        String username = loginSession.getUsername();
        String password = loginSession.getPassword();
        
        try {
            loginSession.setIsLoggedIn(false);
            item = new LogItem("logout", username, password, success);
            dao.insertLogItem(item, log);
            return true;
        } catch(Exception e) {
            item = new LogItem("logout", username, password, failure);
            dao.insertLogItem(item, log);
            log = log + "\nProblem occured logging out:: " + e;
            return false;
        } 
    }
}
