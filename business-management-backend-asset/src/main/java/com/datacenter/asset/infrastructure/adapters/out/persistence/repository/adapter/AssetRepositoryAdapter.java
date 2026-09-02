package com.datacenter.asset.infrastructure.adapters.out.persistence.repository.adapter;

import com.datacenter.asset.domain.activos.Asset;
import com.datacenter.asset.domain.ports.out.AssetRepositoryPort;
import com.datacenter.asset.infrastructure.adapters.out.persistence.entity.AssetEntity;
import com.datacenter.asset.infrastructure.adapters.out.persistence.mapper.AssetPersistenceMapper;
import com.datacenter.asset.infrastructure.adapters.out.persistence.repository.SpringDataActivoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class AssetRepositoryAdapter implements AssetRepositoryPort {

    private final SpringDataActivoRepository repository;
    private final AssetPersistenceMapper mapper;

    public AssetRepositoryAdapter(SpringDataActivoRepository repository, AssetPersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Asset save(Asset asset) {
        AssetEntity entity = mapper.toEntity(asset);
        AssetEntity savedEntity = repository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public List<Asset> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Asset> findById(UUID id) {
        return repository.findById(id).map(mapper::toDomain);
    }
}