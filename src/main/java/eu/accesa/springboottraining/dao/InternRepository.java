package eu.accesa.springboottraining.dao;

import eu.accesa.springboottraining.entity.Intern;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternRepository extends JpaRepository<Intern, Long> {
}
