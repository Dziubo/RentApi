package com.example.demo.inventory.asset;

import com.example.demo.assignment.Assignment;
import com.example.demo.inventory.asset.dto.AssetAssignmentDto;
import com.example.demo.inventory.asset.dto.AssetDto;
import com.example.demo.inventory.asset.mapper.AssetAssignmentMapper;
import com.example.demo.inventory.asset.mapper.AssetMapper;
import com.example.demo.inventory.category.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class    AssetService {
    private final AssetRepository assetRepository;
    private final CategoryRepository categoryRepository;
    public AssetService(AssetRepository assetRepository, CategoryRepository categoryRepository) {
        this.assetRepository = assetRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<AssetDto> getAllAssets(){
        return assetRepository.findAll().stream().map(AssetMapper::toDto).collect(Collectors.toList());
    }
    public List<AssetDto> getAllAssetsWithName(String text){
        return assetRepository.findAssetsByNameContainingIgnoreCaseOrSerialNumberContainingIgnoreCase(text ,text)
                .stream().map(AssetMapper::toDto).collect(Collectors.toList());
    }
    public AssetDto saveAsset(AssetDto assetsDto){
        Asset assets = AssetMapper.toEntity(assetsDto);
        categoryRepository.findCategoryByName(assetsDto.getCategory()).ifPresent(assets::setCategory);
        assetRepository.findAssetBySerialNumber(assetsDto.getSerialNumber())
                .ifPresent(x->{throw new AssetDuplicateSerialNumberException();});
        Asset savedAsset = assetRepository.save(assets);
        return AssetMapper.toDto(savedAsset);
    }
    public Optional<AssetDto> findById(Long id){
        return assetRepository.findById(id).map(AssetMapper::toDto);

    }

    public AssetDto update(AssetDto assetDto) {
        if (assetRepository.findAssetBySerialNumberThatHaveOtherId
                (assetDto.getSerialNumber(), assetDto.getId()).isPresent()){
            throw new AssetDuplicateSerialNumberException();
        }
        Asset asset = AssetMapper.toEntity(assetDto);
        categoryRepository.findCategoryByName(assetDto.getCategory()).ifPresent(asset::setCategory);
        Asset savedAsset = assetRepository.save(asset);
        return AssetMapper.toDto(savedAsset);
    }
    public List<AssetAssignmentDto> getAssetAssignments(Long id){
        Asset asset = assetRepository.findById(id).orElseThrow(()->{throw new NoSuchElementException();});
            return asset.getAssignments().stream().map(AssetAssignmentMapper::toDto).collect(Collectors.toList());
        }
    }

