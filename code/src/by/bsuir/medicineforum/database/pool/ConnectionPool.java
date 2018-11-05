package by.bsuir.medicineforum.database.pool;

import by.bsuir.medicineforum.exception.ApplicationException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This class stores connections for database.
 *
 * @author Nikita
 * @version 1.0
 * @since 04.11.2018
 */
public final class ConnectionPool {

    /**
     * Logger for debug.
     */
    private static Logger logger;

    /**
     * Value of the single object ConnectionPool.
     */
    private static ConnectionPool instance;

    /**
     * Value of the object ReentrantLock.
     */
    private static ReentrantLock locker;

    /**
     * List of connections.
     */
    private BlockingQueue<Connection> connections;

    /**
     * Value of the database class.
     */
    private static final String DB_CLASS;

    /**
     * Value of the database url.
     */
    private static final String DB_URL;

    /**
     * Value of the database user name.
     */
    private static final String DB_USER;

    /**
     * Value of the database user password.
     */
    private static final String DB_PASSS;

    static {

        DB_CLASS = "com.mysql.jdbc.Driver";
        DB_URL = "jdbc:mysql//localhost:3306/medicine-forum";
        DB_USER = "root";
        DB_PASSS = "Nikita09061999";

    }

    /**
     * Private default constructor.
     */
    private ConnectionPool() {

        this.connections = new LinkedBlockingQueue<>();
        logger = LogManager.getLogger(ConnectionPool.class);
        locker = new ReentrantLock();

        try {
            Class.forName(DB_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            logger.log(Level.ERROR, e.getMessage());
        }

    }

    /**
     * This method returns single object ConnectionPool.
     *
     * @return value of the object ConnectionPool
     */
    public static ConnectionPool getInstance() {

        locker.lock();

        try {

            if (instance == null) {
                instance = new ConnectionPool();
            }

        } finally {
            locker.unlock();
        }

        return instance;

    }

    /**
     * This method returns connection from pool.
     *
     * @return value of the object Connection
     * @throws ApplicationException throw SQLException or InterruptedException
     */
    public Connection getConnection() throws ApplicationException {

        Connection connection = null;

        locker.lock();

        try {

            while (connection == null) {

                if (this.connections.isEmpty()) {
                    connection = DriverManager
                            .getConnection(DB_URL, DB_USER, DB_PASSS);
                } else {

                    connection = this.connections.take();

                    if (!connection.isValid(0)) {
                        connection = null;
                    }

                }

            }

        } catch (SQLException | InterruptedException e) {
            throw new ApplicationException();
        } finally {
            locker.unlock();
        }

        return connection;

    }

}
