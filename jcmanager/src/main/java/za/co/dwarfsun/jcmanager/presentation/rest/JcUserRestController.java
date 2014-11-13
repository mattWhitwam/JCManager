/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.dwarfsun.jcmanager.presentation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import za.co.dwarfsun.jcmanager.domain.JcUser;
import za.co.dwarfsun.jcmanager.services.JcUserService;
/**
 *
 * @author Matthew
 */
@RestController
@RequestMapping(value = "api/jcUser")
public class JcUserRestController {
    @Autowired
    JcUserService jcUserService;
    
    boolean delEnabled = false;
    
    @RequestMapping(value = "create",method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody JcUser jcUser) {
        jcUserService.persist(jcUser);
        return "JcUser: " + jcUser.getUserName() + " created...";
    }
    
    @RequestMapping(value = "update",method = RequestMethod.PUT)
    @ResponseBody
    public String update(@RequestBody JcUser jcUser) {
        jcUserService.merge(jcUser);
        return "JcUser: " + jcUser.getUserName() + " updated...";
    }    

    @RequestMapping(value = "id/{id}",method = RequestMethod.GET)
    @ResponseBody
    public JcUser getJcUser(@PathVariable Long id) {
        return jcUserService.find(id);
    }

    @RequestMapping(value = "getJcUsers", method = RequestMethod.GET)
    @ResponseBody
    public List<JcUser> getJcUsers(){
        return jcUserService.findAll();
    }
    
    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String delete(@RequestBody JcUser jcUser) {
        if (delEnabled) {
            jcUserService.remove(jcUser);
            return "JcUser: " + jcUser.getUserName() + " deleted...";
        }
        else {
            return "JcUser: " + jcUser.getUserName() + " could not be deleted...";
        }
    }
}
