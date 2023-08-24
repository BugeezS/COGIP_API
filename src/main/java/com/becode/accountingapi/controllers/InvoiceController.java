package com.becode.accountingapi.controllers;

import com.becode.accountingapi.models.Company;
import com.becode.accountingapi.models.Invoice;
import com.becode.accountingapi.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {
    private final InvoiceService invoiceService;
    @Autowired
    public InvoiceController(InvoiceService invoiceService){
        this.invoiceService = invoiceService;
    }
    @GetMapping
    public ResponseEntity<List<Invoice>> getAllInvoices(){
        List<Invoice> invoices = invoiceService.getAllInvoices();
        return ResponseEntity.ok(invoices);
    }
}
