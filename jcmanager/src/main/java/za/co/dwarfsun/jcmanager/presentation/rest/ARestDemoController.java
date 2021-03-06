/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.dwarfsun.jcmanager.presentation.rest;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import za.co.dwarfsun.jcmanager.domain.Client;
import za.co.dwarfsun.jcmanager.services.ClientService;
/**
 *
 * @author Matthew
 */
@RestController
@RequestMapping(value = "api/demo")
public class ARestDemoController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    ClientService clientService;
    

    public class HelloWorld {
        private final long id;
        private final String content;
        public HelloWorld(long id, String content) {
            this.id = id;
            this.content = content;
        }
        public long getId(){
            return id;
        }
        public String getContent(){
            return content;
        }
    }
    
    @RequestMapping(value="/clients")
    public List<Client> clients() {
        return clientService.findAll();
    }
    
    @RequestMapping(value="/helloworld")
    public HelloWorld helloworld(@RequestParam(value="name", defaultValue="World") String name) {
        return new HelloWorld(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping(value="/gotogoogle")
    public String test() {
        return "<meta http-equiv=\"refresh\" content=\"0; url=http://www.google.co.za\" />";
    }
}
