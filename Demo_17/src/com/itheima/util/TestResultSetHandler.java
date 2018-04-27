package com.itheima.util;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class TestResultSetHandler {
    //取一行
    public void test1() throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

    Object[] arr = qr.query("select * from sunxiaozhe where id=?",new ArrayHandler(),6);
            for (Object o : arr){
        System.out.println(o);
    }
}
    //取所有数据
    public void test2() throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

        List<Object[]> query = qr.query("select * from sunxiaozhe ",new ArrayListHandler());
        for (Object[] os : query){
            for (Object o : os) {
                System.out.println(o);
            }
            System.out.println("----------------------------------");
        }
    }
    //取某一列数据
    public void test3() throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

        List<Object> list = qr.query("select username,password from sunxiaozhe",new ColumnListHandler(2));
        for (Object o : list){
            System.out.println(o);
        }
    }
    //取多条记录，每一条记录封装到一个Map中，再把这个Map封装到另一个Map中
    public void test4() throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

       Map<Object,Map<String,Object>> map = qr.query("select * from sunxiaozhe", new KeyedHandler(2));

        for (Map.Entry<Object,Map<String,Object>> m : map.entrySet()){
            for (Map.Entry<String,Object> mm : m.getValue().entrySet()){
                System.out.println(mm.getKey()+"\t"+mm.getValue());
            }
            System.out.println("----------------------------------");
        }
    }
    //取单行单列
    public void test5() throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

        Object o = qr.query("select password from sunxiaozhe",new ScalarHandler(3));
            System.out.println(o);
    }
}
