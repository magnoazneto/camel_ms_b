package com.in28minutes.microservices.camelmsb.ebook;

import com.in28minutes.microservices.camelmsb.ebook.output.EbookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EbookGetterByIdBean {

    @Autowired
    EbookRepository ebookRepository;

    public EbookResponse getEbookById(Long id){
        Optional<Ebook> possibleEbook = ebookRepository.findById(id);
        return new EbookResponse(possibleEbook.get());
    }
}
