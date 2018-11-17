package by.bsuir.medicineforum.database;

import by.bsuir.medicineforum.database.dao.AbstractDrugDao;
import by.bsuir.medicineforum.database.pool.ConnectionPool;
import by.bsuir.medicineforum.entity.Drug;
import by.bsuir.medicineforum.exception.ApplicationException;
import by.bsuir.medicineforum.factory.DrugFactory;
import by.bsuir.medicineforum.factory.EntityFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

/**
 * This class implements methods for work with table 'drug'.
 *
 * @author Nikita
 * @version 1.0
 * @since 05.11.2018
 */
public final class DrugDao extends AbstractDrugDao {

    /**
     * Logger for debug and error.
     */
    private static Logger logger;

    /**
     * Value of the sql query for select all drugs from database.
     */
    private static final String SELECT_ALL_DRUGS
            = "SELECT d.`id`, d.`name`, d.`description`, s.`name` "
            + "`substance_name` FROM `drug` d INNER JOIN `substance` s "
            + "ON s.`id` = d.`substance_id`";

    /**
     * Value of the sql query that inserts drug.
     */
    private static final String INSERT_DRUG;

    static {

        INSERT_DRUG = "INSERT INTO `drug` (`substance_id`, `name`, "
                + "`description`) VALUES((SELECT `id` "
                + "FROM `substance` WHERE `name` = ?), ?, ?)";

    }

    /**
     * Public default constructor.
     */
    public DrugDao() {

        logger = LogManager.getLogger();

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Drug> select() throws ApplicationException {

        final List<Drug> drugs = new ArrayList<>();
        final EntityFactory factory = new DrugFactory();
        final ResultSet resultSet;
        final String debugString = " All drugs selected from table `drug`.";

        Connection connection = null;
        Statement statement = null;

        try {

            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SELECT_ALL_DRUGS);

            while (resultSet.next()) {
                drugs.add((Drug) factory.createEntity(resultSet));
            }

        } catch (SQLException e) {
            throw new ApplicationException(e.getMessage());
        } finally {

            super.close(statement);
            super.close(connection);

        }

        logger.log(Level.DEBUG, debugString);

        return drugs;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void insert(final Drug drug) throws ApplicationException {

        final String errorString = " Drug type is incorrect.";
        final String debugString;

        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(INSERT_DRUG);

            statement.setString(1, drug.getSubstance().getName());
            statement.setString(2, drug.getName());
            statement.setString(3, drug.getDescription());

        } catch (SQLException e) {
            throw new ApplicationException(e.getMessage());
        } finally {

            super.close(statement);
            super.close(connection);

        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final Drug drug) {


    }

}
