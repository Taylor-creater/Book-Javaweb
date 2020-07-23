package com.ECUT.dao.impl;

import com.ECUT.utils.JDBCUtilDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class  BaseDao {
    QueryRunner queryRunner=new QueryRunner();

    public int update(String sql, Object...args){
        Connection conn= null;
        try {
            conn = JDBCUtilDruid.getconnection();
            return  queryRunner.update(conn,sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtilDruid.close(conn);
        }
        return -1;
    }
    public <T> T queryForone(Class<T> type,String sql,Object...args){
        Connection conn=null;
        try {
             conn=JDBCUtilDruid.getconnection();
            return queryRunner.query(conn,sql,new BeanHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtilDruid.close(conn);
        }
        return null;
    }
    public <T> List<T> queryForlist(Class<T> type, String sql, Object...args){
        Connection conn=null;
        try {
            conn=JDBCUtilDruid.getconnection();
           return queryRunner.query(conn,sql,new BeanListHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtilDruid.close(conn);
        }
        return null;
    }
    public Object querySinglevalue(String sql,Object...args){
        Connection conn=null;
        try {
             conn=JDBCUtilDruid.getconnection();
             return  queryRunner.query(conn,sql,new ScalarHandler(),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtilDruid.close(conn);
        }
        return null;
    }

}
