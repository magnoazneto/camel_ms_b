package com.in28minutes.microservices.camelmsb.ebook;

import com.in28minutes.microservices.camelmsb.ebook.input.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Set;

@Repository
public interface EbookRepository extends JpaRepository<Ebook, Long> {

    @Query(value = "select * from ebook where valor_ebook >= :minValue", nativeQuery = true)
    Set<Ebook> findByMinValue(BigDecimal minValue);
}
