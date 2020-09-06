package com.microservicesintro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservicesintro.entity.Exchange;

@Repository
public interface ExchangeValueRepository extends JpaRepository<Exchange, Long>{

}