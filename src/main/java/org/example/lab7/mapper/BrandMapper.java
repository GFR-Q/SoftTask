package org.example.lab7.mapper;

import org.example.lab7.dto.BrandDTO;
import org.example.lab7.entity.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BrandMapper {

    BrandDTO toDTO(Brand brand);

    @Mapping(target = "phones", ignore = true)
    Brand toEntity(BrandDTO dto);
}
