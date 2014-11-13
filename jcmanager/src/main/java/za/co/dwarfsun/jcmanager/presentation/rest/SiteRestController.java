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
import za.co.dwarfsun.jcmanager.domain.Site;
import za.co.dwarfsun.jcmanager.services.SiteService;
/**
 *
 * @author Matthew
 */
@RestController
@RequestMapping(value = "api/site")
public class SiteRestController {
    @Autowired
    SiteService siteService;
    
    boolean delEnabled = false;
    
    @RequestMapping(value = "create",method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody Site site) {
        siteService.persist(site);
        return "Site: " + site.getName()+ " created...";
    }
    
    @RequestMapping(value = "update",method = RequestMethod.PUT)
    @ResponseBody
    public String update(@RequestBody Site site) {
        siteService.merge(site);
        return "Site: " + site.getName() + " updated...";
    }    

    @RequestMapping(value = "id/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Site getSite(@PathVariable Long id) {
        return siteService.find(id);
    }

    @RequestMapping(value = "getSites", method = RequestMethod.GET)
    @ResponseBody
    public List<Site> getSites(){
        return siteService.findAll();
    }
    
    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String delete(@RequestBody Site site) {
        if (delEnabled) {
            siteService.remove(site);
            return "Site: " + site.getName() + " deleted...";
        }
        else {
            return "Site: " + site.getName() + " could not be deleted...";
        }
    }
}
