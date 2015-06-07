
package com.studentlist.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
public class Student {
    
    @Id
    private String id;
    
    private String registrationNumber ;
    
    private int age ;
    
    private String address ;
    
    private String fullName ;
    
    private String email ;

    public Student(String registrationNumber, String fullName, int age, String address, String email) {
        this.registrationNumber = registrationNumber;
        this.fullName = fullName;
        this.age = age;
        this.address = address;
        this.email = email;
    }

    public Student() {
    }
    
    public Student(Student student) {
        this.registrationNumber = student.registrationNumber;
        this.fullName = student.fullName ;
        this.age = student.age ;
        this.address = student.address;
        this.email = student.email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
}
