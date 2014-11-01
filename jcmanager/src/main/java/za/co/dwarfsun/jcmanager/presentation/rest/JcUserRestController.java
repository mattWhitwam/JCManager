/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.dwarfsun.jcmanager.presentation.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *
 * @author Matthew
 */
@RestController
public class JcUserRestController {
    
    @RequestMapping(value="/")
    public String demo() {
      return "Hello Matt";
    }
}
