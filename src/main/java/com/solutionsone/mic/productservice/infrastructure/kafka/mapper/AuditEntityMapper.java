package com.solutionsone.mic.productservice.infrastructure.kafka.mapper;

import com.solutionsone.mic.productservice.domain.audit.entity.Audit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuditEntityMapper {

   Audit toEntity(Audit entity);

}
