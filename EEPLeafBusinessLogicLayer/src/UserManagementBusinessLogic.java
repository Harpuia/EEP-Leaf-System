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
    
    
    public UserManagementBusinessLogic(String sqlServerIp) {
        this.sqlServerIp = sqlServerIp;
        
    }
    
    public String login(String username, String password) {
        dao = new UserManagementDataAccess(this.sqlServerIp);
        String log = null;
        loginSession = dao.selectLoginInfoByUsername(log, username, password);
        
        if(loginSession == null) {
            return "Your username or password was entered incorrecly. Please try again.";
        } else if(loginSession.getIsLoggedIn()) {
            return "User " + username + " has already logged in.";
        } else if(loginSession.verifyLoginInfo(username, password) == true) {
            loginSession.setIsLoggedIn(true);
            return "true";
        } else {
            return "Your username or password was entered incorrecly. Please try again.";
        }
    }
    
    public void logout() {
        loginSession.setIsLoggedIn(false);
    }
}
