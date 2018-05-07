package service;

import dao.StudentDao;
import domain.Student;

import java.sql.SQLException;
import java.util.List;

public class ServiceStudent {
    StudentDao studentDao = new StudentDao();
    //显示所有信息
    public List<Student> listStudent() throws SQLException {
        return studentDao.listStudent();
    }
    //查找信息
    public Student findStudent(String num) throws SQLException {
        return studentDao.findStudent(num);
    }
    public Student findId(String id) throws SQLException {
        return studentDao.findId(id);
    }
    //添加信息
    public void addStudent(Student student) throws SQLException {
        studentDao.addStudent(student);
    }
    //删除信息
    public void deleteStudent(String num) throws SQLException {
        studentDao.delete(num);
    }
    //修改信息
    public void updateStudent(Student student) throws SQLException {
        studentDao.updateStudent(student);

    }
}
