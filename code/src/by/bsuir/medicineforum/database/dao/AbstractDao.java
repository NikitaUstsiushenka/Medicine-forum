package by.bsuir.medicineforum.database.dao;

import by.bsuir.medicineforum.entity.AbstractEntity;

import java.util.List;

/**
 * This abstract class stores basic methods for work with database.
 *
 * @author Nikita
 * @version 1.0
 * @since 04.11.2018
 */
public abstract class AbstractDao<T extends AbstractEntity> {

    /**
     * Protected default constructor.
     */
    protected AbstractDao() {

    }

    /**
     * This method selects some elements from database.
     *
     * @return list of objects that extend AbstractEntity class
     */
    protected abstract List<T> select();

    /**
     * This method inserts some element in database.
     *
     * @param object value of the object that extends AbstractEntity clas
     */
    protected abstract void insert(T object);

    /**
     * This method updates some element from database.
     *
     * @param object value of the object that extends AbstractEntity class
     */
    protected abstract void update(T object);

}
