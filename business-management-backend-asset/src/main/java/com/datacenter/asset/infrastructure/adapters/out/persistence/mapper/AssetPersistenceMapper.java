package com.datacenter.asset.infrastructure.adapters.out.persistence.mapper;

import com.datacenter.asset.domain.activos.Asset;
import com.datacenter.asset.infrastructure.adapters.out.persistence.entity.AssetEntity;
import org.springframework.stereotype.Component;

@Component
public class AssetPersistenceMapper {

    public AssetEntity toEntity(Asset domain) {
        if (domain == null) return null;
        return AssetEntity.builder()
                .id(domain.getId())
                .companyId(domain.getCompanyId())
                .assetTypeId(domain.getAssetTypeId())       // ✅ correcto
                .subAssetTypeId(domain.getSubAssetTypeId()) // ✅ correcto
                .ownershipTypeId(domain.getOwnershipTypeId()) // ✅ correcto
                .assetStatusId(domain.getAssetStatusId())     // ✅ correcto
                .locationId(domain.getLocationId())           // ✅ correcto
                .ownerId(domain.getOwnerId())                 // ✅ correcto
                .code(domain.getCode())
                .name(domain.getName())
                .description(domain.getDescription())
                .registrationDate(domain.getRegistrationDate())
                .createdAt(domain.getCreatedAt())
                .updatedAt(domain.getUpdatedAt())
                .build();
    }

    public Asset toDomain(AssetEntity entity) {
        if (entity == null) return null;
        return Asset.builder()
                .id(entity.getId())
                .companyId(entity.getCompanyId())
                .assetTypeId(entity.getAssetTypeId())        // ✅ correcto
                .subAssetTypeId(entity.getSubAssetTypeId())  // ✅ correcto
                .ownershipTypeId(entity.getOwnershipTypeId()) // ✅ correcto
                .assetStatusId(entity.getAssetStatusId())     // ✅ correcto
                .locationId(entity.getLocationId())           // ✅ correcto
                .ownerId(entity.getOwnerId())                 // ✅ correcto
                .code(entity.getCode())
                .name(entity.getName())
                .description(entity.getDescription())
                .registrationDate(entity.getRegistrationDate())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
