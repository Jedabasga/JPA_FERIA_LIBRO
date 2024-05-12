package com.uptc.frmw.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "NACIONALIDADES")
public class Nationality {
    @Id
    @Column(name = "ID_NACIONALIDAD")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nationalitygen")
    @SequenceGenerator(name = "nationalitygen",sequenceName = "NACIONALIDADES_SEQ", allocationSize = 1)
    private long id;
    @Column(name = "NOMBRE_NACIONALIDAD")
    private String nameNationality;
    @OneToMany(mappedBy = "nationality")
    private List<NationalityPerson> nationalitiesPeople;


    public Nationality() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameNationality() {
        return nameNationality;
    }

    public void setNameNationality(String nameNationality) {
        this.nameNationality = nameNationality;
    }

    public List<NationalityPerson> getNationalitiesPeople() {
        return nationalitiesPeople;
    }

    public void setNationalitiesPeople(List<NationalityPerson> nationalitiesPeople) {
        this.nationalitiesPeople = nationalitiesPeople;
    }

    @Override
    public String toString() {
        return "Nationality{" +
                "id=" + id +
                ", nameNationality='" + nameNationality + '\'' +
                '}';
    }
}
