package com.epam.travelAgency.dao.pool;

import javax.sql.PooledConnection;
import java.sql.*;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;

public final class ConnectionPool {
    //    private BlockingQueue<Connection> connectionQueue;
//    private BlockingQueue<Connection> givenAwayConQueue;
//
//    private String driverName;
//    private String url;
//    private String user;
//    private String password;
//    private int poolSize;
//
//    public ConnectionPool() {
//        DBResourceManager dbResourseManager = DBResourceManager.getInstance();
//        this.driverName = dbResourseManager.getValue(DBParameter.DB_DRIVER);
//        this.url = dbResourseManager.getValue(DBParameter.DB_URL);
//        this.user = dbResourseManager.getValue(DBParameter.DB_USER);
//        ;
//        this.password = dbResourseManager.getValue(DBParameter.DB_PASSWORD);
//
//        try {
//            this.poolSize = Integer.parseInt(dbResourseManager
//                    .getValue(DBParameter.DB_POOL_SIZE));
//        } catch (NumberFormatException e) {
//            poolSize = 5;
//        }
//    }
//
//    public void initPoolData() throws ConnectionPoolException {
//        //Locale.setDefault(Locale.ENGLISH);
//
//        try {
//            Class.forName(driverName);
//            givenAwayConQueue = new ArrayBlockingQueue<Connection>(poolSize);
//            connectionQueue = new ArrayBlockingQueue<Connection>(poolSize);
//            for (int i = 0; i < poolSize; i++) {
//                Connection connection = DriverManager.getConnection(url, user,
//                        password);
//                PooledConnection pooledConnection = new PooledConnection(connection);
//                connectionQueue.add(pooledConnection);
//            }
//        } catch (SQLException e) {
//            throw new ConnectionPoolException("SQLException in ConnectionPool",
//                    e);
//
//        } catch (ClassNotFoundException e) {
//            throw new ConnectionPoolException(
//                    "Can't find database driver class", e);
//        }
//
//    }
//
//    public void dispose() {
//        clearConnectionQueue();
//    }
//
//    private void clearConnectionQueue() {
//        try {
//            closeConnectionsQueue(givenAwayConQueue);
//            closeConnectionsQueue(connectionQueue);
//        } catch (SQLException e) {
//            // logger.log(Level.ERROR, "Error closing the connection.", e);
//        }
//    }
//
//    public Connection takeConnection() throws ConnectionPoolException {
//        Connection connection = null;
//        try {
//            connection = connectionQueue.take();
//            givenAwayConQueue.offer(connection);
//        } catch (InterruptedException e) {
//            throw new ConnectionPoolException(
//                    "Error connecting to the data source.", e);
//        }
//        return connection;
//    }
//
//    public void closeConnection(Connection con, Statement st, ResultSet rs) {
//        try {
//            con.close();
//        } catch (SQLException e) {
//            // logger.log(Level.ERROR, "Connection isn't return to the pool.");
//        }
//
//        try {
//            rs.close();
//        } catch (SQLException e) {
//            // logger.log(Level.ERROR, "ResultSet isn't closed.");
//        }
//
//        try {
//            st.close();
//        } catch (SQLException e) {
//            // logger.log(Level.ERROR, "Statement isn't closed.");
//        }
//    }
//
//    public void closeConnection(Connection con, Statement st) {
//        try {
//            con.close();
//        } catch (SQLException e) {
//            // logger.log(Level.ERROR, "Connection isn't return to the pool.");
//        }
//
//        try {
//            st.close();
//        } catch (SQLException e) {
//            // logger.log(Level.ERROR, "Statement isn't closed.");
//        }
//    }
//
//    private void closeConnectionsQueue(BlockingQueue<Connection> queue)
//            throws SQLException {
//        Connection connection;
//        while ((connection = queue.poll()) != null) {
//            if (!connection.getAutoCommit()) {
//                connection.commit();
//            }
//            ((PooledConnection) connection).reallyClose();
//        }
//    }
//
//    private class PooledConnection implements Connection {
//        private Connection connection;
//
//        public PooledConnection(Connection c) throws SQLException {
//            this.connection = c;
//            this.connection.setAutoCommit(true);
//        }
//
//        public void reallyClose() throws SQLException {
//            connection.close();
//        }
//
//        @Override
//        public void clearWarnings() throws SQLException {
//            connection.clearWarnings();
//        }
//
//        @Override
//        public void close() throws SQLException {
//            if (connection.isClosed()) {
//                throw new SQLException("Attempting to close closed connection.");
//            }
//
//            if (connection.isReadOnly()) {
//                connection.setReadOnly(false);
//            }
//
//            if (!givenAwayConQueue.remove(this)) {
//                throw new SQLException(
//                        "Error deleting connection from the given away connections pool.");
//            }
//
//            if (!connectionQueue.offer(this)) {
//                throw new SQLException(
//                        "Error allocating connection in the pool.");
//            }
//        }
//
//        @Override
//        public void commit() throws SQLException {
//            connection.commit();
//        }
//
//        @Override
//        public Array createArrayOf(String typeName, Object[] elements)
//                throws SQLException {
//            return connection.createArrayOf(typeName, elements);
//        }
//
//        @Override
//        public Blob createBlob() throws SQLException {
//            return connection.createBlob();
//        }
//
//        @Override
//        public Clob createClob() throws SQLException {
//            return connection.createClob();
//        }
//
//        @Override
//        public NClob createNClob() throws SQLException {
//            return connection.createNClob();
//        }
//
//        @Override
//        public SQLXML createSQLXML() throws SQLException {
//            return connection.createSQLXML();
//        }
//
//        @Override
//        public Statement createStatement() throws SQLException {
//            return connection.createStatement();
//        }
//
//        @Override
//        public Statement createStatement(int resultSetType,
//                                         int resultSetConcurrency) throws SQLException {
//            return connection.createStatement(resultSetType,
//                    resultSetConcurrency);
//        }
//
//        @Override
//        public Statement createStatement(int resultSetType,
//                                         int resultSetConcurrency, int resultSetHoldability)
//                throws SQLException {
//            return connection.createStatement(resultSetType,
//                    resultSetConcurrency, resultSetHoldability);
//        }
//
//        @Override
//        public Struct createStruct(String typeName, Object[] attributes)
//                throws SQLException {
//            return connection.createStruct(typeName, attributes);
//        }
//
//        @Override
//        public boolean getAutoCommit() throws SQLException {
//            return connection.getAutoCommit();
//        }
//
//        @Override
//        public String getCatalog() throws SQLException {
//            return connection.getCatalog();
//        }
//
//        @Override
//        public Properties getClientInfo() throws SQLException {
//            return connection.getClientInfo();
//        }
//
//        @Override
//        public String getClientInfo(String name) throws SQLException {
//            return connection.getClientInfo(name);
//        }
//
//        @Override
//        public int getHoldability() throws SQLException {
//            return connection.getHoldability();
//        }
//
//        @Override
//        public DatabaseMetaData getMetaData() throws SQLException {
//            return connection.getMetaData();
//        }
//
//        @Override
//        public int getTransactionIsolation() throws SQLException {
//            return connection.getTransactionIsolation();
//        }
//
//        @Override
//        public Map<String, Class<?>> getTypeMap() throws SQLException {
//            return connection.getTypeMap();
//        }
//
//        @Override
//        public SQLWarning getWarnings() throws SQLException {
//            return connection.getWarnings();
//        }
//
//        @Override
//        public boolean isClosed() throws SQLException {
//            return connection.isClosed();
//        }
//
//        @Override
//        public boolean isReadOnly() throws SQLException {
//            return connection.isReadOnly();
//        }
//
//        @Override
//        public boolean isValid(int timeout) throws SQLException {
//            return connection.isValid(timeout);
//        }
//
//        @Override
//        public String nativeSQL(String sql) throws SQLException {
//            return connection.nativeSQL(sql);
//        }
//
//        @Override
//        public CallableStatement prepareCall(String sql) throws SQLException {
//            return connection.prepareCall(sql);
//        }
//
//        @Override
//        public CallableStatement prepareCall(String sql, int resultSetType,
//                                             int resultSetConcurrency) throws SQLException {
//            return connection.prepareCall(sql, resultSetType,
//                    resultSetConcurrency);
//        }
//
//        @Override
//        public CallableStatement prepareCall(String sql, int resultSetType,
//                                             int resultSetConcurrency, int resultSetHoldability)
//                throws SQLException {
//            return connection.prepareCall(sql, resultSetType,
//                    resultSetConcurrency, resultSetHoldability);
//        }
//
//        @Override
//        public PreparedStatement prepareStatement(String sql)
//                throws SQLException {
//            return connection.prepareStatement(sql);
//        }
//
//        @Override
//        public PreparedStatement prepareStatement(String sql,
//                                                  int autoGeneratedKeys) throws SQLException {
//            return connection.prepareStatement(sql, autoGeneratedKeys);
//        }
//
//        @Override
//        public PreparedStatement prepareStatement(String sql,
//                                                  int[] columnIndexes) throws SQLException {
//            return connection.prepareStatement(sql, columnIndexes);
//        }
//
//        @Override
//        public PreparedStatement prepareStatement(String sql,
//                                                  String[] columnNames) throws SQLException {
//            return connection.prepareStatement(sql, columnNames);
//        }
//
//        @Override
//        public PreparedStatement prepareStatement(String sql,
//                                                  int resultSetType, int resultSetConcurrency)
//                throws SQLException {
//            return connection.prepareStatement(sql, resultSetType,
//                    resultSetConcurrency);
//        }
//
//        @Override
//        public PreparedStatement prepareStatement(String sql,
//                                                  int resultSetType, int resultSetConcurrency,
//                                                  int resultSetHoldability) throws SQLException {
//            return connection.prepareStatement(sql, resultSetType,
//                    resultSetConcurrency, resultSetHoldability);
//        }
//
//        @Override
//        public void rollback() throws SQLException {
//            connection.rollback();
//        }
//
//        @Override
//        public void setAutoCommit(boolean autoCommit) throws SQLException {
//            connection.setAutoCommit(autoCommit);
//        }
//
//        @Override
//        public void setCatalog(String catalog) throws SQLException {
//            connection.setCatalog(catalog);
//        }
//
//        @Override
//        public void setClientInfo(String name, String value)
//                throws SQLClientInfoException {
//            connection.setClientInfo(name, value);
//        }
//
//        @Override
//        public void setHoldability(int holdability) throws SQLException {
//            connection.setHoldability(holdability);
//        }
//
//        @Override
//        public void setReadOnly(boolean readOnly) throws SQLException {
//            connection.setReadOnly(readOnly);
//        }
//
//        @Override
//        public Savepoint setSavepoint() throws SQLException {
//            return connection.setSavepoint();
//        }
//
//        @Override
//        public Savepoint setSavepoint(String name) throws SQLException {
//            return connection.setSavepoint(name);
//        }
//
//        @Override
//        public void setTransactionIsolation(int level) throws SQLException {
//            connection.setTransactionIsolation(level);
//        }
//
//        @Override
//        public boolean isWrapperFor(Class<?> iface) throws SQLException {
//            return connection.isWrapperFor(iface);
//        }
//
//        @Override
//        public <T> T unwrap(Class<T> iface) throws SQLException {
//            return connection.unwrap(iface);
//        }
//
//        @Override
//        public void abort(Executor arg0) throws SQLException {
//            connection.abort(arg0);
//
//        }
//
//        @Override
//        public int getNetworkTimeout() throws SQLException {
//            return connection.getNetworkTimeout();
//        }
//
//        @Override
//        public String getSchema() throws SQLException {
//            return connection.getSchema();
//        }
//
//        @Override
//        public void releaseSavepoint(Savepoint arg0) throws SQLException {
//            connection.releaseSavepoint(arg0);
//        }
//
//        @Override
//        public void rollback(Savepoint arg0) throws SQLException {
//            connection.rollback(arg0);
//        }
//
//        @Override
//        public void setClientInfo(Properties arg0)
//                throws SQLClientInfoException {
//            connection.setClientInfo(arg0);
//        }
//
//        @Override
//        public void setNetworkTimeout(Executor arg0, int arg1)
//                throws SQLException {
//            connection.setNetworkTimeout(arg0, arg1);
//        }
//
//        @Override
//        public void setSchema(String arg0) throws SQLException {
//            connection.setSchema(arg0);
//        }
//
//        @Override
//        public void setTypeMap(Map<String, Class<?>> arg0) throws SQLException {
//            connection.setTypeMap(arg0);
//        }
//    }
   // private final static ConnectionPool pool = new ConnectionPool();
    private BlockingQueue<Connection> connectionQueue;
    private BlockingQueue<Connection> givenAwayConnQueue;

