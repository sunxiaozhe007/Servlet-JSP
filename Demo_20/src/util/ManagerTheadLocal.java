package util;

import java.sql.Connection;
import java.sql.SQLException;

public class ManagerTheadLocal {

    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    //得到一个连接
    public static Connection getConnection(){
        //从当前线程中取出一个连接
        Connection connection = tl.get();
        if (connection==null){
            //从池中取出一个
            connection = C3P0Util.getConnection();
            //把connection对象放入当前线程
            tl.set(connection);
        }
        return connection;
    }
    //开始事物
    public static void startTransacation(){

        try {
            //从当前线程取出连接，开始事物
            getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //提交事物
    public  static void commit(){
        try {
            getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //事物回滚
    public static void rollback() {
        try {
            getConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //把连接放回池中
    public static void close(){
        try {
            getConnection().close();
            //把当前线程对象中的connection移除
            tl.remove();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
