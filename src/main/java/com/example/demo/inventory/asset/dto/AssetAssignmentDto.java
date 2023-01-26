package com.example.demo.inventory.asset.dto;

import java.time.LocalDateTime;

public class AssetAssignmentDto {
    Long id;
    LocalDateTime startOfAssignment;
    LocalDateTime endOfAssignment;
    Long userId;
    String firstName;
    String lastName;
    String pesel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartOfAssignment() {
        return startOfAssignment;
    }

    public void setStartOfAssignment(LocalDateTime startOfAssignment) {
        this.startOfAssignment = startOfAssignment;
    }

    public LocalDateTime getEndOfAssignment() {
        return endOfAssignment;
    }

    public void setEndOfAssignment(LocalDateTime endOfAssignment) {
        this.endOfAssignment = endOfAssignment;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

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
