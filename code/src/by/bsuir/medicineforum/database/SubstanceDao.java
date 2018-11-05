package by.bsuir.medicineforum.database;

import by.bsuir.medicineforum.database.dao.AbstractSubstanceDao;
import by.bsuir.medicineforum.entity.Substance;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements method for work with table 'substance'.
 *
 * @author Nikita
 * @version 1.0
 * @since 05.11.2018
 */
public final class SubstanceDao extends AbstractSubstanceDao {

    /**
     * Logger for debug and errors.
     */
    private static Logger logger;

    /**
     * Public default constructor.
     */
    public SubstanceDao() {

        super();
        logger = LogManager.getLogger(SubstanceDao.class);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Substance> select() {

        final List<Substance> substances = new ArrayList<>();

        return substances;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void insert(final Substance substance) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final Substance substance) {

    }

}
