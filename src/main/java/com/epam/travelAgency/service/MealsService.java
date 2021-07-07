package com.epam.travelAgency.service;

import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.entity.MealsEntity;

import java.util.List;

public interface MealsService {
    List<MealsEntity> getAllMeals() throws ServiceException;
    int getIdByName(String meals) throws ServiceException;
    MealsEntity getMealsById(int mealsId) throws ServiceException;

}
