package com.datacenter.asset.application.service;

import com.datacenter.asset.domain.activos.Asset;
import com.datacenter.asset.domain.ports.out.AssetRepositoryPort;
import com.datacenter.asset.infrastructure.adapters.in.rest.dto.request.CreateAssetRequest;
import com.datacenter.asset.infrastructure.adapters.in.rest.dto.response.AssetResponse;
import com.datacenter.asset.infrastructure.adapters.in.rest.mapper.AssetRestMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AssetService {

    private final AssetRepositoryPort repositoryPort;
    private final AssetRestMapper restMapper;

    public AssetService(AssetRepositoryPort repositoryPort, AssetRestMapper restMapper) {
        this.repositoryPort = repositoryPort;
        this.restMapper = restMapper;
    }

    public AssetResponse createAsset(CreateAssetRequest request) {
        Asset domainAsset = restMapper.toDomain(request);
        Asset savedAsset = repositoryPort.save(domainAsset);
        return restMapper.toResponse(savedAsset);
    }

    public List<AssetResponse> findAll() {
        return repositoryPort.findAll().stream()
                .map(restMapper::toResponse) // Mapeo explícito a AssetResponse
                .toList();
    }

    public AssetResponse findById(UUID id) {
        return repositoryPort.findById(id)
                .map(restMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Asset not found with id: " + id));
    }
}