package eu.accesa.springboottraining.dao;

import eu.accesa.springboottraining.entity.Intern;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InternRepository extends JpaRepository<Intern, Long> {

    Optional<Intern> findByName(String name);

}
