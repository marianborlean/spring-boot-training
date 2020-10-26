package eu.accesa.springboottraining.dto;

import eu.accesa.springboottraining.entity.Intern;

import java.util.List;
import java.util.stream.Collectors;

public class InternMapper {

    private InternMapper() {

    }

    public static List<InternDto> from(final List<Intern> interns) {
     return interns.stream().map(InternMapper::from).collect(Collectors.toList());
    }

    public static InternDto from(final Intern intern) {
        final var internDto = new InternDto();
        internDto.setId(intern.getId());
        internDto.setName(intern.getName());
        internDto.setBirthDate(intern.getBirthDate());
        internDto.setPassword(intern.getPassword());
        internDto.setEmail(intern.getEmail());
        return internDto;
    }
}
