package com.sheriftarek.spring5recipeapp.services;

import com.sheriftarek.spring5recipeapp.domain.Recipe;
import org.springframework.stereotype.Component;

import java.util.Set;

public interface RecipeService {
    public Set<Recipe> getRecipes();
}
