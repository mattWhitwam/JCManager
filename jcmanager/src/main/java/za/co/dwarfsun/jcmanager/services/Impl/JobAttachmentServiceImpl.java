/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.co.dwarfsun.jcmanager.services.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.dwarfsun.jcmanager.domain.JobAttachment;
import za.co.dwarfsun.jcmanager.repository.JobAttachmentRepository;
import za.co.dwarfsun.jcmanager.services.JobAttachmentService;

/**
 *
 * @author Matthew
 */
@Service
public class JobAttachmentServiceImpl implements JobAttachmentService {
    @Autowired
    private JobAttachmentRepository jobAttachmentRepository;

    @Override
    public JobAttachment find(Long id) {
        return jobAttachmentRepository.findOne(id);
    }

    @Override
    public JobAttachment persist(JobAttachment entity) {
        return jobAttachmentRepository.save(entity);
    }

    @Override
    public JobAttachment merge(JobAttachment entity) {
        if(entity.getId()!=null) {
            return jobAttachmentRepository.save(entity);
        }
        return null;
    }

    @Override
    public void remove(JobAttachment entity) {
        jobAttachmentRepository.delete(entity);
    }

    @Override
    public List<JobAttachment> findAll() {
        return jobAttachmentRepository.findAll();
    }
    
    
    
}
