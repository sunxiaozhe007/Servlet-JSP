package com.itheima.util;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class TestRUD {
/*
//查询方法
   public void TestInsert() throws SQLException {
        //创建一个QueryRunner对象
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

       List<Student> list =  qr.query("select * from sunxiaozhe", new ResultSetHandler<List<Student>>() {
            //当query方法执行select语句后，将结果以参数形式传递
            public List<Student> handle(ResultSet resultSet) throws SQLException {

                List<Student> list = new ArrayList<Student>();
                while (resultSet.next()){
                    Student student = new Student();
                    student.setId(resultSet.getInt(1));
                    student.setUsername(resultSet.getString(2));
                    student.setPassword(resultSet.getString(3));
                    student.setEmail(resultSet.getString(4));
                    student.setBirthday(resultSet.getDate(5));
                    list.add(student);
                }
                return list;
            }
        });
            for (Student student:list){
                System.out.println(student);

            }
    }*/
/*
查询方法
 */
    public  void testSelect() throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        List<Student> list = qr.query("select * from sunxiaozhe where username=?",new BeanListHandler<Student>(Student.class),"sdsd");
        for (Student student:list){
            System.out.println(student);

        }

    }
/**
 * 插入方法
 */

    public void testInsert() throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

        qr.update("insert into sunxiaozhe(username,password,email,birthday) values(?,?,?,?)","sunxiaozhe","2222","sxz@163.com","2018-10-20");

    }
    /**
     * 修改方法
     */
    public void testUpdate() throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        qr.update("update sunxiaozhe set username=?,password=? where id=?","sunxiaozhe","4444",1);

    }
    /**
     * 删除方法
     */
    public void testDelete() throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        qr.update("delete from sunxiaozhe where id=?",1);
    }


}
