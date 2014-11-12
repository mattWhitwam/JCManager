/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.co.dwarfsun.jcmanager.services.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.dwarfsun.jcmanager.domain.JobCardAttribute;
import za.co.dwarfsun.jcmanager.repository.JobCardAttributeRepository;
import za.co.dwarfsun.jcmanager.services.JobCardAttributeService;

/**
 *
 * @author Matthew
 */
@Service
public class JobCardAttributeServiceImpl implements JobCardAttributeService {
    @Autowired
    private JobCardAttributeRepository jobCardAttributeRepository;

    @Override
    public JobCardAttribute find(Long id) {
        return jobCardAttributeRepository.findOne(id);
    }

    @Override
    public JobCardAttribute persist(JobCardAttribute entity) {
        return jobCardAttributeRepository.save(entity);
    }

    @Override
    public JobCardAttribute merge(JobCardAttribute entity) {
        if(entity.getId()!=null) {
            return jobCardAttributeRepository.save(entity);
        }
        return null;
    }

    @Override
    public void remove(JobCardAttribute entity) {
        jobCardAttributeRepository.delete(entity);
    }

    @Override
    public List<JobCardAttribute> findAll() {
        return jobCardAttributeRepository.findAll();
    }
    
    
    
}
