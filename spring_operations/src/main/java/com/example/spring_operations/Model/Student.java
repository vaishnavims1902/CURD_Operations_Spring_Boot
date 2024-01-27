package com.example.spring_operations.Model;

import jakarta.persistence.*;

@Entity
@Table(name="info")
public class Student {
    @Id
    @GeneratedValue
    private int id;

    private String name,contact,address;

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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", contact=" + contact + ", address=" + address + "]";
    }

    public Student() {
    }

    public Student(int id, String name, String contact, String address) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.address = address;
    }

    

    
}
