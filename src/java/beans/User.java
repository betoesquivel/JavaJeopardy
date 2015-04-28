/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author hlg
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private int status;

    public User() {
        id = 0;
        password = null;
        email = null;
        username = null;
        status = 0;
    }

    public User(int id, String username, String password, String email) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.username = username;
        this.status = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
