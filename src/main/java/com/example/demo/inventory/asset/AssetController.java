package com.example.demo.inventory.asset;

    import com.example.demo.inventory.asset.dto.AssetAssignmentDto;
    import com.example.demo.inventory.asset.dto.AssetCreateDto;
    import com.example.demo.inventory.asset.dto.AssetDto;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;
    import org.springframework.web.server.ResponseStatusException;
    import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

    import java.net.URI;
    import java.util.List;

@RestController
@RequestMapping("/api/assets")
public class AssetController {
    private final AssetService assetsService;

    public AssetController(AssetService assetsService) {
        this.assetsService = assetsService;
    }

    @GetMapping
    public List<AssetDto> getAllAssets(@RequestParam(required = false) String text){
        if (text == null)
            return assetsService.getAllAssets();
        return assetsService.getAllAssetsWithName(text);
    }
    @PostMapping
    public ResponseEntity<AssetDto> saveAsset(@RequestBody AssetCreateDto assetsDto){
        AssetDto assetDto = assetsService.saveAsset(assetsDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(assetDto.getId()).toUri();
        return ResponseEntity.created(uri).body(assetDto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AssetDto> findById(@PathVariable Long id){
        return assetsService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<AssetDto> update(@PathVariable Long id , @RequestBody AssetDto assetDto){
        if (!id.equals(assetDto.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST , "Aktualizowany obiekt powinien mieć id zgodne z id ścieżki zasobu");
        }
        AssetDto assetDto1 = assetsService.update(assetDto);
        return ResponseEntity.ok(assetDto1);
    }
    @GetMapping("/{assetId}/assignments")
    public List<AssetAssignmentDto> getAssetAssignments(@PathVariable Long assetId){
        return assetsService.getAssetAssignments(assetId);
    }
}
