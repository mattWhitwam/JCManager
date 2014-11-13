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
import za.co.dwarfsun.jcmanager.domain.JcRole;
import za.co.dwarfsun.jcmanager.services.JcRoleService;
/**
 *
 * @author Matthew
 */
@RestController
@RequestMapping(value = "api/jcRole")
public class JcRoleRestController {
    @Autowired
    JcRoleService jcRoleService;
    
    boolean delEnabled = false;
    
    @RequestMapping(value = "create",method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody JcRole jcRole) {
        jcRoleService.persist(jcRole);
        return "JcRole: " + jcRole.getDescription() + " created...";
    }
    
    @RequestMapping(value = "update",method = RequestMethod.PUT)
    @ResponseBody
    public String update(@RequestBody JcRole jcRole) {
        jcRoleService.merge(jcRole);
        return "JcRole: " + jcRole.getDescription() + " updated...";
    }    

    @RequestMapping(value = "id/{id}",method = RequestMethod.GET)
    @ResponseBody
    public JcRole getJcRole(@PathVariable Long id) {
        return jcRoleService.find(id);
    }

    @RequestMapping(value = "getJcRoles", method = RequestMethod.GET)
    @ResponseBody
    public List<JcRole> getJcRoles(){
        return jcRoleService.findAll();
    }
    
    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String delete(@RequestBody JcRole jcRole) {
        if (delEnabled) {
            jcRoleService.remove(jcRole);
            return "JcRole: " + jcRole.getDescription() + " deleted...";
        }
        else {
            return "JcRole: " + jcRole.getDescription() + " could not be deleted...";
        }
    }
}
