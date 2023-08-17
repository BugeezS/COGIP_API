package com.becode.accountingapi.repository;

import com.becode.accountingapi.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Long> {
}
