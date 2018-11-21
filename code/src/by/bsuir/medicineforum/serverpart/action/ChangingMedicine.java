package by.bsuir.medicineforum.serverpart.action;

import by.bsuir.medicineforum.database.DrugDao;
import by.bsuir.medicineforum.database.dao.AbstractDao;
import by.bsuir.medicineforum.entity.Drug;
import by.bsuir.medicineforum.exception.ApplicationException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This class implements "Action" for changing medicine.
 *
 * @author Nikita
 * @version 1.0
 * @since 14.11.2018
 */
public class ChangingMedicine implements Action {

    /**
     * Logger for debug and error.
     */
    private static Logger logger;

    /**
     * Public default constructor.
     */
    public ChangingMedicine() {

        logger = LogManager.getLogger(ChangingMedicine.class);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(final HttpServletRequest request,
                        final HttpServletResponse response)
            throws IOException, ServletException {

        final String description = request.getParameter("description");
        final String drugName = request.getParameter("medicine_name");
        final Drug drug = new Drug();
        final AbstractDao dao = new DrugDao();

        drug.setDescription(description);
        drug.setName(drugName);

        try {
            ((DrugDao) dao).update(drug);
        } catch (ApplicationException e) {

            logger.log(Level.ERROR, e.getMessage());
            e.printStackTrace();

        }

        request.getRequestDispatcher("/WEB-INF/jsp/admin.jsp")
                .forward(request, response);

    }

}
