package com.erp.maisPraTi.utils;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class EntityMapper {

    @Autowired
    private static ModelMapper modelMapper = new ModelMapper();

    public static <D, E> E convertToEntity(D dto, Class<E> entityClass) {
        return modelMapper.map(dto, entityClass);
    }

    public static <D, E> void convertToEntity(D dto, E entityClass) {
        modelMapper.map(dto, entityClass);
    }

    public static <D, E> D convertToDto(E entity, Class<D> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

}
