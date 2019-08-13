package com.example.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class User implements Serializable {
    private static final long serialVersionUID = 4969328123591221843L;
    private int id;
    private String name;
    private String password;
    private String phone;
    private String email;
    private int gender;
    private String createUser;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    private String updateUser;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateDate;

    public User() {
    }

    public User(int id, String name, String password, String phone, String email, int gender, String createUser, Date createDate, String updateUser, Date updateDate) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.createUser = createUser;
        this.createDate = createDate;
        this.updateUser = updateUser;
        this.updateDate = updateDate;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                gender == user.gender &&
                Objects.equals(name, user.name) &&
                Objects.equals(password, user.password) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(email, user.email) &&
                Objects.equals(createUser, user.createUser) &&
                Objects.equals(createDate, user.createDate) &&
                Objects.equals(updateUser, user.updateUser) &&
                Objects.equals(updateDate, user.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password, phone, email, gender, createUser, createDate, updateUser, updateDate);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", createUser='" + createUser + '\'' +
                ", createDate=" + createDate +
                ", updateUser='" + updateUser + '\'' +
                ", updateDate=" + updateDate +
                '}';
    }
}
