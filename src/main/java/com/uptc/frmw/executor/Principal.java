package com.uptc.frmw.executor;

import com.uptc.frmw.conf.PersistenceUtil;
import com.uptc.frmw.models.*;
import com.uptc.frmw.models.key.BookKey;
import com.uptc.frmw.models.key.NationalityPersonKey;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NavigableMap;

public class Principal {
    public static void main(String[] args) {
        //EntityManager em = PersistenceUtil.getEntityManager();
        /*EntityManager em = PersistenceUtil.getEntityManager();
        NationalityPersonKey nationalityPersonKey = new NationalityPersonKey();
        Person person = em.getReference(Person.class,6003);
        Nationality nationality = em.getReference(Nationality.class,6000);
        BookKey bookKey = new BookKey();
        bookKey.setIsbn("a12364asqw");
        bookKey.setId(5000);
        Book book = em.getReference(Book.class,bookKey);
        nationalityPersonKey.setNationality(nationality);
        nationalityPersonKey.setPerson(person);
        //System.out.println(nationalityPersonKey);
        NationalityPerson nationalityPerson = em.find(NationalityPerson.class,nationalityPersonKey);
        System.out.println(nationalityPerson);
        System.out.println(book);*/
        findNationalityPerson();

    }
    public static void saveBookPerson(){
        EntityManager em = PersistenceUtil.getEntityManager();
        //BookKey bookKey = new BookKey();
        Person person = new Person();
        person.setName("David");
        person.setLastName("Bastidas");
        Book book = new Book();
        book.setTitle("Nuevo Libro");
        book.setIsbn("123456qwoe");
        book.setPrice(25000.55);
        List<Person> authors = new ArrayList<Person>();
        authors.add(person);

        book.setAuthors(authors);
        em.persist(book);
        /*bookKey.setId(5008);
        bookKey.setIsbn("a12364asqw");
        Edition edition = em.find(Edition.class, bookKey);
        Book book = em.find(Book.class,bookKey);
        em.remove(book);
        em.remove(edition);*/
        em.getTransaction().begin();
        em.getTransaction().commit();
    }
    public static void saveBookCascade(){
        EntityManager em = PersistenceUtil.getEntityManager();
        Book book = new Book();
        book.setTitle("Calendario");
        book.setPrice(5500);
        book.setIsbn("a12364asqw");
        Edition edition = new Edition();
        edition.setBook(book);
        edition.setDescription("1ra edicion");
        edition.setNumber(1);
        edition.setPublicatedYear(2024);
        book.setEdition(edition);
        em.persist(book);
        //em.persist(edition);
        em.getTransaction().begin();
        em.getTransaction().commit();
    }
    public static void findNationalityPerson(){
        EntityManager em = PersistenceUtil.getEntityManager();
        NationalityPersonKey nationalityPersonKey = new NationalityPersonKey();
        Person person = em.find(Person.class,6003);
        Nationality nationality = em.find(Nationality.class,6000);
        nationalityPersonKey.setNationality(nationality);
        nationalityPersonKey.setPerson(person);
        System.out.println(nationalityPersonKey);
        NationalityPerson nationalityPerson = em.find(NationalityPerson.class,nationalityPersonKey);
        System.out.println(nationalityPerson);
    }
    public static void insertNationalityPerson(){
        EntityManager em = PersistenceUtil.getEntityManager();
        Person person = new Person();
        person.setName("Pablo");
        person.setLastName("Clavo un Clavito");
        Nationality nationality = em.find(Nationality.class,6000);
        NationalityPerson nationalityPerson = new NationalityPerson();
        nationalityPerson.setNationality(nationality);
        nationalityPerson.setPerson(person);
        nationalityPerson.setAnio(2023);
        em.getTransaction().begin();
        em.persist(person);
        em.persist(nationalityPerson);
        em.getTransaction().commit();
    }
    public static void  insertNationality(){
        EntityManager em = PersistenceUtil.getEntityManager();
        Nationality nationality = new Nationality();
        nationality.setNameNationality("Colombiano");
        em.persist(nationality);
        em.getTransaction().begin();
        em.getTransaction().commit();
    }
    public static void ultimo(){
      EntityManager em = PersistenceUtil.getEntityManager();
       Book book = em.find(Book.class, 1);
        System.out.println(book);
        System.out.println(book.getBillDetails());
       Person person = new Person();
       person.setId(4);
       person.setName("Sebastian");
       person.setLastName("Mora");
       Book book2 = new Book();
       book2.setId(8);
       book2.setTitle("La iliada");
       book2.setPrice(123456.66);

       Edition edition = new Edition();
       edition.setBook(book2);
       edition.setNumber(1);
       edition.setDescription("edicion 1");
       edition.setBook(book2);
       Bill bill = new Bill();
       bill.setIdBill(104);
       bill.setIdPerson(4);
       bill.setPerson(person);
       bill.setDateBill(new Date());
       BillDetail billDetail = new BillDetail();
       billDetail.setBook(book2);
       billDetail.setBill(bill);
       billDetail.setCuantity(35);
       billDetail.setIdDetail(1);
       em.persist(person);
       em.persist(book2);
       em.persist(edition);
       em.persist(bill);
       em.persist(billDetail);
        em.getTransaction().begin();
        em.getTransaction().commit();
    }
    public static void probar(){
        EntityManager em = PersistenceUtil.getEntityManager();
        Person person = em.find(Person.class, 1);
        Bill bill = new Bill();
        bill.setIdBill(2);
        bill.setDateBill(new Date());
        bill.setIdPerson(person.getId());
        em.persist(bill);
       /* for (int i = 0; i <11 ; i++) {
            BillDetail billDetail = new BillDetail();
            billDetail.setBill(bill);
            billDetail.setIdDetail((long)i);
            Book book = em.find(Book.class, 1);
            billDetail.setBook(book);
            billDetail.setIdBook(2);
            billDetail.setCuantity((long)5+i);
            em.persist(billDetail);
        }*/
        em.getTransaction().begin();
        em.getTransaction().commit();

    }
    public static void consultabill(){
        EntityManager em = PersistenceUtil.getEntityManager();
        Bill bill = em.find(Bill.class, 1);
        System.out.println(bill);
        System.out.println(bill.getBillDetails());
        BillDetail billDetail = em.find(BillDetail.class, 10000);
        System.out.println(billDetail);
        System.out.println(billDetail.getBill());
    }
    public static void generaBill(){
        EntityManager em = PersistenceUtil.getEntityManager();
        Person person = em.find(Person.class, 1);
        for(int i=4;i<104;i++){
            Bill bill = new Bill();
            bill.setIdBill((long) i);
            bill.setDateBill(new Date());
            bill.setPerson(person);
            em.persist(bill);
        }
        em.getTransaction().begin();
        em.getTransaction().commit();
        em.close();
    }
    public static void bill(){
        EntityManager em = PersistenceUtil.getEntityManager();
        Bill bill = new Bill();
        bill.setIdBill(2);
        bill.setDateBill(new Date());
        Person person = em.find(Person.class,1);
        bill.setPerson(person);
        em.getTransaction().begin();
        em.persist(bill);
        em.getTransaction().commit();
        em.close();
    }
    public static void personaBill(){
        EntityManager em = PersistenceUtil.getEntityManager();
        Person person = em.find(Person.class, 1);
        System.out.println(person);
        System.out.println(person.getBills());
        Bill bill = em.find(Bill.class, 1);
        System.out.println(bill);
        System.out.println(bill.getPerson());
    }
    public static void edition(){

        EntityManager em = PersistenceUtil.getEntityManager();
        Book book = em.find(Book.class, 1);
        System.out.println(book);
        System.out.println(book.getEdition());
        Edition edition = em.find(Edition.class, 1);
        System.out.println(edition);
    }
    public static void delete(){
        EntityManager em = PersistenceUtil.getEntityManager();
        Book book = em.find(Book.class, 2);
        em.remove(book);
        em.getTransaction().begin();
        book.setTitle("Preicfes 2023");
        em.persist(book);
        em.getTransaction().commit();
    }
    public static void insert(){
        Book book2 = new Book();
        book2.setId(4);
        book2.setPrice(150022.31);
        book2.setTitle("Preicfes 2023");
        Book book3 = new Book(2,"La odisea",150999.99);
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(book2);
        book2.setTitle("Preicfes 2024");
        em.detach(book2);
        em.persist(book3);
        em.getTransaction().commit();
        em.close();
    }
    public static void find(){
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        Person person = em.find(Person.class, 1);
        Book book = em.find(Book.class, 1);
        Bill bill = em.find(Bill.class, 1);
        BillDetail detail = em.find(BillDetail.class, 10000);
        Edition edition = em.find(Edition.class, 1);
        System.out.println(person);
        System.out.println(book);
        System.out.println(bill);
        System.out.println(detail);
        System.out.println(edition);
    }
}
