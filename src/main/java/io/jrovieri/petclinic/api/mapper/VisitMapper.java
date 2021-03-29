package io.jrovieri.petclinic.api.mapper;

import io.jrovieri.petclinic.api.dto.VisitDTO;
import io.jrovieri.petclinic.api.model.Visit;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * The Visit Mapper
 *
 * @author jrovieri
 */
@Mapper
public interface VisitMapper {

  VisitMapper INSTANCE = Mappers.getMapper(VisitMapper.class);

  VisitDTO visitToVisitDto(Visit visit);

  Visit visitDtoToVisit(VisitDTO visitDTO);
}
