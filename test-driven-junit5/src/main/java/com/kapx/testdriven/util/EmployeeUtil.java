package com.kapx.testdriven.util;

import com.kapx.testdriven.dto.EmployeeDto;
import com.kapx.testdriven.dto.EmployeeDtoBuilder;
import com.kapx.testdriven.entity.EmployeeEntity;
import com.kapx.testdriven.entity.EmployeeEntityBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class EmployeeUtil {
    public static List<EmployeeEntity> toEmployeeEntities(final List<EmployeeDto> dtos) {
        final List<EmployeeEntity> entities = new ArrayList<>();
        dtos.forEach(dto -> entities.add(dtoToEntityCopyFunction.apply(dto)));
        return entities;
    }

    public static List<EmployeeDto> toEmployeeDtos(final List<EmployeeEntity> entities) {
        final List<EmployeeDto> dtos = new ArrayList<>();
        entities.forEach(entity -> dtos.add(entityToDtoCopyFunction.apply(entity)));
        return dtos;
    }

    public static EmployeeEntity toEmployeeEntity(final EmployeeDto dto) {
        return EmployeeEntityBuilder.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .dept(dto.getDept())
                .build();
    }

    public static EmployeeDto toEmployeeDto(final EmployeeEntity entity) {
        return EmployeeDtoBuilder.builder()
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .dept(entity.getDept())
                .build();
    }

    private static Function<EmployeeEntity, EmployeeDto> entityToDtoCopyFunction = (final EmployeeEntity entity) -> toEmployeeDto(entity);

    private static Function<EmployeeDto, EmployeeEntity> dtoToEntityCopyFunction = (final EmployeeDto dto) -> toEmployeeEntity(dto);
}
