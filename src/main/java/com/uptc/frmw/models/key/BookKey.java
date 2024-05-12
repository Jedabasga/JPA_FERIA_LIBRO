package com.uptc.frmw.models.key;



import jakarta.persistence.Embeddable;

import java.io.Serializable;
@Embeddable
public class BookKey implements Serializable {
    private long  id;
    private String isbn;
    public BookKey() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "BookKey{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
