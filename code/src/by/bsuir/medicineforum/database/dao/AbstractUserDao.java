package by.bsuir.medicineforum.database.dao;

import by.bsuir.medicineforum.entity.User;
import by.bsuir.medicineforum.exception.ApplicationException;

/**
 * @author Nikita
 * @version 1.0
 * @since 08.11.2018
 */
public abstract class AbstractUserDao extends AbstractDao<User> {

    /**
     * This protected default constructor.
     */
    protected AbstractUserDao() {

    }

    /**
     * This method checks is existence user by login and password.
     *
     * @param login    value of the user login
     * @param password value of the user password
     * @throws ApplicationException throw SQLException
     */
    protected abstract boolean isExist(String login, String password)
            throws ApplicationException;

}
