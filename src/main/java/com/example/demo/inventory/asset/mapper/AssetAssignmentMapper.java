package com.example.demo.inventory.asset.mapper;

import com.example.demo.assignment.Assignment;
import com.example.demo.inventory.asset.dto.AssetAssignmentDto;
import com.example.demo.user.User;

public class AssetAssignmentMapper {
    public static AssetAssignmentDto toDto(Assignment assignment){
        AssetAssignmentDto dto = new AssetAssignmentDto();
        dto.setId(assignment.getId());
        dto.setStartOfAssignment(assignment.getStartOfAssignment());
        dto.setEndOfAssignment(assignment.getEndOfAssignment());
        User user = assignment.getUser();
        dto.setUserId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setPesel(user.getPesel());
        return dto;
    }
}
