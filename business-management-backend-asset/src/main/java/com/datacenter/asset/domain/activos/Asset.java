package com.datacenter.asset.domain.activos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Asset {
    private UUID id;
    private UUID companyId;
    private UUID assetTypeId;
    private UUID subAssetTypeId;
    private UUID ownershipTypeId;   // ✅ antes: tipoTenenciaId
    private UUID assetStatusId;     // ✅ antes: estadoActivoId
    private UUID locationId;        // ✅ antes: ubicacionId
    private UUID ownerId;           // ✅ antes: propietarioId
    private String code;
    private String name;
    private String description;
    private LocalDate registrationDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}