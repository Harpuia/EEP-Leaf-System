/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yuchao
 */
public class LoginInfo {
    private final String username;
    private final String pwd;
    private boolean isLoggedIn;
    
    
    public LoginInfo() {
        username = null;
        pwd = null;
        isLoggedIn = false;
    }
    
    public LoginInfo(String username, String pwd) {
        this.username = username;
        this.pwd = pwd;
    }
    
    
    public LoginInfo(String username, String pwd, boolean isLoggedIn) {
        this.username = username;
        this.pwd = pwd;
        this.isLoggedIn = isLoggedIn;
    }
    
    public boolean verifyLoginInfo(String username, String pwd) {
        return this.username.equals(username) && this.pwd.equals(pwd);
    }
    
    public boolean getIsLoggedIn() {
        return isLoggedIn;
    }
    
    public void setIsLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }
}
