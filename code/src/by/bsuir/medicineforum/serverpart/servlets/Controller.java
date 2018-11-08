package by.bsuir.medicineforum.serverpart.servlets;

import by.bsuir.medicineforum.exception.ApplicationException;
import by.bsuir.medicineforum.serverpart.action.Action;
import by.bsuir.medicineforum.serverpart.action.Authorization;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet controller.
 *
 * @author Nikita
 * @version 1.0
 * @since 29.10.2018
 */
public final class Controller extends HttpServlet {

    /**
     * Logger for debug and error.
     */
    private static Logger logger;

    /**
     * {@inheritDoc}
     */
    @Override
    public void init() {

        logger = LogManager.getLogger(Controller.class);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doPost(final HttpServletRequest request,
                       final HttpServletResponse response) {

        try {
            this.process(request, response);
        } catch (ApplicationException e) {

            logger.log(Level.ERROR, " " + e.getMessage());
            e.printStackTrace();

        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doGet(final HttpServletRequest request,
                      final HttpServletResponse response) {

        try {
            this.process(request, response);
        } catch (ApplicationException e) {

            logger.log(Level.ERROR, " " + e.getMessage());
            e.printStackTrace();

        }

    }

    private void process(final HttpServletRequest request,
                         final HttpServletResponse response) throws ApplicationException {

        final Action action;
        final String clientAction = (String) request.getAttribute("action");
        final String errorString = "";
        final String debugString = "";

        if (clientAction != null) {

            switch (clientAction) {

                case "singin":
                    action = new Authorization();
                    action.execute(request, response);
                    break;
                default:
                    throw new ApplicationException(errorString);

            }

        } else {
            logger.log(Level.DEBUG, debugString);
        }

    }

}
