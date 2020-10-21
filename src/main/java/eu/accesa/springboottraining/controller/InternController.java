package eu.accesa.springboottraining.controller;

import eu.accesa.springboottraining.dto.InternDto;
import eu.accesa.springboottraining.service.InternService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/interns")
@OpenAPIDefinition
@Tag(name = "Interns")
public class InternController {

    @Autowired
    private InternService internService;

    @GetMapping()
    public List<InternDto> getInterns() {
        return internService.findAllInterns();
    }

    @GetMapping("/{id}")
    public InternDto getInternById(final @PathVariable Long id) {
        return internService.findInternById(id);
    }
}