    private final String driverName;
    private final String url;
    private final String user;
    private final String password;
    private int poolSize;

    private ConnectionPool() {
        DBResourceManager dbResourceManager = DBResourceManager.getInstance();

        this.driverName = dbResourceManager.getValue(DBParameter.DB_DRIVER);
        this.url = dbResourceManager.getValue(DBParameter.DB_URL);
        this.user = dbResourceManager.getValue(DBParameter.DB_USER);
        this.password = dbResourceManager.getValue(DBParameter.DB_PASSWORD);

        try {
            this.poolSize = Integer.parseInt(dbResourceManager.getValue(DBParameter.DB_POOL_SIZE));

        } catch (NumberFormatException e) {
            poolSize = 10;
        }
    }

    public static ConnectionPool getInstance() {
        return new ConnectionPool();
    }

    public void initPoolData() throws ConnectionPoolException {
        Locale.setDefault(Locale.ENGLISH);

        try {
            Class.forName(driverName);
            givenAwayConnQueue = new ArrayBlockingQueue<Connection>(poolSize);
            connectionQueue = new ArrayBlockingQueue<Connection>(poolSize);

            for (int i = 0; i < poolSize; i++) {
                Connection connection = DriverManager.getConnection(url, user, password);
                PooledConnection pooledConnection = new PooledConnection(connection);
                connectionQueue.add(pooledConnection);
            }
        } catch (SQLException e) {
            throw new ConnectionPoolException("SQLException in ConnectionPool", e);

        } catch (ClassNotFoundException e) {
            throw new ConnectionPoolException("Can't find database driver class", e);

        }
    }

