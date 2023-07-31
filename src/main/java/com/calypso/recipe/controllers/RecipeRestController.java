package com.calypso.recipe.controllers;

import com.calypso.recipe.models.Recipe;
import com.calypso.recipe.repositories.RecipeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/recipes")
public class RecipeRestController {

    @Autowired
    private RecipeJpaRepository jpaRepository;

    @GetMapping("")
    public List<Recipe> listRecipes() {
        return jpaRepository.findAll();
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello, World!";
    }

    @GetMapping("/{id}")
    public Recipe getRecipe(@PathVariable Long id) {
        return jpaRepository.getById(id);
    }

    @PostMapping("")
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        return jpaRepository.save(recipe);
    }

    @PutMapping("/{id}")
    public Recipe updateRecipe(@RequestBody Recipe recipe, @PathVariable Long id) {
        Recipe r = jpaRepository.getById(id);
        r.setName(recipe.getName());
        r.setDescription(recipe.getDescription());
        return jpaRepository.save(r);
    }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable Long id) {
        jpaRepository.deleteById(id);
    }
}
