package com.sheriftarek.spring5recipeapp.controllers;

import com.sheriftarek.spring5recipeapp.domain.Recipe;
import com.sheriftarek.spring5recipeapp.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IndexControllerTest {

    IndexController indexController;

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(recipeService);
    }

    @Test
    void getIndexPage() {
        HashSet<Recipe> expectedRecipes = new HashSet<>();
        expectedRecipes.add(new Recipe());
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        expectedRecipes.add(recipe);

        when(recipeService.getRecipes()).thenReturn(expectedRecipes);
        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        assertEquals("index", indexController.getIndexPage(model));
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
        Set<Recipe> actualRecipes = argumentCaptor.getValue();
        assertEquals(expectedRecipes.size(), actualRecipes.size());
        assertEquals(expectedRecipes, actualRecipes);
    }
}