    public void dispose() {
        clearConnectionQueue();
    }

    private void clearConnectionQueue() {
        try {
            closeConnectionsQueue(givenAwayConnQueue);
            closeConnectionsQueue(connectionQueue);

        } catch (SQLException e) {
            //logger.log(Level.ERROR, "Error closing connection.", e);
        }
    }

    public Connection takeConnection() throws ConnectionPoolException {
        Connection conn = null;

        try {
            if (connectionQueue == null) {
                initPoolData();
            }
            conn = connectionQueue.take();
            givenAwayConnQueue.add(conn);

        } catch (InterruptedException e) {
            throw new ConnectionPoolException("Error connecting to the data source", e);

        }

        return conn;
    }

    public void closeConnection(Connection conn, Statement st, ResultSet rs) {
        try {
            conn.close();
        } catch (SQLException e) {
            //logger.log(Level.ERROR, "Connection isn't return to the pool.");
        }

        try {
            rs.close();
        } catch (SQLException e) {
        }

        try {
            st.close();
        } catch (SQLException e) {

        }
    }

    public void closeConnection(Connection conn, PreparedStatement st) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {

        }

    }

    private void closeConnectionsQueue(BlockingQueue<Connection> queue) throws SQLException {
        Connection connection;
        while ((connection = queue.poll()) != null) {
            if (!connection.getAutoCommit()) {
                connection.commit();
            }
            ((PooledConnection) connection).reallyClose();
        }
    }

    private class PooledConnection implements Connection {
        private Connection connection;

        public PooledConnection(Connection c) throws SQLException {
            this.connection = c;
            this.connection.setAutoCommit(true);
        }

        public void reallyClose() throws SQLException {
            connection.close();
        }

        @Override
        public Statement createStatement() throws SQLException {
            return connection.createStatement();
        }

        @Override
        public PreparedStatement prepareStatement(String sql) throws SQLException {
            return connection.prepareStatement(sql);
        }

        @Override
        public CallableStatement prepareCall(String sql) throws SQLException {
            return connection.prepareCall(sql);
        }

        @Override
        public String nativeSQL(String sql) throws SQLException {
            return connection.nativeSQL(sql);
        }

        @Override
        public void setAutoCommit(boolean autoCommit) throws SQLException {
            connection.setAutoCommit(autoCommit);
        }

        @Override
        public boolean getAutoCommit() throws SQLException {
            return connection.getAutoCommit();
        }

        @Override
        public void commit() throws SQLException {
            connection.commit();
        }

        @Override
        public void rollback() throws SQLException {
            connection.rollback();
        }

        @Override
        public void close() throws SQLException {
            if (connection.isClosed()) {
                throw new SQLException("Attempting to close closed");
            }

            if (connection.isReadOnly()) {
                connection.setReadOnly(false);
            }

            if (!givenAwayConnQueue.remove(this)) {
                throw new SQLException(
                        "Error deleting connection from given away connections pool");
            }
        }

        @Override
        public boolean isClosed() throws SQLException {
            return connection.isClosed();
        }

        @Override
        public DatabaseMetaData getMetaData() throws SQLException {
            return connection.getMetaData();
        }

        @Override
        public void setReadOnly(boolean readOnly) throws SQLException {
            connection.setReadOnly(readOnly);
        }

        @Override
        public boolean isReadOnly() throws SQLException {
            return connection.isReadOnly();
        }

        @Override
        public void setCatalog(String catalog) throws SQLException {
            connection.setCatalog(catalog);
        }

        @Override
        public String getCatalog() throws SQLException {
            return connection.getCatalog();
        }

        @Override
        public void setTransactionIsolation(int level) throws SQLException {
            connection.setTransactionIsolation(level);
        }

        @Override
        public int getTransactionIsolation() throws SQLException {
            return connection.getTransactionIsolation();
        }

        @Override
        public SQLWarning getWarnings() throws SQLException {
            return connection.getWarnings();
        }

        @Override
        public void clearWarnings() throws SQLException {
            connection.clearWarnings();
        }

        @Override
        public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
            return connection.createStatement(resultSetType, resultSetConcurrency);
        }

        @Override
        public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
                throws SQLException {
            return connection.prepareStatement(sql, resultSetType, resultSetConcurrency);
        }

        @Override
        public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency)
                throws SQLException {
            return connection.prepareCall(sql, resultSetType, resultSetConcurrency);
        }

        @Override
        public Map<String, Class<?>> getTypeMap() throws SQLException {
            return connection.getTypeMap();
        }

        @Override
        public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
            connection.setTypeMap(map);
        }

        @Override
        public void setHoldability(int holdability) throws SQLException {
            connection.setHoldability(holdability);
        }

        @Override
        public int getHoldability() throws SQLException {
            return connection.getHoldability();
        }

        @Override
        public Savepoint setSavepoint() throws SQLException {
            return connection.setSavepoint();
        }

        @Override
        public Savepoint setSavepoint(String name) throws SQLException {
            return connection.setSavepoint(name);
        }

        @Override
        public void rollback(Savepoint savepoint) throws SQLException {
            connection.rollback(savepoint);
        }

        @Override
        public void releaseSavepoint(Savepoint savepoint) throws SQLException {
            connection.releaseSavepoint(savepoint);
        }

        @Override
        public Statement createStatement(int resultSetType, int resultSetConcurrency,
                                         int resultSetHoldability)
                throws SQLException {
            return connection.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability);
        }

        @Override
        public PreparedStatement prepareStatement(String sql, int resultSetType,
                                                  int resultSetConcurrency, int resultSetHoldability)
                throws SQLException {
            return connection.prepareStatement(sql, resultSetType);
        }

        @Override
        public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
            return connection.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
        }

        @Override
        public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
            return connection.prepareStatement(sql, autoGeneratedKeys);
        }

        @Override
        public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
            return connection.prepareStatement(sql, columnIndexes);
        }

        @Override
        public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
            return connection.prepareStatement(sql, columnNames);
        }

        @Override
        public Clob createClob() throws SQLException {
            return connection.createClob();
        }

        @Override
        public Blob createBlob() throws SQLException {
            return connection.createBlob();
        }

        @Override
        public NClob createNClob() throws SQLException {
            return connection.createNClob();
        }

        @Override
        public SQLXML createSQLXML() throws SQLException {
            return connection.createSQLXML();
        }

        @Override
        public boolean isValid(int timeout) throws SQLException {
            return connection.isValid(timeout);
        }

        @Override
        public void setClientInfo(String name, String value) throws SQLClientInfoException {
            connection.setClientInfo(name, value);
        }

        @Override
        public void setClientInfo(Properties properties) throws SQLClientInfoException {
            connection.setClientInfo(properties);
        }

        @Override
        public String getClientInfo(String name) throws SQLException {
            return connection.getClientInfo(name);
        }

        @Override
        public Properties getClientInfo() throws SQLException {
            return connection.getClientInfo();
        }

        @Override
        public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
            return connection.createArrayOf(typeName, elements);
        }

        @Override
        public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
            return connection.createStruct(typeName, attributes);
        }

        @Override
        public void setSchema(String schema) throws SQLException {
            connection.setSchema(schema);
        }

        @Override
        public String getSchema() throws SQLException {
            return connection.getSchema();
        }

        @Override
        public void abort(Executor executor) throws SQLException {
            connection.abort(executor);
        }

        @Override
        public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
            connection.setNetworkTimeout(executor, milliseconds);
        }

        @Override
        public int getNetworkTimeout() throws SQLException {
            return connection.getNetworkTimeout();
        }

        @Override
        public <T> T unwrap(Class<T> iface) throws SQLException {
            return connection.unwrap(iface);
        }

        @Override
        public boolean isWrapperFor(Class<?> iface) throws SQLException {
            return connection.isWrapperFor(iface);
        }
    }
}




































