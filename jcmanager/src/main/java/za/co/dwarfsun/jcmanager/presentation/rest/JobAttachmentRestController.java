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
import za.co.dwarfsun.jcmanager.domain.JobAttachment;
import za.co.dwarfsun.jcmanager.services.JobAttachmentService;
/**
 *
 * @author Matthew
 */
@RestController
@RequestMapping(value = "api/jobAttachment")
public class JobAttachmentRestController {
    @Autowired
    JobAttachmentService jobAttachmentService;
    
    boolean delEnabled = false;
    
    @RequestMapping(value = "create",method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody JobAttachment jobAttachment) {
        jobAttachmentService.persist(jobAttachment);
        return "JobAttachment: " + jobAttachment.getFilePath() + " created...";
    }
    
    @RequestMapping(value = "update",method = RequestMethod.PUT)
    @ResponseBody
    public String update(@RequestBody JobAttachment jobAttachment) {
        jobAttachmentService.merge(jobAttachment);
        return "JobAttachment: " + jobAttachment.getFilePath() + " updated...";
    }    

    @RequestMapping(value = "id/{id}",method = RequestMethod.GET)
    @ResponseBody
    public JobAttachment getJobAttachment(@PathVariable Long id) {
        return jobAttachmentService.find(id);
    }

    @RequestMapping(value = "getJobAttachments", method = RequestMethod.GET)
    @ResponseBody
    public List<JobAttachment> getJobAttachments(){
        return jobAttachmentService.findAll();
    }
    
    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String delete(@RequestBody JobAttachment jobAttachment) {
        if (delEnabled) {
            jobAttachmentService.remove(jobAttachment);
            return "JobAttachment: " + jobAttachment.getFilePath() + " deleted...";
        }
        else {
            return "JobAttachment: " + jobAttachment.getFilePath() + " could not be deleted...";
        }
    }
}
