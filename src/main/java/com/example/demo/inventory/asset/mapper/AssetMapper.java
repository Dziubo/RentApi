package com.example.demo.inventory.asset.mapper;

import com.example.demo.inventory.asset.Asset;
import com.example.demo.inventory.asset.dto.AssetDto;
import com.example.demo.inventory.category.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class AssetMapper {
    private static CategoryRepository categoryRepository;

    public AssetMapper(CategoryRepository categoryRepository) {
        AssetMapper.categoryRepository = categoryRepository;
    }

    public static AssetDto toDto(Asset assets){
        AssetDto assetsDto = new AssetDto();
        assetsDto.setId(assets.getId());
        assetsDto.setDescription(assets.getDescription());
        assetsDto.setSerialNumber(assets.getSerialNumber());
        assetsDto.setName(assets.getName());
        if (assets.getCategory()!=null)
            assetsDto.setCategory(assets.getCategory().getName());
        return assetsDto;
    }
    public static Asset toEntity(AssetDto assetsDto){
        Asset asset = new Asset();
        asset.setId(assetsDto.getId());
        asset.setDescription(assetsDto.getDescription());
        asset.setSerialNumber(assetsDto.getSerialNumber());
        asset.setName(assetsDto.getName());
        return asset;
    }
}
