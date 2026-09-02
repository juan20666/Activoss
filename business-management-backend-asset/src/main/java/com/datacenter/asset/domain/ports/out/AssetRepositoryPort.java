package com.datacenter.asset.domain.ports.out;

import com.datacenter.asset.domain.activos.Asset;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AssetRepositoryPort {
    Asset save(Asset asset);
    List<Asset> findAll();
    Optional<Asset> findById(UUID id);
}