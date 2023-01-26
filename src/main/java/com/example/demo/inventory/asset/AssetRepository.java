package com.example.demo.inventory.asset;

import com.example.demo.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssetRepository extends CrudRepository<Asset, Long> {
    List<Asset> findAll();
    List<Asset> findAssetsByNameContainingIgnoreCaseOrSerialNumberContainingIgnoreCase(String text , String text2);
    @Query(value = "SELECT a FROM Asset a where a.id <>?2  and a.serialNumber=?1")
    Optional<Asset> findAssetBySerialNumberThatHaveOtherId(String serialNumber , Long id);
    Optional<Asset> findAssetBySerialNumber(String serialNumber);
    Optional<Asset> findAssetsById(Long id);
}
