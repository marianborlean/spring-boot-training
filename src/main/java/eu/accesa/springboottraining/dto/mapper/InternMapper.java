package eu.accesa.springboottraining.dto.mapper;

import eu.accesa.springboottraining.dto.InternDto;
import eu.accesa.springboottraining.entity.Intern;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

public class InternMapper {

    private InternMapper() {

    }

    public static List<InternDto> from(final List<Intern> interns) {
        if (CollectionUtils.isEmpty(interns))
            return emptyList();

        return interns
                .stream()
                .map(InternMapper::from)
                .collect(Collectors.toList());
    }

    public static InternDto from(final Intern intern) {
        if (intern == null)
            return null;

        final var internDto = new InternDto();
        internDto.setId(intern.getId());
        internDto.setName(intern.getName());
        internDto.setBirthDate(intern.getBirthDate());
        internDto.setEmail(intern.getEmail());
        return internDto;
    }

    public static Intern from(final InternDto internDto) {
        if (internDto == null)
            return null;

        final var intern = new Intern();
        intern.setId(internDto.getId());
        intern.setName(internDto.getName());
        intern.setBirthDate(internDto.getBirthDate());
        intern.setEmail(internDto.getEmail());
        return intern;
    }

}
