package org.example.lab7.mapper;

import org.example.lab7.dto.PhoneDTO;
import org.example.lab7.entity.Brand;
import org.example.lab7.entity.Category;
import org.example.lab7.entity.Phone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface PhoneMapper {

    @Mapping(target = "brandId", source = "brand.id")
    @Mapping(target = "categoryIds", source = "categories")
    PhoneDTO toDTO(Phone phone);



    @Mapping(target = "brand", source = "brandId")
    @Mapping(target = "categories", source = "categoryIds")
    Phone toEntity(PhoneDTO dto);


    default List<Long> map(List<Category> categories) {
        if (categories == null) return null;
        return categories.stream()
                .map(Category::getId)
                .collect(Collectors.toList());
    }


    default Brand map(Long id) {
        if (id == null) return null;
        Brand brand = new Brand();
        brand.setId(id);
        return brand;
    }


    default List<Category> mapIdsToCategories(List<Long> ids) {
        if (ids == null) return null;

        List<Category> list = new ArrayList<>();
        for (Long id : ids) {
            Category category = new Category();
            category.setId(id);
            list.add(category);
        }
        return list;
    }
}
