package eu.accesa.springboottraining.entity;


import javax.persistence.*;

import java.util.Objects;
import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "HOBBIES")
public class Hobby {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=SEQUENCE, generator="hobbies_sequence_generator")
    @SequenceGenerator(name = "hobbies_sequence_generator", sequenceName = "HOBBIES_SEQUENCE", allocationSize = 1)
    private Long id;
    @Column(name = "NAME")
    private String name;
    @ManyToMany(mappedBy = "hobbies")
    private Set<Intern> interns;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Intern> getInterns() {
        return interns;
    }

    public void setInterns(Set<Intern> interns) {
        this.interns = interns;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hobby hobby = (Hobby) o;
        return Objects.equals(id, hobby.id) &&
                Objects.equals(name, hobby.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
