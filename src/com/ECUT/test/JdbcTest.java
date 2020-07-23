package com.ECUT.test;

import com.ECUT.utils.JDBCUtilDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.SQLException;

public class JdbcTest {
    @Test
    public void test(){
        try {
            System.out.println(JDBCUtilDruid.getconnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
