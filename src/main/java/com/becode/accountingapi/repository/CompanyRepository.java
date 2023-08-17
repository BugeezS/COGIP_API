package com.becode.accountingapi.repository;

import com.becode.accountingapi.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {
}
