package com.sheriftarek.spring5recipeapp.repositories;

import com.sheriftarek.spring5recipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
