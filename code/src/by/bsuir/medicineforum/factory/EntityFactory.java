package by.bsuir.medicineforum.factory;

import by.bsuir.medicineforum.entity.AbstractEntity;
import by.bsuir.medicineforum.exception.ApplicationException;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * */
public interface EntityFactory<T extends AbstractEntity> {

    /**
     *
     * */
    T createEntity();

    /**
     *
     * */
    T createEntity(HttpServletRequest request) throws ApplicationException;

    /**
     *
     * */
    T createEntity(ResultSet resultSet) throws SQLException;

}
