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

    public void deleteStudent(String id){

         studentDao.delStudent(id);
    }
}
