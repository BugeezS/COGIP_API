package com.becode.accountingapi.repository;

import com.becode.accountingapi.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,Long> {
}
