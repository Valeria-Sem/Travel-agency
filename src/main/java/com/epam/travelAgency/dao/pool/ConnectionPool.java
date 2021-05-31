package com.epam.travelAgency.dao.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ConnectionPool {
    private String databaseUrl;
    private String userName;
    private String password;

    private int maxPoolSize = 10;
    private int connNumb = 0;

    private static final String SQL_VERIFYCONN = "select 1";

    Stack<Connection> freePool = new Stack<>();
    Set<Connection> occupiedPool = new HashSet<>();

    public ConnectionPool(String databaseUrl, String userName, String password, int maxPoolSize) {
        this.databaseUrl = databaseUrl;
        this.userName = userName;
        this.password = password;
        this.maxPoolSize = maxPoolSize;
    }

    public synchronized Connection getConnection() throws SQLException{
        Connection conn = null;

        if(isFull()){
            throw new SQLException("The connection pool is full.");
        }
        conn = getConnectionFromPool();

        if(conn == null){
            conn = createNewConnectionForPool();
        }
        conn = makeAvailable(conn);

        return conn;
    }

    public synchronized void returnConnection(Connection conn) throws SQLException{         //закрытие конекшена
        if(conn == null){
            throw new NullPointerException();   //todo сделать красиво
        }

        if(!occupiedPool.remove(conn)){     //удаляем активный конекшен
            throw new SQLException("The connection is returned already or it isn't for this pool");
        }

        freePool.push(conn);        //и запускаем в свободные конекшены
    }

    private synchronized boolean isFull(){
        return ((freePool.size() == 0) && (connNumb >= maxPoolSize));
    }

    private Connection createNewConnectionForPool() throws SQLException{
        Connection conn = createNewConnection();
        connNumb++;
        occupiedPool.add(conn);

        return conn;
    }

    private Connection createNewConnection() throws SQLException{
        Connection conn = null;
        conn = DriverManager.getConnection(databaseUrl, userName, password);

        return conn;
    }

    private Connection getConnectionFromPool(){
        Connection conn = null;

        if (freePool.size() > 0){
            conn = freePool.pop();
            occupiedPool.add(conn);
        }

        return conn;
    }

    private Connection makeAvailable(Connection conn) throws SQLException{      //создание рабочего(активного) конекшена
        if(isConnectionAvalible(conn)){
            return (conn);
        }

        occupiedPool.remove(conn);              //если конекшен не рабочий, мы его удаляем
        connNumb--;
        conn.close();

        conn = createNewConnection();           //при этом, чтобы не потерять ?этот коннекшен, мы создаём новый и его возвращаем
        occupiedPool.add(conn);
        connNumb++;

        return conn;
    }

    private boolean isConnectionAvalible(Connection conn){          //проверка на рабочий коннекшн
        try(Statement st = conn.createStatement()){
            st.executeQuery(SQL_VERIFYCONN);

            return true;
        } catch (SQLException e){
            return false;
        }
    }
}
