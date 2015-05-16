///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package ServiceClasses;
//
//import DAO.BookDao;
//import POJOS.Books;
//import java.util.List;
//
///**
// *
// * @author Farjad
// */
public class BookService {
    
}
//
//
//    private static BookDao bookDao;
//
//
//    public BookService() {
//
//        bookDao = new BookDao();
//
//    }
//
//
//    public void persist(Books entity) {
//
//        bookDao.openCurrentSessionwithTransaction();
//
//        bookDao.persist(entity);
//
//        bookDao.closeCurrentSessionwithTransaction();
//
//    }
//
//
//    public void update(Books entity) {
//
//        bookDao.openCurrentSessionwithTransaction();
//
//        bookDao.update(entity);
//
//        bookDao.closeCurrentSessionwithTransaction();
//
//    }
//
//
//    public Books findById(int id) {
//
//        bookDao.openCurrentSession();
//
//        Books book = bookDao.findById(id);
//
//        bookDao.closeCurrentSession();
//
//        return book;
//
//    }
//
//
//    public void delete(int id) {
//
//        bookDao.openCurrentSessionwithTransaction();
//
//        Books book = bookDao.findById(id);
//
//        bookDao.delete(book);
//
//        bookDao.closeCurrentSessionwithTransaction();
//
//    }
//
//
//    public List<Books> findAll() {
//
//        bookDao.openCurrentSession();
//
//        List<Books> books = bookDao.findAll();
//
//        bookDao.closeCurrentSession();
//
//        return books;
//
//    }
//
//
//    public void deleteAll() {
//
//        bookDao.openCurrentSessionwithTransaction();
//
//        bookDao.deleteAll();
//
//        bookDao.closeCurrentSessionwithTransaction();
//
//    }
//
//
//    public BookDao bookDao() {
//
//        return bookDao;
//
//    }
//
//}