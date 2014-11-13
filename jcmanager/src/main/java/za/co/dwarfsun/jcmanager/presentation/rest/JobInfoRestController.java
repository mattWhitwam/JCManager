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
import za.co.dwarfsun.jcmanager.domain.JobInfo;
import za.co.dwarfsun.jcmanager.services.JobInfoService;
/**
 *
 * @author Matthew
 */
@RestController
@RequestMapping(value = "api/jobInfo")
public class JobInfoRestController {
    @Autowired
    JobInfoService jobInfoService;
    
    boolean delEnabled = false;
    
    @RequestMapping(value = "create",method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody JobInfo jobInfo) {
        jobInfoService.persist(jobInfo);
        return "JobInfo: " + jobInfo.getId()+ " created...";
    }
    
    @RequestMapping(value = "update",method = RequestMethod.PUT)
    @ResponseBody
    public String update(@RequestBody JobInfo jobInfo) {
        jobInfoService.merge(jobInfo);
        return "JobInfo: " + jobInfo.getId() + " updated...";
    }    

    @RequestMapping(value = "id/{id}",method = RequestMethod.GET)
    @ResponseBody
    public JobInfo getJobInfo(@PathVariable Long id) {
        return jobInfoService.find(id);
    }

    @RequestMapping(value = "getJobInfos", method = RequestMethod.GET)
    @ResponseBody
    public List<JobInfo> getJobInfos(){
        return jobInfoService.findAll();
    }
    
    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String delete(@RequestBody JobInfo jobInfo) {
        if (delEnabled) {
            jobInfoService.remove(jobInfo);
            return "JobInfo: " + jobInfo.getId() + " deleted...";
        }
        else {
            return "JobInfo: " + jobInfo.getId() + " could not be deleted...";
        }
    }
}
