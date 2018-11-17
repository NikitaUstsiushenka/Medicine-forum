package by.bsuir.medicineforum.serverpart.action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class implements "Action" for changing medicine.
 *
 * @author Nikita
 * @version 1.0
 * @since 14.11.2018
 */
public final class ChangingMedicine implements Action {

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
                        final HttpServletResponse response) {

    }

}
