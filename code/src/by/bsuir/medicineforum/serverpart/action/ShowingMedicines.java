package by.bsuir.medicineforum.serverpart.action;

import by.bsuir.medicineforum.database.DrugDao;
import by.bsuir.medicineforum.database.dao.AbstractDao;
import by.bsuir.medicineforum.exception.ApplicationException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This class implements interface "Action" for showing medicines.
 *
 * @author Nikita
 * @version 1.0
 * @since 14.11.2018
 */
public final class ShowingMedicines implements Action {

    /**
     * Logger for debug and error.
     */
    private Logger logger;

    /**
     * Public default constructor.
     */
    public ShowingMedicines() {

        logger = LogManager.getLogger(ShowingMedicines.class);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(final HttpServletRequest request,
                        final HttpServletResponse response)
            throws ServletException, IOException {

        final AbstractDao dao = new DrugDao();

        try {

            request.getSession().setAttribute("drugs",
                    ((DrugDao) dao).select());
            request.getRequestDispatcher(
                    "/index.jsp")
                    .forward(request, response);

        } catch (ApplicationException e) {

            logger.log(Level.ERROR, e.getMessage());
            e.printStackTrace();

        }

    }

}
