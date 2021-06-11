package com.epam.travelAgency.dao;

import com.epam.travelAgency.entity.CategoryEntity;

import java.util.List;

public interface CategoryDAO {
    Iterable<CategoryEntity> getAllCategories() throws DAOException;
}
