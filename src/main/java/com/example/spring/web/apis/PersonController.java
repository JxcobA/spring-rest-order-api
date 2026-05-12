package com.example.spring.web.apis;

import com.example.spring.web.models.Person;
import com.example.spring.web.services.PersonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// @RestController - bean will be created in the spring container
// This bean is capable to handle HTTP requests and HTTP responses (Java Objects)
// This bean converts java object into JSON before sending it over the network
// The first / in the URL will be the root url of the application: http://localhost:9000
@RestController
@RequestMapping("/api/v1/") // RequestMapping - HTTP Request - base URL
public class PersonController {
    public final Logger log = LogManager.getLogger();
    // Wire the dependent object  - PersonService
    PersonService service;
    Map<Integer, Person> persons = new HashMap<>();

    // PersonService object will be injected in the constructor
    public PersonController(PersonService personService){
        log.info("PersonController Created..");
        this.service = personService;
        persons.put(1, new Person(1, "person1", 34));
        persons.put(2, new Person(2, "person2", 32));
        persons.put(3, new Person(3, "person3", 33));
    }

   // In REST Guidelines - @GETMapping will be mapped with GET HTTP Method
   @GetMapping("/users") // http://localhost:9000/api/v1/users
   @ResponseBody  // Generate the HTTP Response packet : HTTP Response object: Header and Body
   public List<String> getPersonNames(){
    List<String> names = this.service.getNames();
    return names; // REST Controller will create the HTTP RESPONSE and add the list of names as JSON List
   }

   // GET Method that will accept the data passed with the URL
    @GetMapping("/users/{name}") // http://localhost:9000/api/v1/users/john
    public String findName(@PathVariable  String name){ // {name} => name
       log.info("Data passed on the url " + name);
        String result = this.service.find(name);
        return "Found name = " + result;
    }

    // GETMapping to return the size of the list
    @GetMapping("/users/len")
    public int getListSize(){
      return this.service.size();
    }

    @GetMapping("/skills")
    public Map<String, String> getMap(){
        Map<String,String> map = new HashMap<>();
        map.put("1","Electronics");
        map.put("2","Computers");
        map.put("3","Engineering");
        map.put("4","Software Engineering");
        return map;
    }

  @GetMapping("/greet")
   public ResponseEntity<String> getMessage(){
        // ResponseEntity creates a HTTP Response object to be sent over the network
        //return ResponseEntity.status(200).body(new String("Hello World!"));
      return ResponseEntity.ok("Hello World from greet"); // Status message - OK (200)
   }

   @GetMapping("/numbers")
   public ResponseEntity<List<Integer>> getList(){
        List<Integer> list = new ArrayList<>();
        list.add(10); // new Integer(10)
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);
        list.add(70);
        list.add(80);
        return ResponseEntity.ok(list);
   }

   // ResponseEntity represents HTTP Response packet (HEADER + BODY)
    // post endpoint : receive the data as JSON from the user, response - send the newly created object + status code - 201
   @PostMapping("/users")
   public ResponseEntity<Object> addPersonDetails(@RequestBody String name){
        if(name == null)
        {
            return ResponseEntity.badRequest().build(); // status code for bad request - 400
        }
        // call to the PerersonService addName()
        this.service.addName(name);
        return ResponseEntity.status(201).body(name); // String is the subclass of Object class
   }
// @RequestBody - read the JSON data from HTTP Request body and convert into Person object
// {"name":"person1", "age": 36} => person = new Person("person1", 36)
  @PostMapping("/persons") // post endpoints - api/v1/persons
   public ResponseEntity<Person> getPersonObject(@RequestBody Person person){
        log.info("Person information : " + person); // person.toString()
       return ResponseEntity.status(HttpStatus.CREATED).body(person);
   }

// Delete endpoint
// Receive the data on the URL /delete/name/{name}, no data to be sent in the response body, only send status code
@DeleteMapping("/users/{name}")
public ResponseEntity<HttpStatus> deleteNameFromList(@PathVariable String name){
        if(name == null){
            return ResponseEntity.badRequest().build();
        }
        this.service.deleteName(name);
        return ResponseEntity.status(200).build();
}

// Map - 1, {1, "person1" 34}, 2, {2, "person2", 32}
@GetMapping("/persons")
public ResponseEntity<Map<Integer, Person>> getPersonMap(){
        return ResponseEntity.ok(persons);
}

// Put Mapping end points
// Modify a record whose id = 1
// Request - data to be on the URL /users/{id} + JSON object in the request body
// Response - Newly modified object in the response body + status code - 200 OK
 // @RequestBody {"name": "John", "age": 34}  => person = new Person(1, "John", 34)
@PutMapping("/persons/{id}")
public ResponseEntity<Person> updatePersonDetails(@PathVariable Integer id, @RequestBody Person person){
   Person pObj = null;
   pObj = persons.get(id);
   if(person == null){
       return ResponseEntity.badRequest().build();
   }
   else {
       pObj.setId(id);
       pObj.setName(person.getName());
       pObj.setAge(person.getAge());
       persons.put(id, pObj); // On the key id, it will add the object
       return ResponseEntity.status(HttpStatus.OK).body(pObj);
   }
}


}



















