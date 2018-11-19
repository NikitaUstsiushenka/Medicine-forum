package by.bsuir.medicineforum.serverpart.action;

import by.bsuir.medicineforum.database.DrugDao;
import by.bsuir.medicineforum.database.SubstanceDao;
import by.bsuir.medicineforum.database.dao.AbstractDao;
import by.bsuir.medicineforum.entity.Drug;
import by.bsuir.medicineforum.exception.ApplicationException;
import by.bsuir.medicineforum.factory.DrugFactory;
import by.bsuir.medicineforum.factory.EntityFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class implements interface "Action" for adding medicine.
 *
 * @author Nikita
 * @version 1.0
 * @since 14.11.2018
 */
public final class AddingMedicine implements Action {

    /**
     * Logger for debug and error.
     */
    private static Logger logger;

    /**
     * Public default constructor.
     */
    public AddingMedicine() {

        logger = LogManager.getLogger(AddingMedicine.class);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(final HttpServletRequest request,
                        final HttpServletResponse response)
            throws IOException, ServletException {

        final EntityFactory factory = new DrugFactory();
        final Drug drug = ((DrugFactory) factory).createEntity(request);

        AbstractDao dao;
        List<Drug> drugs = new ArrayList<>();

        dao = new SubstanceDao();

        try {

            if (!((SubstanceDao) dao).isExistSubstance(
                    drug.getSubstance().getName())) {
                ((SubstanceDao) dao).insert(drug.getSubstance());
            }

            dao = new DrugDao();
            ((DrugDao) dao).insert(drug);
            drugs = ((DrugDao) dao).select();

        } catch (ApplicationException e) {

            logger.log(Level.ERROR, e.getMessage());
            e.printStackTrace();

        }

        request.getSession().removeAttribute("drugs");
        request.getSession().setAttribute("drugs", drugs);
        request.getRequestDispatcher("/WEB-INF/jsp/admin.jsp")
                .forward(request, response);

    }

}
