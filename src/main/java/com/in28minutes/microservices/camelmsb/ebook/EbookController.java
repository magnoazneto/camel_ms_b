package com.in28minutes.microservices.camelmsb.ebook;

import com.in28minutes.microservices.camelmsb.ebook.input.Livro;
import com.in28minutes.microservices.camelmsb.ebook.output.EbookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/ebooks")
public class EbookController {

    @Autowired
    EbookRepository ebookRepository;

    @GetMapping("/{minValue}")
    public Set<EbookResponse> findEbooksByMinValue(
            @PathVariable BigDecimal minValue
            ){
        Set<Ebook> ebooks = ebookRepository.findByMinValue(minValue);
        return ebooks.stream().map(EbookResponse::new).collect(Collectors.toSet());
    }
}
