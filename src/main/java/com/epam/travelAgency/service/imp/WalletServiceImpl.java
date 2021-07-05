package com.epam.travelAgency.service.imp;

import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.dao.DAOProvider;
import com.epam.travelAgency.dao.WalletDao;
import com.epam.travelAgency.entity.WalletEntity;
import com.epam.travelAgency.service.ServiceException;
import com.epam.travelAgency.service.WalletService;

import java.util.List;

public class WalletServiceImpl implements WalletService {
    @Override
    public List<WalletEntity> getAllWallets() throws ServiceException {
        List<WalletEntity> wallets;

        DAOProvider provider = DAOProvider.getInstance();
        WalletDao walletDao = provider.getWalletDAO();

        try{
            wallets = walletDao.getAllWallets();
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return wallets;
    }

    @Override
    public boolean addWallet(WalletEntity walletEntity) throws ServiceException {
        boolean isAdded = false;

        DAOProvider provider = DAOProvider.getInstance();
        WalletDao walletDao = provider.getWalletDAO();

        try{
            isAdded = walletDao.addWallet(walletEntity);
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return isAdded;
    }

    @Override
    public WalletEntity getWalletById(int id) throws ServiceException {
        WalletEntity wallet;

        DAOProvider provider = DAOProvider.getInstance();
        WalletDao walletDao = provider.getWalletDAO();

        try{
            wallet = walletDao.getWalletById(id);
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return wallet;
    }

    @Override
    public WalletEntity saveNewWallet(int userId) throws ServiceException {
        WalletEntity wallet;

        DAOProvider provider = DAOProvider.getInstance();
        WalletDao walletDao = provider.getWalletDAO();

        try{
            wallet = walletDao.saveNewWallet(userId);
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return wallet;
    }

    @Override
    public WalletEntity getWalletByUserId(int userId) throws ServiceException {
        WalletEntity wallet;

        DAOProvider provider = DAOProvider.getInstance();
        WalletDao walletDao = provider.getWalletDAO();

        try{
            wallet = walletDao.getWalletByUserId(userId);
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return wallet;
    }

    @Override
    public boolean updateBalance(int id, double newBalance) throws ServiceException {
        boolean isUpdated;

        DAOProvider provider = DAOProvider.getInstance();
        WalletDao walletDao = provider.getWalletDAO();

        try{
            isUpdated = walletDao.updateBalance(id, newBalance);
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return isUpdated;
    }

    @Override
    public boolean deleteWallet(int id) throws ServiceException {
        boolean isDeleted;

        DAOProvider provider = DAOProvider.getInstance();
        WalletDao walletDao = provider.getWalletDAO();


        try{
            isDeleted = walletDao.deleteWallet(id);
        } catch (DAOException e){
            throw new ServiceException(e);
        }

        return isDeleted;
    }
}
