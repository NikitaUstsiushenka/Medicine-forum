package by.bsuir.medicineforum.serverpart.servlets;

import by.bsuir.medicineforum.exception.ApplicationException;
import by.bsuir.medicineforum.serverpart.action.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
                       final HttpServletResponse response)
            throws IOException, ServletException {

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
                      final HttpServletResponse response)
            throws IOException, ServletException {

        try {
            this.process(request, response);
        } catch (ApplicationException e) {

            logger.log(Level.ERROR, " " + e.getMessage());
            e.printStackTrace();

        }

    }

    private void process(final HttpServletRequest request,
                         final HttpServletResponse response)
            throws ApplicationException, IOException, ServletException {

        final Action action;
        final String clientAction = request.getParameter("action");
        final String errorString = "";
        final String debugString = "";

        if (clientAction != null) {

            switch (clientAction) {

                case "signin":
                    action = new Authorization();
                    action.execute(request, response);
                    break;
                case "logout":
                    request.getSession().removeAttribute("user");
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                    break;
                case "delete_medicine":
                    action = new DeletingMedicine();
                    action.execute(request, response);
                    break;
                case "show_medicines":
                    action = new ShowingMedicines();
                    action.execute(request, response);
                    break;
                case "add_medicine":
                    action = new AddingMedicine();
                    action.execute(request, response);
                    break;
                case "change_medicine":
                    action = new ChangingMedicine();
                    action.execute(request, response);
                default:
                    throw new ApplicationException(errorString);

            }

        } else {
            logger.log(Level.DEBUG, debugString);
        }

    }

}
