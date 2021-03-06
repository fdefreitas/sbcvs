/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;

/**
 * Clase que contiene todos los atributos de un miembro de la comunidad universitaria como persona
 * @author Fernando
 */
public class Person implements Comparable<Person>{
    
    static final String PROFESOR = "profesor", ESTUDIANTE = "estudiante", EGRESADO = "egresado", EMPLEADO = "empleado";
    private String name, id, type, location, school, status;

    public Person(String data) throws Exception {
        String[] fields = data.split(",");
        if(fields.length < 6){
            throw new Exception("Incomplete Data Exception");
        }
        for(int i =0; i < fields.length; ++i){
            if(i == 0){
                name = fields[i].toLowerCase();
            } else if(i == 1){
                id = fields[i].toLowerCase();
            } else if(i == 2){
                type = fields[i].toLowerCase();
            } else if(i == 3){
                location = fields[i].toLowerCase();
            } else if(i == 4){
                school = fields[i].toLowerCase();
            } else if(i == 5){
                status = fields[i].toLowerCase();
            }
        }
    }

    public Person() {
        name = new String(); 
        id  = new String(); 
        type = new String();
        location = new String();
        school = new String(); 
        status = new String();
    }
    
    @Override
    public Person clone() throws CloneNotSupportedException {
        return new Person(name, id, type, location, school, status);
    }

    public Person(String name, String id, String type, String location, String school, String status) {
        this.name = (name!=null?name.toLowerCase():null);
        this.id = (id!=null?id.toLowerCase():null);
        this.type = (type!=null?type.toLowerCase():null);
        this.location = (location!=null?location.toLowerCase():null);
        this.school = (school!=null?school.toLowerCase():null);
        this.status = (status!=null?status.toLowerCase():null);
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
        return "(persona (nombre \""+name+"\") (cedula \""+id+"\") (tipo \""+type+"\") (status \""+status+"\") (nucleo \""+location+"\") (escuela \""+school+"\"))";
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
    //    hash = 37 * hash + Objects.hashCode(this.type);
        return hash;
    }

    @Override
    public int compareTo(Person o) {
        int actual = Objects.hashCode(this.type);
        int other = Objects.hashCode(o.getType());
        if(actual > other){
            return 1;
        } else if(actual < other){
            return -1;
        } else {
            actual = Objects.hashCode(this.location);
            other = Objects.hashCode(o.getLocation());
            if(actual > other){
                return -1;
            } else if(actual < other){
                return 1;
            } else {
                actual = Objects.hashCode(this.id);
                other = Objects.hashCode(o.getId());
                if(actual > other){
                    return -1;
                } else if(actual < other){
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }

}
