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
import za.co.dwarfsun.jcmanager.domain.JobCard;
import za.co.dwarfsun.jcmanager.services.JobCardService;
/**
 *
 * @author Matthew
 */
@RestController
@RequestMapping(value = "api/jobCard")
public class JobCardRestController {
    @Autowired
    JobCardService jobCardService;
    
    boolean delEnabled = false;
    
    @RequestMapping(value = "create",method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody JobCard jobCard) {
        jobCardService.persist(jobCard);
        return "JobCard: " + jobCard.getName()+ " created...";
    }
    
    @RequestMapping(value = "update",method = RequestMethod.PUT)
    @ResponseBody
    public String update(@RequestBody JobCard jobCard) {
        jobCardService.merge(jobCard);
        return "JobCard: " + jobCard.getName() + " updated...";
    }    

    @RequestMapping(value = "id/{id}",method = RequestMethod.GET)
    @ResponseBody
    public JobCard getJobCard(@PathVariable Long id) {
        return jobCardService.find(id);
    }

    @RequestMapping(value = "getJobCards", method = RequestMethod.GET)
    @ResponseBody
    public List<JobCard> getJobCards(){
        return jobCardService.findAll();
    }
    
    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String delete(@RequestBody JobCard jobCard) {
        if (delEnabled) {
            jobCardService.remove(jobCard);
            return "JobCard: " + jobCard.getName() + " deleted...";
        }
        else {
            return "JobCard: " + jobCard.getName() + " could not be deleted...";
        }
    }
}
