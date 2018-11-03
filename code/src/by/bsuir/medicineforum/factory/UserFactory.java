package by.bsuir.medicineforum.factory;

import by.bsuir.medicineforum.entity.User;
import by.bsuir.medicineforum.exception.ApplicationException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;

/**
 * This class implements createEntity methods for user.
 *
 * @author Nikita
 * @version 1.0
 * @since 03.11.2018
 */
public final class UserFactory implements EntityFactory<User> {

    /**
     * Logger for debug.
     */
    private static Logger logger;

    /**
     * Public default constructor.
     */
    public UserFactory() {

        logger = LogManager.getLogger(UserFactory.class);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User createEntity() {

        final User user = new User();
        final String debugString = " Object User " + user + " created.";

        logger.log(Level.DEBUG, debugString);

        return user;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User createEntity(final HttpServletRequest request)
            throws ApplicationException {

        final String errorString
                = " Object User can't be create from request.";

        throw new ApplicationException(errorString);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User createEntity(final ResultSet resultSet) {

        final User user = new User();
        final String debugString = " Object User " + user + " created.";

        logger.log(Level.DEBUG, debugString);

        return user;

    }

}
