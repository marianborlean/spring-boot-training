package eu.accesa.springboottraining.service;

import eu.accesa.springboottraining.dto.InternDto;

import java.util.List;
import java.util.Optional;

public interface InternService {

    InternDto save(InternDto internDto);

    List<InternDto> findAll();

    Optional<InternDto> findById(Long id);

    Optional<InternDto> findByName(String name);

    void deleteById(Long id);

}
