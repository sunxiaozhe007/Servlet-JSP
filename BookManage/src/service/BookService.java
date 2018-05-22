package service;

import dao.BookDao;
import domain.Book;

import java.sql.SQLException;
import java.util.List;

public class BookService {
    //��ʾ������Ϣ
    BookDao bookDao = new BookDao();
    public List<Book> list() throws SQLException {
        return bookDao.list();
    }
    //�����Ϣ
    public void add(Book book) throws SQLException {
        bookDao.add(book);
    }

    //����id������Ϣ
    public Book findId(String id) throws SQLException {
        return bookDao.findId(id);
    }

    //�޸���Ϣ
    public void update(Book book) throws SQLException {
        bookDao.update(book);
    }

    //ɾ����Ϣ
    public void delete(String id) throws SQLException {
        bookDao.delete(id);
    }

    //����ɾ��
    public void delAll(String[] ids) throws SQLException {
        bookDao.delAll(ids);
    }

    //������ѯ
    public List<Book> search(String id, String category, String name, String minprice, String maxprice) throws SQLException {
        return bookDao.search(id,category,name,minprice,maxprice);
    }
}
