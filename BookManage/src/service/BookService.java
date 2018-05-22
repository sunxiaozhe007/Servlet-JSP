package service;

import dao.BookDao;
import domain.Book;

import java.sql.SQLException;
import java.util.List;

public class BookService {
    //显示所有信息
    BookDao bookDao = new BookDao();
    public List<Book> list() throws SQLException {
        return bookDao.list();
    }
    //添加信息
    public void add(Book book) throws SQLException {
        bookDao.add(book);
    }

    //根据id返回信息
    public Book findId(String id) throws SQLException {
        return bookDao.findId(id);
    }

    //修改信息
    public void update(Book book) throws SQLException {
        bookDao.update(book);
    }

    //删除信息
    public void delete(String id) throws SQLException {
        bookDao.delete(id);
    }

    //批量删除
    public void delAll(String[] ids) throws SQLException {
        bookDao.delAll(ids);
    }

    //条件查询
    public List<Book> search(String id, String category, String name, String minprice, String maxprice) throws SQLException {
        return bookDao.search(id,category,name,minprice,maxprice);
    }
}
