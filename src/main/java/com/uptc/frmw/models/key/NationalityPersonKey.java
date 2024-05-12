package com.uptc.frmw.models.key;

import com.uptc.frmw.models.Nationality;
import com.uptc.frmw.models.Person;

import java.io.Serializable;

public class NationalityPersonKey implements Serializable {
    private Nationality nationality;
    private Person person;
    public NationalityPersonKey() {
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

    @Override
    public String toString() {
        return "NationalityPersonKey{" +
                "nationality=" + nationality +
                ", person=" + person +
                '}';
    }
}
