package dao;

import domain.Book;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.C3P0Util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

    /**
     * �б����ʾ����
     */
    public List<Book> list() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        return queryRunner.query("select * from book",new BeanListHandler<Book>(Book.class));
    }

    /**
     * �����Ϣ
     */
    public void add(Book book) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        queryRunner.update("insert into book values(?,?,?,?,?,?)",book.getId(),book.getName(),book.getPrice(),book.getPnum(),book.getCategory(),book.getDesciption());
    }
    /**
     * id������Ϣ
     */
    public Book findId(String id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        return queryRunner.query("select * from book where id=?",new BeanHandler<Book>(Book.class),id);
    }


    /**
     * �޸���Ϣ
     * @param book
     */
    public void update(Book book) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        queryRunner.update("update book set name=?,price=?,pnum=?,category=?,desciption=? where id=?",
                book.getName(),book.getPrice(),book.getPnum(),book.getCategory(),book.getDesciption(),book.getId());
    }

    /**
     * ɾ����Ϣ
     * @param id
     */
    public void delete(String id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        queryRunner.update("delete from book where id=?",id);
    }

    /**
     * ����ɾ��
     * @param ids
     */

    public void delAll(String[] ids) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        Object[][] params = new Object[ids.length][];
        for (int i = 0; i < params.length; i++ ){
            params[i] = new Object[]{ids[i]};//ѭ����ÿ��һά�����е�Ԫ�ظ�ֵ��ֵ��id
        }
        queryRunner.batch("delete from book where id=?",params);
    }

    /**
     * ��������ѯ
     * @param id
     * @param category
     * @param name
     * @param minprice
     * @param maxprice
     * @return
     */
    public List<Book> search(String id, String category, String name, String minprice, String maxprice) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
        String sql = "select * from book where 1=1";

        List list = new ArrayList();

        if (!"".equals(id.trim())){
            sql+=" and id like ?";
            list.add("%"+id+"%");
        }
        if (!"".equals(category.trim())){
            sql+=" and category=?";
            list.add(category);

        }
        if (!"".equals(name.trim())){
            sql+=" and name like ?";
            list.add("%"+name+"%");

        }
        if (!"".equals(minprice.trim())){
            sql+=" and price>?";
            list.add(minprice);

        }
        if (!"".equals(maxprice.trim())){
            sql+=" and price<?";
            list.add(maxprice);
        }
        return queryRunner.query(sql,new BeanListHandler<Book>(Book.class),list.toArray());
    }
}
