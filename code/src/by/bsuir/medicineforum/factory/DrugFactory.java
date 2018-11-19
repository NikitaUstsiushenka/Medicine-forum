package by.bsuir.medicineforum.factory;

import by.bsuir.medicineforum.entity.Drug;
import by.bsuir.medicineforum.entity.Substance;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class implements methods createEntity for drug.
 *
 * @author Nikita
 * @version 1.0
 * @since 03.11.2018
 */
public final class DrugFactory implements EntityFactory<Drug> {

    /**
     * Logger for debug.
     */
    private static Logger logger;

    /**
     * Public default constructor.
     */
    public DrugFactory() {

        logger = LogManager.getLogger(DrugFactory.class);

    }

    /**
     * {@inheritDoc}
     */
    public Drug createEntity() {

        final Drug drug = new Drug();
        final String debugString = " Object Drug " + drug + " created.";

        logger.log(Level.DEBUG, debugString);

        return drug;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Drug createEntity(final HttpServletRequest request) {

        final Drug drug = new Drug();
        final Substance substance = new Substance();
        final String debugString = " Object Drug " + drug + " created.";

        substance.setName(request.getParameter("substance_name"));

        drug.setName(request.getParameter("drug_name"));
        drug.setDescription(request.getParameter("description"));
        drug.setSubstance(substance);

        logger.log(Level.DEBUG, debugString);

        return drug;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Drug createEntity(final ResultSet resultSet)
            throws SQLException {

        final Drug drug = new Drug();
        final String debugString = " Object Drug " + drug + " created.";

        drug.setId(resultSet.getInt("id"));
        drug.setName(resultSet.getString("name"));
        drug.setDescription(resultSet.getString("description"));
        drug.setSubstance(new Substance() {{
            this.setName(resultSet.getString("substance_name"));
        }});

        logger.log(Level.DEBUG, debugString);

        return drug;

    }

}
