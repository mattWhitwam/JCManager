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
import za.co.dwarfsun.jcmanager.domain.ContactPerson;
import za.co.dwarfsun.jcmanager.services.ContactPersonService;
/**
 *
 * @author Matthew
 */
@RestController
@RequestMapping(value = "api/contactPerson")
public class ContactPersonRestController {
    @Autowired
    ContactPersonService contactPersonService;
    
    boolean delEnabled = false;
    
    @RequestMapping(value = "create",method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody ContactPerson contactPerson) {
        contactPersonService.persist(contactPerson);
        return "ContactPerson: " + contactPerson.getDescription() + " created...";
    }
    
    @RequestMapping(value = "update",method = RequestMethod.PUT)
    @ResponseBody
    public String update(@RequestBody ContactPerson contactPerson) {
        contactPersonService.merge(contactPerson);
        return "ContactPerson: " + contactPerson.getDescription() + " updated...";
    }    

    @RequestMapping(value = "id/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ContactPerson getContactPerson(@PathVariable Long id) {
        return contactPersonService.find(id);
    }

    @RequestMapping(value = "getContactPersons", method = RequestMethod.GET)
    @ResponseBody
    public List<ContactPerson> getContactPersons(){
        return contactPersonService.findAll();
    }
    
    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String delete(@RequestBody ContactPerson contactPerson) {
        if (delEnabled) {
            contactPersonService.remove(contactPerson);
            return "ContactPerson: " + contactPerson.getDescription() + " deleted...";
        }
        else {
            return "ContactPerson: " + contactPerson.getDescription() + " could not be deleted...";
        }
    }
}
