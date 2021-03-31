package io.jrovieri.petclinic.api.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.jrovieri.petclinic.api.dto.PostalAddressDTO;
import io.jrovieri.petclinic.api.dto.SpecialtyDTO;
import io.jrovieri.petclinic.api.dto.VetDTO;
import io.jrovieri.petclinic.api.model.PostalAddress;
import io.jrovieri.petclinic.api.model.Specialty;
import io.jrovieri.petclinic.api.model.Vet;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class VetMapperTest {

  VetMapper mapper = VetMapper.INSTANCE;

  @Test
  void vetToVetDto() throws Exception {
    PostalAddress address = PostalAddress.builder().id(1L).build();

    Specialty s0 = Specialty.builder().id(1L).build();
    Specialty s1 = Specialty.builder().id(2L).build();
    Set<Specialty> specialties = new HashSet<>(Arrays.asList(s0, s1));

    Vet model =
        Vet.builder()
            .id(1L)
            .name("Warren Jones")
            .email("warren.jones@example.com")
            .address(address)
            .specialties(specialties)
            .telephone("+1 216-231-2280")
            .build();

    VetDTO dto = mapper.vetToVetDto(model);

    assertNotNull(dto);
    assertNotNull(dto.getAddress());
    assertNotNull(dto.getSpecialties());

    assertEquals(model.getId(), dto.getId());
    assertEquals(model.getName(), dto.getName());
    assertEquals(model.getEmail(), dto.getEmail());
    assertEquals(model.getTelephone(), dto.getTelephone());
  }

  @Test
  void vetDtoToVet() throws Exception {
    PostalAddressDTO address = PostalAddressDTO.builder().id(1L).build();

    SpecialtyDTO s0 = SpecialtyDTO.builder().id(1L).build();
    SpecialtyDTO s1 = SpecialtyDTO.builder().id(2L).build();
    List<SpecialtyDTO> specialties = Arrays.asList(s0, s1);

    VetDTO dto =
        VetDTO.builder()
            .id(1L)
            .name("Warren Jones")
            .email("warren.jones@example.com")
            .address(address)
            .specialties(specialties)
            .telephone("+1 216-231-2280")
            .build();

    Vet model = mapper.vetDtoToVet(dto);

    assertNotNull(model);
    assertNotNull(model.getAddress());
    assertNotNull(model.getSpecialties());

    assertEquals(dto.getId(), model.getId());
    assertEquals(dto.getName(), model.getName());
    assertEquals(dto.getEmail(), model.getEmail());
    assertEquals(dto.getTelephone(), model.getTelephone());
  }
}
