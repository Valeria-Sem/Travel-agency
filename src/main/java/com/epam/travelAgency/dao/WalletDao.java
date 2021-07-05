package com.epam.travelAgency.dao;

import com.epam.travelAgency.entity.WalletEntity;

import java.util.List;

public interface WalletDao {
    List<WalletEntity> getAllWallets() throws DAOException;
    boolean addWallet(WalletEntity wallet) throws DAOException;
    WalletEntity saveNewWallet(int userId) throws DAOException;
    WalletEntity getWalletById(int id) throws DAOException;
    WalletEntity getWalletByUserId(int userId) throws DAOException;
    boolean updateBalance(int id, double newBalance) throws DAOException;
    boolean deleteWallet(int id) throws DAOException;
}
