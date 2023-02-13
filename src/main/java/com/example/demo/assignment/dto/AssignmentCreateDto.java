package com.example.demo.assignment.dto;

import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public class AssignmentCreateDto {
    @NotNull(message = "musi zostac podany użytkownik")
    private Long userId;
    @NotNull(message = "musi zostac podany przedmiot")
    private Long assetId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssignmentCreateDto that = (AssignmentCreateDto) o;
        return Objects.equals(userId, that.userId) && Objects.equals(assetId, that.assetId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, assetId);
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }
}
