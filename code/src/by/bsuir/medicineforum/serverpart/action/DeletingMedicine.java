package by.bsuir.medicineforum.serverpart.action;

import by.bsuir.medicineforum.database.DrugDao;
import by.bsuir.medicineforum.database.dao.AbstractDao;
import by.bsuir.medicineforum.exception.ApplicationException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class implements interface "Action" for deleting drug.
 *
 * @author Nikita
 * @version 1.0
 * @since 14.11.2018
 */
public final class DeletingMedicine implements Action {

    /**
     * Logger for debug and error.
     */
    private static Logger logger;

    /**
     * Public default constructor.
     */
    public DeletingMedicine() {

        logger = LogManager.getLogger(DeletingMedicine.class);

    }

    /**
     * {@inheritDoc}
     */
    public void execute(final HttpServletRequest request,
                        final HttpServletResponse response) {

        final String drugName = request.getParameter("drug_name");
        final AbstractDao dao = new DrugDao();

        try {

            if (((DrugDao) dao).delete(drugName)) {

            } else {

            }

        } catch (ApplicationException e) {

            logger.log(Level.ERROR, e.getMessage());
            e.printStackTrace();

        }

    }

}
