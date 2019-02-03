package jaep.springframework.recipeapp.services;

import jaep.springframework.recipeapp.domain.Recipe;
import jaep.springframework.recipeapp.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {
    RecipeService recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getAllRecipes() {
        Recipe recipe = new Recipe();
        HashSet<Recipe>  recipesData = new HashSet<>();
        recipesData.add(recipe);

        when(recipeService.getAllRecipes()).thenReturn(recipesData);

        Set<Recipe> recipes = recipeService.getAllRecipes();
        assertEquals(recipes.size(),1);
        verify(recipeRepository, times(1)).findAll();
    }
}