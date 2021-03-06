package services;

import dataaccess.UserDB;
import models.Role;
import models.User;

public class AccountService {
    
    public User login(String email, String password) {
        UserDB userDB = new UserDB();
        
        try {
            User user = userDB.get(email);
            if (password.equals(user.getPassword())) {
                return user;
            }
        } catch (Exception e) {
        }
        
        return null;
    }
    
    public Role getRole(String email) {
        UserDB userDB = new UserDB();
        
        try {
            Role role = userDB.get(email).getRole();
            return role;
        } catch (Exception e) {
        }
        return null;
    }
}
