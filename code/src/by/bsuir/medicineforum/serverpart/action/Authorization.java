package by.bsuir.medicineforum.serverpart.action;

import by.bsuir.medicineforum.database.UserDao;
import by.bsuir.medicineforum.database.dao.AbstractDao;
import by.bsuir.medicineforum.entity.User;
import by.bsuir.medicineforum.exception.ApplicationException;
import by.bsuir.medicineforum.factory.EntityFactory;
import by.bsuir.medicineforum.factory.UserFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Nikita
 * @version 1.0
 * @since 08.11.2018
 */
public final class Authorization implements Action {

    /**
     * Logger for debug and error.
     */
    private static Logger logger;

    /**
     * Public default constructor.
     */
    public Authorization() {

        logger = LogManager.getLogger(Authorization.class);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(final HttpServletRequest request,
                        final HttpServletResponse response)
            throws IOException {

        final AbstractDao dao = new UserDao();
        final EntityFactory factory = new UserFactory();
        final User user = ((UserFactory) factory).createEntity(request);
        final String debugString;

        try {

            if (((UserDao) dao).isExist(user.getLogin(), user.getPassword())) {

                request.getSession().setAttribute("user", user);
                request.getRequestDispatcher("").forward(request, response);

                debugString = " User " + user + " has logged in.";

            } else {

                debugString = " User " + user + " ";

            }

        } catch (ApplicationException e) {

            e.printStackTrace();
            logger.log(Level.ERROR, e.getMessage());

        }

    }

}
