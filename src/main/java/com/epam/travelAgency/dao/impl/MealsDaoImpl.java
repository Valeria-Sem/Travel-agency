package com.epam.travelAgency.dao.impl;

import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.dao.MealsDAO;
import com.epam.travelAgency.entity.MealsEntity;

import java.util.List;

public class MealsDaoImpl implements MealsDAO {
    @Override
    public List<MealsEntity> getAllMeals() throws DAOException {
        return null;
    }

    @Override
    public int getIdByName(String meals) throws DAOException {
        return 0;
    }
}
