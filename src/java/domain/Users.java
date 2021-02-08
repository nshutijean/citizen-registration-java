/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Nick
 */
@Entity
public class Users {
    @Id
    private String username;
    private String password;
    private String accountStatus;
    private String role;

    public Users() {
    }
    
    public Users(String username, String password, String accountStatus) {
        this.username = username;
        this.password = password;
        this.accountStatus = accountStatus;
    }

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

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Users{" + "username=" + username + ", password=" + password + ", accountStatus=" + accountStatus + ", role=" + role + '}';
    }
   
    
}
