package eu.accesa.springboottraining.dao;

import eu.accesa.springboottraining.entity.Intern;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternRepositoryAuxiliar extends JpaRepository<Intern, Long> {
}
