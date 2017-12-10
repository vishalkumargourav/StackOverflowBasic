package com.arctrace.util;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

/*
 * base class for all the dao implementations
 */
public class BaseNamedParameterJdbcTemplate extends NamedParameterJdbcDaoSupport{
    @Autowired
    public void setDataSource1(DataSource dataSource){
        setDataSource(dataSource);
    }
    
}
