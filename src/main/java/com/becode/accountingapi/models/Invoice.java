package com.becode.accountingapi.models;

import jakarta.persistence.*;

@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "invoice_company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "invoice_contact_id")
    private Contact contact;

    // Getters
    public Long getId() {
        return id;
    }

    public Company getCompany() {
        return company;
    }

    public Contact getContact() {
        return contact;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
