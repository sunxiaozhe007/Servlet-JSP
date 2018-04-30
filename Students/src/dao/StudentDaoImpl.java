package dao;

import domain.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.C3P0Util;

import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl {

    /**
     * 查找所有学生
     * @return
     * @throws SQLException
     */
    public List<Student> findAllStudent() throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

        return qr.query("select * from student",new BeanListHandler<Student>(Student.class));
    }

    /**
     * 添加信息
     *
     */
    public void addStudent(Student student) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        qr.update("insert into student values(?,?,?,?)",student.getId(),student.getName(),student.getSex(),student.getSchool());
    }

    /**
     *根据id查找信息
     * @param id
     * @return
     */
    public Student findId(String id) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        return qr.query("select * from student where id=?",new BeanHandler<Student>(Student.class),id);
    }
    /**
     *根据id删除
     */
    public void deleteStudent(String id){
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        try {
            qr.update("delete from student where id=?",id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 修改图书信息
     */
    public void updateStudent(Student student, String id) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        qr.update("update student set id=?,name=?,sex=?,school=? where id=?",student.getId(),student.getName(),student.getSex(),student.getSchool(),"2333");
    }
}
