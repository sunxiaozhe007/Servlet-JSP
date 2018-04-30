package service;

import dao.StudentDaoImpl;
import domain.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl {
    //创建一个Dao对象
    StudentDaoImpl studentDao = new StudentDaoImpl();
    public List<Student> findAllStudent(){
        try {
            return studentDao.findAllStudent();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //添加图书
    public void addStudent(Student student) throws SQLException {
        studentDao.addStudent(student);
    }

    public Student findId(String id){
        try {
            return studentDao.findId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //删除图书
    public void deleteStudent(String id){

         studentDao.deleteStudent(id);
    }

    //修改图书信息

    public void updateStudent(Student student,String id) throws SQLException {
        studentDao.updateStudent(student,id);
    }
}
