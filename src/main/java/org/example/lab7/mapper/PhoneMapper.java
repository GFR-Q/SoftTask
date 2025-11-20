package org.example.lab7.mapper;

import org.example.lab7.dto.PhoneDTO;
import org.example.lab7.entity.Category;
import org.example.lab7.entity.Phone;
import org.mapstruct.*;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface PhoneMapper {

    @Mapping(target = "brandId", source = "brand.id")
    @Mapping(target = "categoryIds", source = "categories", qualifiedByName = "categoriesToIds")
    PhoneDTO toDTO(Phone phone);

    @Mapping(target = "brand", ignore = true)
    @Mapping(target = "categories", ignore = true)
    Phone toEntity(PhoneDTO dto);

    @Named("categoriesToIds")
    static List<Long> categoriesToIds(List<Category> categories) {
        if (categories == null) return null;
        return categories.stream()
                .map(Category::getId)
                .collect(Collectors.toList());
    }
}
