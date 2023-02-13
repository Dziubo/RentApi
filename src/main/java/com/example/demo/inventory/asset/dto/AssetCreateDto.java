package com.example.demo.inventory.asset.dto;

import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public class AssetCreateDto {
    @NotNull(message = "urządzenie musi miec nazwę.")
    private String name;

    private String description;
    @NotNull(message = "urządzenie musi miec numerSeryjny.")
    private String serialNumber;
    @NotNull(message = "urządzenie musi miec kategorie.")
    private String categoryName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssetCreateDto that = (AssetCreateDto) o;
        return Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(serialNumber, that.serialNumber) && Objects.equals(categoryName, that.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, serialNumber, categoryName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
