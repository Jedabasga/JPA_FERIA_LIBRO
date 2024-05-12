package com.uptc.frmw.models;

import jakarta.persistence.*;
import java.util.List;
import java.util.Date;
@Entity
@Table(name ="COMPRAS")
public class Bill {
    @Id
    @Column(name ="ID_COMPRA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "billgen")
    @SequenceGenerator(name = "billgen", sequenceName = "COMPRAS_SEQ",allocationSize = 1)
    private long idBill;
    @Column(name="ID_PERSONA",insertable=false,updatable=false)
    private long idPerson;
    @Column(name="FECHA")
    private Date dateBill;
    @ManyToOne
    @JoinColumn(name = "ID_PERSONA", nullable = false)
    private Person person;
    @OneToMany(mappedBy = "bill")
    private List<BillDetail> billDetails;
    public Bill() {
    }

    public long getIdBill() {
        return idBill;
    }

    public void setIdBill(long id_bill) {
        this.idBill = id_bill;
    }

    public long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(long id_person) {
        this.idPerson = id_person;
    }

    public Date getDateBill() {
        return dateBill;
    }

    public void setDateBill(Date date_bill) {
        this.dateBill = date_bill;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "idBill=" + idBill +
                ", idPerson=" + idPerson +
                ", dateBill=" + dateBill +
                '}';
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<BillDetail> getBillDetails() {
        return billDetails;
    }

    public void setBillDetails(List<BillDetail> billDetails) {
        this.billDetails = billDetails;
    }
}
