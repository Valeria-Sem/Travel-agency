package com.epam.travelAgency.service.imp;

import com.epam.travelAgency.dao.CategoryDAO;
import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.dao.DAOProvider;
import com.epam.travelAgency.entity.CategoryEntity;
import com.epam.travelAgency.service.CategoryService;
import com.epam.travelAgency.service.ServiceException;

public class CategoryServiceImpl implements CategoryService {

    @Override
    public Iterable<CategoryEntity> getAllCategories() throws ServiceException {
        Iterable<CategoryEntity> categories;

        DAOProvider provider = DAOProvider.getInstance();
        CategoryDAO categoryDAO = provider.getCategoryDAO();

        try{
            categories = categoryDAO.getAllCategories();
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return categories;
    }
}
