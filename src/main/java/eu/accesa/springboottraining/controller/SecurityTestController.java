package eu.accesa.springboottraining.controller;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.h2.util.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
@RequestMapping("/secure-url")
@OpenAPIDefinition
@Tag(name = "SecurityTestController")
public class SecurityTestController {


    @GetMapping()
    private String TestAuthorization(HttpServletRequest request){
        return "";
    }
}
