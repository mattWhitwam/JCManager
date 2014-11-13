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
import za.co.dwarfsun.jcmanager.domain.Attrib;
import za.co.dwarfsun.jcmanager.services.AttribService;
/**
 *
 * @author Matthew
 */
@RestController
@RequestMapping(value = "api/attrib")
public class AttribRestController {
    @Autowired
    AttribService attribService;
    
    boolean delEnabled = false;
    
    @RequestMapping(value = "create",method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody Attrib attrib) {
        attribService.persist(attrib);
        return "Attrib: " + attrib.getDescription() + " created...";
    }
    
    @RequestMapping(value = "update",method = RequestMethod.PUT)
    @ResponseBody
    public String update(@RequestBody Attrib attrib) {
        attribService.merge(attrib);
        return "Attrib: " + attrib.getDescription() + " updated...";
    }    

    @RequestMapping(value = "id/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Attrib getAttrib(@PathVariable Long id) {
        return attribService.find(id);
    }

    @RequestMapping(value = "getAttribs", method = RequestMethod.GET)
    @ResponseBody
    public List<Attrib> getAttribs(){
        return attribService.findAll();
    }
    
    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String delete(@RequestBody Attrib attrib) {
        if (delEnabled) {
            attribService.remove(attrib);
            return "Attrib: " + attrib.getDescription() + " deleted...";
        }
        else {
            return "Attrib: " + attrib.getDescription() + " could not be deleted...";
        }
    }
}
