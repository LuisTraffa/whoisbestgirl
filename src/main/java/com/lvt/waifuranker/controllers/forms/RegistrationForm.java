package com.lvt.waifuranker.controllers.forms;

import com.lvt.waifuranker.models.User;

public class RegistrationForm {
    
    private String username;
    private String password;
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public void apply(User user) {
        user.setUsername(username);
        user.setPassword(password);
    }
}
