package com.demo.model;

import jakarta.persistence.*;


@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;
    private String password;
    private String name;
    private String age;
    private String gender;
    @Column(unique = true)
    private String phone;
    private String image;
    private Boolean status;
    @ManyToOne
    @JoinColumn(name = "location_id",referencedColumnName = "id")
    private Location location;
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    public Account() {
    }

    public Account(Long id, String email, String password, String name, String age, String gender, String phone, String image, Location location) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.image = image;
        this.location = location;
    }

    public Account(String email, String password, String phone, Role role) {
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role=role;
    }

    public Account(String email, String password, String name, String age, String phone, String gender, String image, Boolean status, Location location, Role role) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.image = image;
        this.status = status;
        this.location = location;
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String sex) {
        this.gender = sex;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Location getAddress() {
        return location;
    }

    public void setAddress(Location location) {
        this.location = location;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


}
