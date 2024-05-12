package com.uptc.frmw.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name ="Personas")
public class Person {
    @Id
    @Column(name = "ID_PERSONA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persongen")
    @SequenceGenerator(name = "persongen", sequenceName = "PERSONAS_SEQ",allocationSize = 1)
    private long id;
    @Column(name="NOMBRES")
    private String name;
    @Column(name="APELLIDOS")
    private String lastName;
    @OneToMany(mappedBy = "person")
    private List<Bill> bills;
    @OneToMany(mappedBy = "person")
    private List<NationalityPerson> nationalityPerson;
    public Person() {
    }

    public List<NationalityPerson> getNationalityPerson() {
        return nationalityPerson;
    }

    public void setNationalityPerson(List<NationalityPerson> nationalityPerson) {
        this.nationalityPerson = nationalityPerson;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    //purba git

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }
}
