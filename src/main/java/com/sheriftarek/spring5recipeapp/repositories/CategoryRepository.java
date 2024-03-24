package com.sheriftarek.spring5recipeapp.repositories;

import com.sheriftarek.spring5recipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
