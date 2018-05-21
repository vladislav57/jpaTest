package ru.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class TestRestController {

    Entity entity = new Entity(1L, "testName");
    Entity entity2 = new Entity(2L, "testName2");

    @GetMapping
    public Entity entities() {
        /*List<Entity> list = new ArrayList<>();
        list.add(entity);
        list.add(entity2);*/
        return entity;
    }
}
