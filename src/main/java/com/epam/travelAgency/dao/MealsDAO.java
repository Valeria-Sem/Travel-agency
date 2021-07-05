package com.epam.travelAgency.dao;

import com.epam.travelAgency.entity.MealsEntity;

import java.util.List;

public interface MealsDAO {
    List<MealsEntity> getAllMeals() throws DAOException;
    int getIdByName(String meals) throws DAOException;
}
