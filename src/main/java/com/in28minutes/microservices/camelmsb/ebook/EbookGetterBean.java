package com.in28minutes.microservices.camelmsb.ebook;

import com.in28minutes.microservices.camelmsb.ebook.output.EbookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EbookGetterBean {

    @Autowired
    EbookRepository ebookRepository;

    public List<EbookResponse> getEbooks(){
        List<Ebook> ebooks = ebookRepository.findAll();
        return ebooks.stream().map(EbookResponse::new).collect(Collectors.toList());
    }
}
