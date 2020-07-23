package com.ECUT.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtilDruid {
    public JDBCUtilDruid() {
    }
    public  static DataSource source=null;
    static {
        try {
            Properties pros=new Properties();
            InputStream is= JDBCUtilDruid.class.getClassLoader().getResourceAsStream("druid.properties");
            pros.load(is);
            source= DruidDataSourceFactory.createDataSource(pros);
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getconnection() throws SQLException {

        Connection conn=source.getConnection();
        return conn;
    }
    /**
     *
     * @param conn"数据库连接对象"
     * @param ps"数据库操作对象"
     * @param rs"结果集”
     */
    public static void close(Connection conn, Statement ps, ResultSet rs){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(Connection conn, Statement ps){
        if (ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(Connection conn){
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



}
