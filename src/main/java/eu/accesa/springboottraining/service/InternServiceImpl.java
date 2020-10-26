package eu.accesa.springboottraining.service;

import eu.accesa.springboottraining.dao.InternRepository;
import eu.accesa.springboottraining.dto.InternDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static eu.accesa.springboottraining.dto.InternMapper.from;

import java.util.List;
@Service
public class InternServiceImpl implements InternService{

    @Autowired
    private InternRepository internRepository;


    @Override
    public List<InternDto> findAllInterns() {
        return from(internRepository.findAll());
    }

    @Override
    public InternDto findInternById(final Long id) {
        final var intern = internRepository.findByIdNativeNoEntity(id);
        return from(intern);
    }
}
