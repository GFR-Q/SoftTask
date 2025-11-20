package org.example.lab7.mapper;

import org.example.lab7.dto.CategoryDTO;
import org.example.lab7.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDTO toDTO(Category category);

    @Mapping(target = "phones", ignore = true)
    Category toEntity(CategoryDTO dto);
}
