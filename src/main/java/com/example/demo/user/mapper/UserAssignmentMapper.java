package com.example.demo.user.mapper;

import com.example.demo.assignment.Assignment;
import com.example.demo.inventory.asset.Asset;
import com.example.demo.user.dto.UserAssignmentDto;

public class UserAssignmentMapper {
    public  static UserAssignmentDto  toDto(Assignment assignment){
        UserAssignmentDto userAssignmentDto = new UserAssignmentDto();
        userAssignmentDto.setId(assignment.getId());
        userAssignmentDto.setStart(assignment.getStartOfAssignment());
        userAssignmentDto.setEnd(assignment.getEndOfAssignment());
        Asset asset = assignment.getAsset();
        userAssignmentDto.setAssetId(asset.getId());
        userAssignmentDto.setAssetName(asset.getName());
        userAssignmentDto.setAssetSerialNumber(asset.getSerialNumber());
        return userAssignmentDto;
    }
}
