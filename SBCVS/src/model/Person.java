/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;

/**
 *
 * @author Administrador
 */
public class Person {
    String name;
    String id;
    String type;
    String location;
    String school;
    String status;

    public Person(String name, String id, String type, String location, String school, String status) {
        this.name = name;
        this.id = id;
        this.type = type;
        this.location = location;
        this.school = school;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }

    public String getSchool() {
        return school;
    }

    public String getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "{\"name\":\"" + name + "\", \"id\":\"" + id + "\", \"type\":\"" + type + "\", \"location\":\"" + location + "\", \"school\":\"" + school + "\", \"status\":\"" + status + "\"}";
    }



    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (!this.id.equalsIgnoreCase(other.id)) {
            return false;
        }
        return true;
    }
    
    
}
