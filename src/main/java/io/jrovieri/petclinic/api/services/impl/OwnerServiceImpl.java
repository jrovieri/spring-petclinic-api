package io.jrovieri.petclinic.api.services.impl;

import io.jrovieri.petclinic.api.dto.OwnerDTO;
import io.jrovieri.petclinic.api.mapper.OwnerMapper;
import io.jrovieri.petclinic.api.model.Owner;
import io.jrovieri.petclinic.api.repository.OwnerRepository;
import io.jrovieri.petclinic.api.services.OwnerService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

/**
 * The Owner Service interface implementation
 *
 * @author jrovieri
 */
@Service
public class OwnerServiceImpl implements OwnerService {

  private OwnerMapper ownerMapper;

  private OwnerRepository ownerRepository;

  public OwnerServiceImpl(OwnerMapper ownerMapper, OwnerRepository ownerRepository) {
    this.ownerMapper = ownerMapper;
    this.ownerRepository = ownerRepository;
  }

  @Override
  public List<OwnerDTO> findAll() {
    return ownerRepository.findAll().stream()
        .map(ownerMapper::ownerToOwnerDto)
        .collect(Collectors.toList());
  }

  @Override
  public OwnerDTO findById(Long id) {
    return ownerRepository
        .findById(id)
        .map(ownerMapper::ownerToOwnerDto)
        .orElseThrow(ResourceNotFoundException::new);
  }

  @Override
  public OwnerDTO save(OwnerDTO object) {
    Owner owner = ownerMapper.ownerDtoToOwner(object);
    Owner savedOwner = ownerRepository.save(owner);

    return ownerMapper.ownerToOwnerDto(savedOwner);
  }

  @Override
  public OwnerDTO update(Long id, OwnerDTO object) {
    if (!ownerRepository.existsById(id)) throw new ResourceNotFoundException();

    Owner owner = ownerMapper.ownerDtoToOwner(object);
    Owner savedOwner = ownerRepository.save(owner);

    return ownerMapper.ownerToOwnerDto(savedOwner);
  }

  @Override
  public void deleteById(Long id) {
    if (!ownerRepository.existsById(id)) throw new ResourceNotFoundException();
    ownerRepository.deleteById(id);
  }

  @Override
  public List<OwnerDTO> findByNameContaining(String name) {
    return ownerRepository.findByNameContaining(name).stream()
        .map(ownerMapper::ownerToOwnerDto)
        .collect(Collectors.toList());
  }
}
