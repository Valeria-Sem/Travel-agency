package com.epam.travelAgency.dao.impl;

import com.epam.travelAgency.dao.DAOException;
import com.epam.travelAgency.dao.TransportDAO;
import com.epam.travelAgency.dao.pool.ConnectionPool;
import com.epam.travelAgency.dao.pool.ConnectionPoolException;
import com.epam.travelAgency.entity.SaleEntity;
import com.epam.travelAgency.entity.TransportEntity;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TransportDaoImpl implements TransportDAO {
    private final Logger LOGGER = Logger.getLogger(TransportDaoImpl.class);

    private final String GET_TRANSPORT_BY_ID_QUERY = "select * from transport where id = ?";

    private final String ID ="id";
    private final String NAME ="name";

    @Override
    public List<TransportEntity> getAllTransport() throws DAOException {
        return null;
    }

    @Override
    public TransportEntity getTransportById(int transportId) throws DAOException {
        TransportEntity transport = null;

        Connection connection = null;
        ConnectionPool pool = null;
        PreparedStatement ps = null;
        ResultSet res = null;

        try{
            pool = ConnectionPool.getInstance();
            connection = pool.takeConnection();
            ps = connection.prepareStatement(GET_TRANSPORT_BY_ID_QUERY);
            ps.setInt(1, transportId);

            res = ps.executeQuery();

            while (res.next()){
                int id  = res.getInt(ID);
                String name = res.getString(NAME);

                transport = new TransportEntity(id, name) ;

            }
        } catch (SQLException | ConnectionPoolException e) {
            LOGGER.error("TransportDaoImpl (getTransportById) -> some problems with extracting transport");

        } finally {
            if(connection != null){
                pool.closeConnection(connection, ps, res);
            }
        }

        return transport;
    }

    @Override
    public int getIdByName(String transport) throws DAOException {
        return 0;
    }
}
