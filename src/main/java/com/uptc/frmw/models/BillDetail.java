package com.uptc.frmw.models;

import com.uptc.frmw.models.key.BookKey;
import jakarta.persistence.*;

@Entity
@Table(name="DETALLES_COMPRA")
public class BillDetail {
    @Id
    @Column(name="ID_DETALLE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detailgen")
    @SequenceGenerator(name = "detailgen", sequenceName = "DETALLES_COMPRA_SEQ",allocationSize = 1)
    private long idDetail;
    @Column(name="ID_COMPRA",insertable=false, updatable=false)
    private long idBill;
    @Column(name="ID_LIBRO",insertable=false, updatable=false)
    private long idBook;
    @Column(name = "ISBN",insertable = false,updatable = false)
    private String isbn;
    @Column(name="CANTIDAD")
    private long cuantity;
    @ManyToOne
    @JoinColumn(name = "ID_COMPRA",nullable = false)
    private Bill bill;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "ID_LIBRO",nullable = false),
            @JoinColumn(name = "ISBN",nullable = false)
    })

    private Book books;
    public BillDetail() {
    }

    public long getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(long idDetail) {
        this.idDetail = idDetail;
    }

    public long getIdBill() {
        return idBill;
    }

    public void setIdBill(long idBill) {
        this.idBill = idBill;
    }

    public long getIdBook() {
        return idBook;
    }

    public void setIdBook(long idBook) {
        this.idBook = idBook;
    }

    public long getCuantity() {
        return cuantity;
    }

    public void setCuantity(long cuantity) {
        this.cuantity = cuantity;
    }

    @Override
    public String toString() {
        return "BillDetail{" +
                "idDetail=" + idDetail +
                ", idBill=" + idBill +
                ", idBook=" + idBook +
                ", cuantity=" + cuantity +
                '}';
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Book getBooks() {
        return books;
    }

    public void setBook(Book book) {
        this.books = book;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
