package com.example.demo.inventory.asset.mapper;

import com.example.demo.inventory.asset.Asset;
import com.example.demo.inventory.asset.dto.AssetCreateDto;

public class AssetCreateMapper {
    public static Asset toEntity(AssetCreateDto dto){
        Asset asset = new Asset();
        asset.setName(dto.getName());
        asset.setSerialNumber(dto.getSerialNumber());
        asset.setDescription(dto.getDescription());
        return asset;
    }
}
