package dao;

import domain.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.C3P0Util;

import java.sql.SQLException;
import java.util.List;

public class StudentDao {

    /**
     * 显示所有信息
     */
    public List<Student> listStudent() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        return queryRunner.query("select * from student",new BeanListHandler<Student>(Student.class));
    }
    /**
     * 根据num查找信息
     */
    public Student findStudent(String num) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        return queryRunner.query("select * from student where num=?" ,new BeanHandler<Student>(Student.class),num);
    }
    /**
     * 根据ID查找信息
     */
    public Student findId(String id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        return queryRunner.query("select * from student where id=?" ,new BeanHandler<Student>(Student.class),id);
    }

    /**
     * 添加信息
     */
    public void addStudent(Student student) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        queryRunner.update("insert into student values(?,?,?,?,?,?)",student.getId(),student.getNum(),student.getName(),student.getSex(),student.getAge(),student.getSchool());
    }
    /**
     * 删除信息
     */
    public void delete(String num) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        queryRunner.update("delete from student where num=?" ,num);
    }
    /**
     * 修改信息
     */
    public void updateStudent(Student student) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        queryRunner.update("update student set num=?,name=?,sex=?,age=?,school=? where id=?",
                student.getNum(),student.getName(),student.getSex(),student.getAge(),student.getSchool(),student.getId());
    }
}
