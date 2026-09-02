package com.datacenter.asset.infrastructure.adapters.in.rest.mapper;

import com.datacenter.asset.domain.activos.Asset;
import com.datacenter.asset.infrastructure.adapters.in.rest.dto.request.CreateAssetRequest;
import com.datacenter.asset.infrastructure.adapters.in.rest.dto.response.AssetResponse;
import org.springframework.stereotype.Component;

@Component
public class AssetRestMapper {

    public Asset toDomain(CreateAssetRequest request) {
        if (request == null) return null;
        return Asset.builder()
                .companyId(request.getCompanyId())
                .assetTypeId(request.getAssetTypeId())
                .subAssetTypeId(request.getSubAssetTypeId())
                .ownershipTypeId(request.getOwnershipTypeId())   // ✅ corregido
                .assetStatusId(request.getAssetStatusId())       // ✅ corregido
                .locationId(request.getLocationId())             // ✅ corregido
                .ownerId(request.getOwnerId())                   // ✅ corregido
                .code(request.getCode())
                .name(request.getName())
                .description(request.getDescription())
                .registrationDate(request.getRegistrationDate())
                .build();
    }

    public AssetResponse toResponse(Asset domain) {
        if (domain == null) return null;
        return AssetResponse.builder()
                .id(domain.getId())
                .companyId(domain.getCompanyId())
                .assetTypeId(domain.getAssetTypeId())
                .subAssetTypeId(domain.getSubAssetTypeId())
                .ownershipTypeId(domain.getOwnershipTypeId())    // ✅ corregido
                .assetStatusId(domain.getAssetStatusId())        // ✅ corregido
                .locationId(domain.getLocationId())              // ✅ corregido
                .ownerId(domain.getOwnerId())                    // ✅ corregido
                .code(domain.getCode())
                .name(domain.getName())
                .description(domain.getDescription())
                .registrationDate(domain.getRegistrationDate())
                .createdAt(domain.getCreatedAt())
                .updatedAt(domain.getUpdatedAt())
                .build();
    }
}
