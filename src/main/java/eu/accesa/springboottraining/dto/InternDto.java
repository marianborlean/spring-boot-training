package eu.accesa.springboottraining.dto;

import java.time.LocalDate;

public class InternDto {

    private Long id;
    private String name;
    private String email;
    private String password;
    private LocalDate birthDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }
}
