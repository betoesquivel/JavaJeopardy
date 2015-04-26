/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import com.fasterxml.jackson.jr.ob.JSON;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author betoesquivel
 */
public class Category {
    private int id;
    private String name;
    private int fkClass;

    public Category() {
        
    }
/*
    public Category(String json) {
        try {        
            Map<String,Object> map = JSON.std.mapFrom(json);
            this.id = (int) map.get("id");
            this.name = (String) map.get("name");
            this.fkClass = (int) map.get("fkClass");
        } catch (IOException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 */  
    public Category(int id, String name, int fkClass) {
        this.id = id;
        this.name = name;
        this.fkClass = fkClass;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getFkClass() {
        return fkClass;
    }

    public void setFkClass(int fkClass) {
        this.fkClass = fkClass;
    }
}
