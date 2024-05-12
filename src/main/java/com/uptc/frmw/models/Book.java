package com.uptc.frmw.models;

import com.uptc.frmw.models.key.BookKey;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "LIBROS")
@IdClass(BookKey.class)
public class Book {
    @Id
    @Column(name = "ID_LIBRO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookgen")
    @SequenceGenerator(name = "bookgen", sequenceName = "LIBROS_SEQ",allocationSize = 1)
    private long id;
    @Id
    @Column(name="ISBN")
    private String isbn;
    @Column(name ="TITULO")
    private String title;
    @Column(name = "PRECIO")
    private double price;
    @OneToOne(mappedBy = "book",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private Edition edition;
    @OneToMany(mappedBy = "books")
    private List<BillDetail> billDetails;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "autor_libro",
            joinColumns = {
                    @JoinColumn(name = "ID_LIBRO"),
                    @JoinColumn(name = "ISBN")},
            inverseJoinColumns = @JoinColumn(name = "ID_AUTOR")
    )
    private List<Person>authors;
    public Book() {
    }

    public Book(long id, String title, double price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn=" + isbn +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }

    public Edition getEdition() {
        return edition;
    }

    public void setEdition(Edition edition) {
        this.edition = edition;
    }

    public List<BillDetail> getBillDetails() {
        return billDetails;
    }

    public void setBillDetails(List<BillDetail> billDetails) {
        this.billDetails = billDetails;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<Person> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Person> authors) {
        this.authors = authors;
    }
}
