package com.datacenter.asset.infrastructure.adapters.in.rest.mapper;

import com.datacenter.asset.domain.parametrizacion.SubAssetType;
import com.datacenter.asset.infrastructure.adapters.in.rest.dto.request.CreateSubAssetTypeRequest;
import com.datacenter.asset.infrastructure.adapters.in.rest.dto.response.FieldGroupFormResponse;
import com.datacenter.asset.infrastructure.adapters.in.rest.dto.response.SubAssetTypeFormResponse;
import com.datacenter.asset.infrastructure.adapters.in.rest.dto.response.SubAssetTypeResponse;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class SubAssetTypeRestMapper {

    public SubAssetType toDomain(
            CreateSubAssetTypeRequest request
    ) {

        if (request == null) {
            return null;
        }

        return SubAssetType.builder()
                .assetTypeId(request.getAssetTypeId())
                .code(request.getCode())
                .name(request.getName())
                .description(request.getDescription())
                .active(true)
                .build();
    }

    public SubAssetTypeResponse toResponse(
            SubAssetType domain
    ) {

        if (domain == null) {
            return null;
        }

        return SubAssetTypeResponse.builder()
                .id(domain.getId())
                .assetTypeId(domain.getAssetTypeId())
                .code(domain.getCode())
                .name(domain.getName())
                .description(domain.getDescription())
                .active(domain.isActive())
                .build();
    }

    public SubAssetTypeFormResponse toFormResponse(
            SubAssetTypeResponse response,
            List<FieldGroupFormResponse> groups
    ) {
        if (response == null) {
            return null;
        }

        return new SubAssetTypeFormResponse(
                response.getId(),
                response.getName(),
                groups
        );
    }
}