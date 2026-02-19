package controller.dao;

import java.sql.Connection;

public abstract class BaseDAO<T> implements GenericDAO<T> {

    protected Connection connection;

    public BaseDAO() {
        this.connection = controller.service.ConnectionFactory.getConnection();
    }
}
