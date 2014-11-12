/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.co.dwarfsun.jcmanager.services.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.dwarfsun.jcmanager.domain.JobCard;
import za.co.dwarfsun.jcmanager.repository.JobCardRepository;
import za.co.dwarfsun.jcmanager.services.JobCardService;

/**
 *
 * @author Matthew
 */
@Service
public class JobCardServiceImpl implements JobCardService {
    @Autowired
    private JobCardRepository jobCardRepository;

    @Override
    public JobCard find(Long id) {
        return jobCardRepository.findOne(id);
    }

    @Override
    public JobCard persist(JobCard entity) {
        return jobCardRepository.save(entity);
    }

    @Override
    public JobCard merge(JobCard entity) {
        if(entity.getId()!=null) {
            return jobCardRepository.save(entity);
        }
        return null;
    }

    @Override
    public void remove(JobCard entity) {
        jobCardRepository.delete(entity);
    }

    @Override
    public List<JobCard> findAll() {
        return jobCardRepository.findAll();
    }
    
    
    
}
