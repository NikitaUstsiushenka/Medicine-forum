package by.bsuir.medicineforum.database;

import by.bsuir.medicineforum.database.dao.AbstractUserDao;
import by.bsuir.medicineforum.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements methods for work with table 'user'.
 *
 * @author Nikita
 * @version 1.0
 * @since 05.11.2018
 */
public final class UserDao extends AbstractUserDao {

    /**
     * Logger for debug and error.
     */
    private static Logger logger;

    /**
     * Public default constructor.
     */
    public UserDao() {

        super();
        logger = LogManager.getLogger(UserDao.class);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> select() {

        final List<User> users = new ArrayList<>();

        return users;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void insert(final User user) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final User user) {

    }

}
