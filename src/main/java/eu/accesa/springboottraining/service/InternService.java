package eu.accesa.springboottraining.service;

import eu.accesa.springboottraining.dto.InternDto;

import java.util.List;

public interface InternService {

    List<InternDto> findAllInterns();

    InternDto findInternById(Long id);
}
