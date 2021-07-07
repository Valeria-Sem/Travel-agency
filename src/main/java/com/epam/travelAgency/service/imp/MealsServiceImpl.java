package com.epam.travelAgency.service.imp;

import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.dao.DAOProvider;
import com.epam.travelAgency.dao.MealsDAO;
import com.epam.travelAgency.entity.MealsEntity;
import com.epam.travelAgency.service.MealsService;
import com.epam.travelAgency.service.ServiceException;

import java.util.List;

public class MealsServiceImpl implements MealsService {
    @Override
    public List<MealsEntity> getAllMeals() throws ServiceException {
        List<MealsEntity> meals;

        DAOProvider provider = DAOProvider.getInstance();
        MealsDAO mealsDAO = provider.getMealsDAO();

        try{
            meals = mealsDAO.getAllMeals();
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return meals;
    }

    @Override
    public int getIdByName(String meals) throws ServiceException {
        int id;

        DAOProvider provider = DAOProvider.getInstance();
        MealsDAO mealsDAO = provider.getMealsDAO();

        try{
            id = mealsDAO.getIdByName(meals);
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return id;
    }

    @Override
    public MealsEntity getMealsById(int mealsId) throws ServiceException {
        MealsEntity meals;

        DAOProvider provider = DAOProvider.getInstance();
        MealsDAO mealsDAO = provider.getMealsDAO();

        try{
            meals = mealsDAO.getMealsById(mealsId);
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return meals;
    }
}
