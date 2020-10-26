package eu.accesa.springboottraining.dao;

import eu.accesa.springboottraining.entity.Intern;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;

@Repository
public class InternRepositoryImpl implements InternRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    private static final String FIND_BY_ID_JPQL = "SELECT i FROM Intern i WHERE i.id= :id";
    private static final String FIND_BY_ID_SQL = "SELECT * FROM INTERNS where id= :id";

    @Override
    public Intern findByIdJpql(final Long id) {
        final var query = entityManager.createQuery(FIND_BY_ID_JPQL, Intern.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Intern findByIdNative(final Long id) {
        final var query = entityManager.createNativeQuery(FIND_BY_ID_SQL, Intern.class);
        query.setParameter("id", id);
        return (Intern) query.getSingleResult();
    }

    @Override
    public Intern findByIdNativeNoEntity(Long id) {
        final var query = entityManager.createNativeQuery(FIND_BY_ID_SQL);
        query.setParameter("id", id);
        final var result = (Object[]) query.getSingleResult();
        return transformResult(result);
    }

    private Intern transformResult(final Object[] result) {
        var intern = new Intern();
        intern.setId(((Integer) result[0]).longValue());
        intern.setName((String) result[1]);
        intern.setEmail((String) result[2]);
        intern.setBirthDate(((Timestamp) result[3]).toLocalDateTime().toLocalDate());
        return intern;
    }
}
