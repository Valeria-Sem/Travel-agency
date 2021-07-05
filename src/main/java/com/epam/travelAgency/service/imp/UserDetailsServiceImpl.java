package com.epam.travelAgency.service.imp;

import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.dao.DAOProvider;
import com.epam.travelAgency.dao.UserDetailsDAO;
import com.epam.travelAgency.entity.UserDetailsEntity;
import com.epam.travelAgency.service.ServiceException;
import com.epam.travelAgency.service.UserDetailsService;
import com.epam.travelAgency.service.validation.ValidationService;

import java.util.List;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public List<UserDetailsEntity> getAllUsersDetails() throws ServiceException {
        List<UserDetailsEntity> details;

        DAOProvider provider = DAOProvider.getInstance();
        UserDetailsDAO userDetailsDAO = provider.getUserDetailsDAO();

        try{
            details = userDetailsDAO.getAllUserDetails();
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return details;
    }

    @Override
    public boolean addUserDetails(UserDetailsEntity userDetailsEntity) throws ServiceException {
        boolean isAdded = false;

        DAOProvider provider = DAOProvider.getInstance();
        UserDetailsDAO userDetailsDAO = provider.getUserDetailsDAO();

        try{
            isAdded = userDetailsDAO.addUserDetails(userDetailsEntity);
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return isAdded;
    }

    @Override
    public UserDetailsEntity getUserDetailsByIdUser(int id) throws ServiceException {
        UserDetailsEntity userDetails;

        DAOProvider provider = DAOProvider.getInstance();
        UserDetailsDAO userDetailsDAO = provider.getUserDetailsDAO();

        try{
            userDetails = userDetailsDAO.getUserDetailsByUserId(id);
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return userDetails;
    }

    @Override
    public boolean deleteUserDetails(int id) throws ServiceException {
        boolean isDeleted = false;

        DAOProvider provider = DAOProvider.getInstance();
        UserDetailsDAO userDetailsDAO = provider.getUserDetailsDAO();

        try{
            isDeleted = userDetailsDAO.deleteUserDetails(id);
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return isDeleted;
    }

    @Override
    public boolean isUserDetailsUpdate(UserDetailsEntity userDet) throws ServiceException {
        boolean isUpdated = false;

        DAOProvider provider = DAOProvider.getInstance();
        UserDetailsDAO userDetailsDAO = provider.getUserDetailsDAO();

        try{

            isUpdated = userDetailsDAO.isUserDetailsUpdate(userDet);
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return isUpdated;
    }
}