//    private String databaseUrl;
//    private String userName;
//    private String password;
//
//    private int maxPoolSize = 10;
//    private int connNumb = 0;
//
//    private static final String SQL_VERIFYCONN = "select 1";
//
//    Stack<Connection> freePool = new Stack<>();
//    Set<Connection> occupiedPool = new HashSet<>();
//
//    public ConnectionPool(String databaseUrl, String userName, String password, int maxPoolSize) {
//        this.databaseUrl = databaseUrl;
//        this.userName = userName;
//        this.password = password;
//        this.maxPoolSize = maxPoolSize;
//    }
//
//    public synchronized Connection getConnection() throws SQLException{
//        Connection conn = null;
//
//        if(isFull()){
//            throw new SQLException("The connection pool is full.");
//        }
//        conn = getConnectionFromPool();
//
//        if(conn == null){
//            conn = createNewConnectionForPool();
//        }
//        conn = makeAvailable(conn);
//
//        return conn;
//    }
//
//    public synchronized void returnConnection(Connection conn) throws SQLException{         //закрытие конекшена
//        if(conn == null){
//            throw new NullPointerException();   //todo сделать красиво
//        }
//
//        if(!occupiedPool.remove(conn)){     //удаляем активный конекшен
//            throw new SQLException("The connection is returned already or it isn't for this pool");
//        }
//
//        freePool.push(conn);        //и запускаем в свободные конекшены
//    }
//
//    private synchronized boolean isFull(){
//        return ((freePool.size() == 0) && (connNumb >= maxPoolSize));
//    }
//
//    private Connection createNewConnectionForPool() throws SQLException{
//        Connection conn = createNewConnection();
//        connNumb++;
//        occupiedPool.add(conn);
//
//        return conn;
//    }
//
//    private Connection createNewConnection() throws SQLException{
//        Connection conn = null;
//        conn = DriverManager.getConnection(databaseUrl, userName, password);
//
//        return conn;
//    }
//
//    private Connection getConnectionFromPool(){
//        Connection conn = null;
//
//        if (freePool.size() > 0){
//            conn = freePool.pop();
//            occupiedPool.add(conn);
//        }
//
//        return conn;
//    }
//
//    private Connection makeAvailable(Connection conn) throws SQLException{      //создание рабочего(активного) конекшена
//        if(isConnectionAvalible(conn)){
//            return (conn);
//        }
//
//        occupiedPool.remove(conn);              //если конекшен не рабочий, мы его удаляем
//        connNumb--;
//        conn.close();
//
//        conn = createNewConnection();           //при этом, чтобы не потерять ?этот коннекшен, мы создаём новый и его возвращаем
//        occupiedPool.add(conn);
//        connNumb++;
//
//        return conn;
//    }
//
//    private boolean isConnectionAvalible(Connection conn){          //проверка на рабочий коннекшн
//        try(Statement st = conn.createStatement()){
//            st.executeQuery(SQL_VERIFYCONN);
//
//            return true;
//        } catch (SQLException e){
//            return false;
//        }
//    }
//}
