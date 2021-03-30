package io.jrovieri.petclinic.api.services;

import java.util.List;

/**
 * The CrudService interface which all service interfaces will inherit.
 *
 * @author jrovieri
 */
public interface CrudService<T, ID> {

  List<T> findAll();

  T findById(ID id);

  T save(T object);

  void delete(T object);

  void deleteById(ID id);
}
