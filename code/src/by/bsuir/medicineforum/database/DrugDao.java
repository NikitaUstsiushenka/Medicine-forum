package by.bsuir.medicineforum.database;

import by.bsuir.medicineforum.database.dao.AbstractDrugDao;
import by.bsuir.medicineforum.entity.Drug;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements methods for work with table 'drug'.
 *
 * @author Nikita
 * @version 1.0
 * @since 05.11.2018
 */
public final class DrugDao extends AbstractDrugDao {

    /**
     * Logger for debug and error.
     */
    private static Logger logger;

    /**
     * Public default constructor.
     */
    public DrugDao() {

        logger = LogManager.getLogger();

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Drug> select() {

        final List<Drug> drugs = new ArrayList<>();

        return drugs;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void insert(final Drug drug) {


    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final Drug drug) {


    }

}
