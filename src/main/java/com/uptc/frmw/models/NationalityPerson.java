package com.uptc.frmw.models;

import com.uptc.frmw.models.key.NationalityPersonKey;
import jakarta.persistence.*;

@Entity
@Table(name = "NACIONALIDADES_PERSONAS")
@IdClass(NationalityPersonKey.class)
public class NationalityPerson {
    @Id
    @ManyToOne
    @JoinColumn(name = "ID_NACIONALIDAD")
    private Nationality nationality;
    @Id
    @ManyToOne
    @JoinColumn(name = "ID_PERSONA")
    private Person person;
    @Column(name = "ANIO")
    private int anio;

    public NationalityPerson() {
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "NationalityPerson{" +
                "nationality=" + nationality.getId() +
                ", person=" + person.getId() +
                ", anio=" + anio +
                '}';
    }
}
