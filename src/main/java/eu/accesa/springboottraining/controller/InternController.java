package eu.accesa.springboottraining.controller;

import eu.accesa.springboottraining.dto.InternDto;
import eu.accesa.springboottraining.service.InternService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/interns")
@OpenAPIDefinition
@Tag(name = "Interns")
public class InternController {

    private final InternService internService;

    public InternController(InternService internService) {
        this.internService = internService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InternDto save(@RequestBody InternDto internDto) {
        return internService.save(internDto);
    }

    @GetMapping
    public List<InternDto> findInterns() {
        return internService.findAll();
    }

    @GetMapping("/{id}")
    public InternDto findById(@PathVariable Long id) {
        Optional<InternDto> internDto = internService.findById(id);
        return internDto.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/by")
    public InternDto findByName(@RequestParam(value = "name") String name) {
        Optional<InternDto> internDto = internService.findByName(name);
        return internDto.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping
    public InternDto update(@RequestBody InternDto internDto) {
        return internService.save(internDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        internService.deleteById(id);
    }

}
