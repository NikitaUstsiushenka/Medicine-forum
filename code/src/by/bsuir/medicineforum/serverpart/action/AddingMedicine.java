package by.bsuir.medicineforum.serverpart.action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
                        final HttpServletResponse response) {



    }

}
