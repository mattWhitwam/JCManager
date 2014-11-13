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
import za.co.dwarfsun.jcmanager.domain.JobData;
import za.co.dwarfsun.jcmanager.services.JobDataService;
/**
 *
 * @author Matthew
 */
@RestController
@RequestMapping(value = "api/jobData")
public class JobDataRestController {
    @Autowired
    JobDataService jobDataService;
    
    boolean delEnabled = false;
    
    @RequestMapping(value = "create",method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody JobData jobData) {
        jobDataService.persist(jobData);
        return "JobData: " + jobData.getId()+ " created...";
    }
    
    @RequestMapping(value = "update",method = RequestMethod.PUT)
    @ResponseBody
    public String update(@RequestBody JobData jobData) {
        jobDataService.merge(jobData);
        return "JobData: " + jobData.getId() + " updated...";
    }    

    @RequestMapping(value = "id/{id}",method = RequestMethod.GET)
    @ResponseBody
    public JobData getJobData(@PathVariable Long id) {
        return jobDataService.find(id);
    }

    @RequestMapping(value = "getJobDatas", method = RequestMethod.GET)
    @ResponseBody
    public List<JobData> getJobDatas(){
        return jobDataService.findAll();
    }
    
    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String delete(@RequestBody JobData jobData) {
        if (delEnabled) {
            jobDataService.remove(jobData);
            return "JobData: " + jobData.getId() + " deleted...";
        }
        else {
            return "JobData: " + jobData.getId() + " could not be deleted...";
        }
    }
}
