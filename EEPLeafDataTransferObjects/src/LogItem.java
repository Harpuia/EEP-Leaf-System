/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * A data structure that stores the info transfered to the log database.
 * @author Yuchao
 */
public class LogItem {
    /** User activity which could be "login" or "logout" */
    private String activity;
    private String username;
    private String password;
    
    /** 1 refers to success while 0 refers to failure */
    private int is_success;
    
    /**
     * The default constructor of LogItem
     */
    public LogItem() {
        activity = null;
        username = null;
        password = null;
        is_success = 0;
    }
    
    /**
     * The constructor with parameters of LogItem
     * @param activity input activity
     * @param username input username
     * @param password input password
     * @param is_success input is_success
     */
    public LogItem(String activity, String username, String password, int is_success) {
        this.activity = activity;
        this.username = username;
        this.password = password;
        this.is_success = is_success;
    }
    
    /**
     * The getter method of activity
     * @return activity
     */
    public String getActivity() {
        return activity;
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
        return password;
    }
    
    /**
     * The getter method of success
     * @return success
     */
    public int getSuccess() {
        return is_success;
    }
    
    /**
     * The setter method of activity
     * @param activity activity
     */
    public void setActivity(String activity) {
        this.activity = activity;
    }
    
    /**
     * The setter method of username
     * @param username username
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
     * The setter method of password
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * The setter method of is_success
     * @param is_success is_success
     */
    public void setSuccess(int is_success) {
        this.is_success = is_success;
    }
}
