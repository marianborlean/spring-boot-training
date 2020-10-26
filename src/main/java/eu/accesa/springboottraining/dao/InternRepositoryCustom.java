package eu.accesa.springboottraining.dao;

import eu.accesa.springboottraining.entity.Intern;

public interface InternRepositoryCustom {

    Intern findByIdJpql(final Long id);

    Intern findByIdNative(final Long id);

    Intern findByIdNativeNoEntity(final Long id);
}
