package com.in28minutes.microservices.camelmsb.ebook;

import com.in28minutes.microservices.camelmsb.ebook.input.EbookMQMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
public class EbookJPAProcessor {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PersistenceContext
    EntityManager manager;

    @Transactional
    public void saveOnDatabase(EbookMQMessage ebook){
        logger.info("Saving value of ebook = {}", ebook);
        Ebook newEbook = ebook.toModel();
        manager.persist(newEbook);
    }
}

