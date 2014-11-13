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
import za.co.dwarfsun.jcmanager.domain.JobCardAttribute;
import za.co.dwarfsun.jcmanager.services.JobCardAttributeService;
/**
 *
 * @author Matthew
 */
@RestController
@RequestMapping(value = "api/jobCardAttribute")
public class JobCardAttributeRestController {
    @Autowired
    JobCardAttributeService jobCardAttributeService;
    
    boolean delEnabled = false;
    
    @RequestMapping(value = "create",method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody JobCardAttribute jobCardAttribute) {
        jobCardAttributeService.persist(jobCardAttribute);
        return "JobCardAttribute: " + jobCardAttribute.getId()+ " created...";
    }
    
    @RequestMapping(value = "update",method = RequestMethod.PUT)
    @ResponseBody
    public String update(@RequestBody JobCardAttribute jobCardAttribute) {
        jobCardAttributeService.merge(jobCardAttribute);
        return "JobCardAttribute: " + jobCardAttribute.getId() + " updated...";
    }    

    @RequestMapping(value = "id/{id}",method = RequestMethod.GET)
    @ResponseBody
    public JobCardAttribute getJobCardAttribute(@PathVariable Long id) {
        return jobCardAttributeService.find(id);
    }

    @RequestMapping(value = "getJobCardAttributes", method = RequestMethod.GET)
    @ResponseBody
    public List<JobCardAttribute> getJobCardAttributes(){
        return jobCardAttributeService.findAll();
    }
    
    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String delete(@RequestBody JobCardAttribute jobCardAttribute) {
        if (delEnabled) {
            jobCardAttributeService.remove(jobCardAttribute);
            return "JobCardAttribute: " + jobCardAttribute.getId() + " deleted...";
        }
        else {
            return "JobCardAttribute: " + jobCardAttribute.getId() + " could not be deleted...";
        }
    }
}
