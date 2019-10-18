/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otlob;
import java.time.LocalDate;

/**
 *
 * @author Zeina Ayman
 */
public class User {
    protected String password;
    protected String username;
    LocalDate myObj = LocalDate.now();
    protected int userId;
    
    public User(String pass, String uname, int uId, LocalDate myObj)
    {
        password = pass;
        username = uname;
        userId = uId;
        this.myObj = myObj;
    }
    
    
    public Boolean verifylogin(){
        return true;
    }
    
    public int changePassword(){
        return 0;
    }
    
    
}
