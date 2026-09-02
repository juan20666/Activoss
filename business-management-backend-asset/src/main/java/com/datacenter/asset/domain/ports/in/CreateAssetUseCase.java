package com.datacenter.asset.domain.ports.in;

import com.datacenter.asset.domain.activos.Asset;

public interface CreateAssetUseCase {
    Asset createAsset(Asset asset);
}