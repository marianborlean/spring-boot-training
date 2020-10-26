package eu.accesa.springboottraining.service;

import eu.accesa.springboottraining.dao.InternRepositoryAuxiliar;
import eu.accesa.springboottraining.dto.InternDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static eu.accesa.springboottraining.dto.InternMapper.from;

import java.util.List;
@Service
public class InternServiceImpl implements InternService{

    @Autowired
    private InternRepositoryAuxiliar internRepositoryAuxiliar;

    @Override
    public List<InternDto> findAllInterns() {
        return from(internRepositoryAuxiliar.findAll());
    }

    @Override
    public InternDto findInternById(final Long id) {
        return from(internRepositoryAuxiliar.getOne(id));
    }
}
