package com.bobocode.dao;

import java.sql.SQLException;
import java.util.List;

public interface DaoTemplate<T> {
    public List<T> show() throws SQLException;
}
