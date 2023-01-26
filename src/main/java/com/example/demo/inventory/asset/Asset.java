package com.example.demo.inventory.asset;

import com.example.demo.assignment.Assignment;
import com.example.demo.inventory.category.Category;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Assets")
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
   private  String description;
    private String serialNumber;

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    @OneToMany(mappedBy = "asset")
    private List<Assignment> assignments = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asset assets = (Asset) o;
        return Objects.equals(id, assets.id) && Objects.equals(name, assets.name) && Objects.equals(description, assets.description) && Objects.equals(serialNumber, assets.serialNumber) && Objects.equals(category, assets.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, serialNumber, category);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToOne
    private Category category;

    @Override
    public String toString() {
        return "Asset{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", category=" + category +
                '}';
    }
}
