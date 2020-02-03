package com.tryputs.backend.mapper;

import com.tryputs.backend.dto.AbstractDto;
import com.tryputs.backend.entity.IdentifiableEntity;

public interface Mapper<E extends IdentifiableEntity, D extends AbstractDto> {

    E toEntity(D dto);

    D toDto(E entity);
}
