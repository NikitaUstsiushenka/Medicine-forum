package by.bsuir.medicineforum.database.dao;

import by.bsuir.medicineforum.entity.Drug;
import by.bsuir.medicineforum.exception.ApplicationException;

/**
 * This abstract class stores methods for work with table 'drug'.
 *
 * @author Nikita
 * @version 1.0
 * @since 30.09.2018
 */
public abstract class AbstractDrugDao extends AbstractDao<Drug> {

    /**
     * Protected default constructor.
     */
    protected AbstractDrugDao() {

        super();

    }

    /**
     * Method declaration for delete drug from database.
     *
     * @param name value of the drug name
     * @return boolean value
     * @throws ApplicationException throw SQLException
     */
    protected abstract boolean delete(String name) throws ApplicationException;

}
