package io.jrovieri.petclinic.api.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.jrovieri.petclinic.api.dto.OwnerDTO;
import io.jrovieri.petclinic.api.mapper.OwnerMapper;
import io.jrovieri.petclinic.api.model.Owner;
import io.jrovieri.petclinic.api.repository.OwnerRepository;
import io.jrovieri.petclinic.api.services.impl.OwnerServiceImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

@ExtendWith(MockitoExtension.class)
public class OwnerServiceImplTest {

  @Mock OwnerRepository ownerRepository;

  @Autowired OwnerMapper ownerMapper = OwnerMapper.INSTANCE;

  @InjectMocks OwnerService ownerService = new OwnerServiceImpl(ownerMapper, ownerRepository);

  Owner owner;

  @BeforeEach
  public void setUp() throws Exception {
    owner = Owner.builder().id(1L).name("John Myers").build();
  }

  @Test
  void whenFindAll_thenReturnObject() throws Exception {
    Owner owner0 = Owner.builder().id(2L).name("Mike Myers").build();

    when(ownerRepository.findAll()).thenReturn(List.of(owner, owner0));

    List<OwnerDTO> mappedOwners = ownerService.findAll();

    assertNotNull(mappedOwners);
    assertEquals(2, mappedOwners.size());
  }

  @Test
  void whenFindAll_thenReturnEmpty() throws Exception {
    when(ownerRepository.findAll()).thenReturn(new ArrayList<>());

    List<Owner> mappedOwners =
        ownerService.findAll().stream()
            .map(ownerMapper::ownerDtoToOwner)
            .collect(Collectors.toList());

    assertNotNull(mappedOwners);
    assertEquals(0, mappedOwners.size());
  }

  @Test
  void givenId_whenFindById_thenReturnObject() throws Exception {
    when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner));
    Owner mappedOwner = ownerMapper.ownerDtoToOwner(ownerService.findById(1L));
    assertNotNull(mappedOwner);
  }

  @Test
  void givenId_whenFindById_thenThrowsException() throws Exception {
    when(ownerRepository.findById(anyLong())).thenThrow(new ResourceNotFoundException());

    assertThrows(ResourceNotFoundException.class, () -> ownerService.findById(10L));
  }

  @Test
  void whenSave_thenReturnObject() throws Exception {
    when(ownerRepository.save(any(Owner.class))).thenReturn(owner);

    OwnerDTO savedOwner = ownerMapper.ownerToOwnerDto(ownerRepository.save(owner));
    assertNotNull(savedOwner);
  }

  @Test
  void givenIdAndObject_whenUpdate_thenReturnObject() throws Exception {
    when(ownerRepository.save(any(Owner.class))).thenReturn(owner);

    OwnerDTO updatedOwner = ownerService.update(anyLong(), ownerMapper.ownerToOwnerDto(owner));
    assertNotNull(updatedOwner);
  }

  @Test
  void givenIdAndObject_whenUpdate_thenThrowsException() throws Exception {
    when(ownerRepository.save(any(Owner.class))).thenThrow(new ResourceNotFoundException());

    assertThrows(
        ResourceNotFoundException.class,
        () -> ownerService.update(anyLong(), ownerMapper.ownerToOwnerDto(owner)));
  }

  @Test
  void givenId_whenDelete_thenNoReturn() throws Exception {
    ownerService.deleteById(1L);
    verify(ownerService, times(1)).deleteById(anyLong());
  }

  @Test
  void givenId_whenDelete_thenThrowsException() throws Exception {
    doThrow(ResourceNotFoundException.class).when(ownerRepository).deleteById(anyLong());
    assertThrows(ResourceNotFoundException.class, () -> ownerService.deleteById(anyLong()));
  }

  @Test
  void givenName_whenFindByNameContaining_thenReturnList() throws Exception {
    Owner owner0 = Owner.builder().id(2L).name("Mike Myers").build();

    when(ownerRepository.findByNameContaining(anyString()))
        .thenReturn(Arrays.asList(owner, owner0));

    List<OwnerDTO> mappedOwners = ownerService.findByNameContaining(anyString());

    assertNotNull(mappedOwners);
    assertEquals(2, mappedOwners.size());
  }

  @Test
  void givenName_whenFindByNameContaining_thenReturnEmptyList() throws Exception {
    when(ownerRepository.findByNameContaining(anyString())).thenReturn(new ArrayList<>());

    List<OwnerDTO> mappedOwners = ownerService.findByNameContaining(anyString());

    assertNotNull(mappedOwners);
    assertEquals(0, mappedOwners.size());
  }
}
