/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.dwarfsun.jcmanager.presentation.rest;

import za.co.dwarfsun.jcmanager.domain.JcUser;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import za.co.dwarfsun.jcmanager.services.JcUserService;
/**
 *
 * @author Matthew
 */
@Controller
public class JcUserRestController {
    @Autowired
    private JcUserService jcUserService;

     /*, method = RequestMethod.POST, produces = "application/json" */
    @RequestMapping("demo")
    @ResponseBody
    public HttpEntity<String> demo() {
      return new ResponseEntity<String>("loclalhost:8084", HttpStatus.OK);
      /*
        System.out.println("Actually doing something!!!!");
        ResponseEntity<String> x = new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        return x;
      */
    }
    /*
    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody JcUser jcUser) {
        System.out.println(" Create the Called ");
        return "";
    }*/
}
