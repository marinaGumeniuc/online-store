package com.oline.store.dao.impl;

import com.oline.store.dao.dto.RoleDto;

import java.math.BigDecimal;

public class UserContainer {
    private String name;
    private String surname;
    private String email;
    private String creditCard;
    private BigDecimal money;
    private RoleDto role;
    private int id;

    public UserContainer(String name, String surname, String email, String creditCard, BigDecimal money, RoleDto role) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.creditCard = creditCard;
        this.money = money;
        this.role = role;
    }

    public UserContainer() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {

        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public RoleDto getRole() {
        return role;
    }

    public void setRole(RoleDto role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserContainer{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", creditCard='" + creditCard + '\'' +
                ", money=" + money +
                ", role=" + role +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
