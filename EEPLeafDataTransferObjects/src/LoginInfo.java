/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * A data structure storing the login info of a user
 * @author Yuchao
 */
public class LoginInfo {
    private final String username;
    private final String pwd;
    private boolean isLoggedIn;
    
    /**
     * Default constructor of LoginInfo
     */
    public LoginInfo() {
        username = null;
        pwd = null;
        isLoggedIn = false;
    }
    
    /**
     * Constructor with parameters of LoginInfo
     * @param username username
     * @param pwd password
     */
    public LoginInfo(String username, String pwd) {
        this.username = username;
        this.pwd = pwd;
    }
    
    /**
     * Constructor with parameters of LoginInfo
     * @param username username
     * @param pwd password
     * @param isLoggedIn isLoggedIn
     */
    public LoginInfo(String username, String pwd, boolean isLoggedIn) {
        this.username = username;
        this.pwd = pwd;
        this.isLoggedIn = isLoggedIn;
    }
    
    /**
     * A method to authenticate the input user account
     * @param username input username
     * @param pwd input password
     * @return if the username and password are correct
     */
    public boolean verifyLoginInfo(String username, String pwd) {
        return this.username.equals(username) && this.pwd.equals(pwd);
    }
    
    /**
     * The getter method of username
     * @return username
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * The getter method of password
     * @return password
     */
    public String getPassword() {
        return pwd;
    }
    
    /**
     * The getter method of isLoggedIn
     * @return isLoggedIn
     */
    public boolean getIsLoggedIn() {
        return isLoggedIn;
    }
    
    /**
     * The setter method of isLoggedIn
     * @param isLoggedIn isLoggedin
     */
    public void setIsLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }
}
