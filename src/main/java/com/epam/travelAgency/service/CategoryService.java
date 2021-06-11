package com.epam.travelAgency.service;

import com.epam.travelAgency.entity.CategoryEntity;

import java.util.List;

public interface CategoryService {
    Iterable<CategoryEntity> getAllCategories() throws ServiceException;

}
