package dev.vaibhav.springrest.contoller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/get-product/{id}")
    public String greet(@PathVariable String id) {
        String uri = "https://fakestoreapi.com/products/" + id;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, String.class);
    }
}
