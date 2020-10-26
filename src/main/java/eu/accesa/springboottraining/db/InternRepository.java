package eu.accesa.springboottraining.db;


import eu.accesa.springboottraining.entity.Intern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternRepository extends JpaRepository<Intern, Long> {
    Intern findByName(String name);
}