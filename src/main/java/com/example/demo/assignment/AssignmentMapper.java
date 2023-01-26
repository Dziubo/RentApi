package com.example.demo.assignment;

public class AssignmentMapper {
    public static AssignmentDto toDto(Assignment assignment){
        AssignmentDto dto = new AssignmentDto();
        dto.setId(assignment.getId());
        dto.setStart(assignment.getStartOfAssignment());
        dto.setEnd(assignment.getEndOfAssignment());
        dto.setUserId(assignment.getUser().getId());
        dto.setAssetId(assignment.getAsset().getId());
        return dto;
    }
}
