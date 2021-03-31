package io.jrovieri.petclinic.api.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.jrovieri.petclinic.api.dto.OwnerDTO;
import io.jrovieri.petclinic.api.dto.PetDTO;
import io.jrovieri.petclinic.api.dto.PostalAddressDTO;
import io.jrovieri.petclinic.api.model.Owner;
import io.jrovieri.petclinic.api.model.Pet;
import io.jrovieri.petclinic.api.model.PostalAddress;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class OwnerMapperTest {

  OwnerMapper mapper = OwnerMapper.INSTANCE;

  @Test
  void ownerToOwnerDto() throws Exception {
    Pet pet0 = Pet.builder().id(1L).build();
    Pet pet1 = Pet.builder().id(2L).build();
    Set<Pet> pets = new HashSet<>(Arrays.asList(pet0, pet1));

    PostalAddress postalAddress = PostalAddress.builder().id(1L).build();

    Owner model =
        Owner.builder()
            .id(1L)
            .address(postalAddress)
            .name("Jenny Myers")
            .email("jenny.myers@example.com")
            .telephone("+1 216-231-2280")
            .pets(pets)
            .build();

    OwnerDTO dto = mapper.ownerToOwnerDto(model);

    assertNotNull(model);
    assertNotNull(model.getAddress());
    assertNotNull(model.getPets());

    assertEquals(model.getId(), dto.getId());
    assertEquals(model.getName(), dto.getName());
    assertEquals(model.getEmail(), dto.getEmail());
    assertEquals(model.getTelephone(), dto.getTelephone());
  }

  @Test
  void ownerDtoToOwner() throws Exception {
    PetDTO pet0 = PetDTO.builder().id(1L).build();
    PetDTO pet1 = PetDTO.builder().id(2L).build();
    List<PetDTO> pets = Arrays.asList(pet0, pet1);

    PostalAddressDTO postalAddress = PostalAddressDTO.builder().id(1L).build();

    OwnerDTO dto =
        OwnerDTO.builder()
            .id(1L)
            .address(postalAddress)
            .name("Jenny Myers")
            .email("jenny.myers@example.com")
            .telephone("+1 216-231-2280")
            .pets(pets)
            .build();

    Owner model = mapper.ownerDtoToOwner(dto);

    assertNotNull(dto);
    assertNotNull(dto.getAddress());
    assertNotNull(dto.getPets());

    assertEquals(dto.getId(), model.getId());
    assertEquals(dto.getName(), model.getName());
    assertEquals(dto.getEmail(), model.getEmail());
    assertEquals(dto.getTelephone(), model.getTelephone());
  }
}
