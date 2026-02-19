package controller.dao;

import controller.dao.interfaces.GenericDAO;

import java.sql.Connection;

public abstract class BaseDAO<T> implements GenericDAO<T> {

    protected Connection connection;

    public BaseDAO() {
        this.connection = ConnectionFactory.getConnection();
    }
}
