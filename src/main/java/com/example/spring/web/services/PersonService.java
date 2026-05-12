package com.example.spring.web.services;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// Spring container will create the bean (object) of PersonService and manage it.
@Service
public class PersonService {
    public final Logger log = LogManager.getLogger();

    List<String> names; // instance-level property
    // names

    public PersonService() {
        log.info("PersonService constructor");
        this.names = new ArrayList<>();
        this.names.add("John");
        this.names.add("Jill");
        // names = []
    }

    public void  addName(String name) {

        this.names.add(name); // names["john", "Jill"]
    }

    public int size(){
        return this.names.size(); // 2
    }

    public List<String> getNames() {
        log.info("Retrieve the list");
        return names; // ["john", "jill"]
    }

    public void deleteName(String name){
        boolean result = this.names.contains(name);
        if(result){
            this.names.remove(name);
        }
    }

    public String find(String search){
        for( String str : names){
            if(str.toLowerCase().equals(search)){
                log.debug("search value = "+ search);
                return str;
            }
        }
        return null;
    }


}
