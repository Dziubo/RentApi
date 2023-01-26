package com.example.demo.user.dto;

import jakarta.validation.constraints.NotNull;

public class UserDto
{
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @NotNull(message = "imie nie może byc puste")

    String firstName;
    @NotNull(message = "nazwisko nie może byc puste")

    String lastName;
    @NotNull(message = "pesel nie może byc pusty")

    String pesel;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }
}
