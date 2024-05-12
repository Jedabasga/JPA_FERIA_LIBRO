package com.uptc.frmw.models;

import com.uptc.frmw.models.key.BookKey;
import jakarta.persistence.*;

@Entity
@Table(name="EDICIONES")
public class Edition {

    @Column(name = "ANIO_PUBLICACION")
    private int publicatedYear;
    @Column(name = "NUMERO")
    private long number;
    @Column(name = "DESCRIPCION")
    private String description;

    @OneToOne
    @MapsId
    @JoinColumns({
            @JoinColumn(name="ID_LIBRO",nullable = false),
            @JoinColumn(name = "ISBN",nullable = false)
    })
    private Book book;
    @EmbeddedId
    private BookKey bookKey;
    public Edition() {}


    public int getPublicatedYear() {
        return publicatedYear;
    }

    public void setPublicatedYear(int publicatedYear) {
        this.publicatedYear = publicatedYear;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "Edition{" +
                ", publicatedYear=" + publicatedYear +
                ", Number=" + number +
                ", description='" + description + '\'' +
                '}';
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
