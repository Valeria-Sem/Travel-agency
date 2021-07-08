package com.epam.travelAgency.service;

import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.entity.WalletEntity;

import java.util.List;

public interface WalletService {

    List<WalletEntity> getAllWallets() throws ServiceException;
    WalletEntity getWalletById(int id) throws ServiceException;
    WalletEntity saveNewWallet(int userId) throws ServiceException;
    WalletEntity getWalletByUserId(int userId) throws ServiceException;
    boolean updateBalance(int id, double newBalance) throws ServiceException;
    boolean deleteWallet(int id) throws ServiceException;
}
