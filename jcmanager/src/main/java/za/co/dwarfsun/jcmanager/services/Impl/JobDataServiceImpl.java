/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.co.dwarfsun.jcmanager.services.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.dwarfsun.jcmanager.domain.JobData;
import za.co.dwarfsun.jcmanager.repository.JobDataRepository;
import za.co.dwarfsun.jcmanager.services.JobDataService;

/**
 *
 * @author Matthew
 */
@Service
public class JobDataServiceImpl implements JobDataService {
    @Autowired
    private JobDataRepository jobDataRepository;

    @Override
    public JobData find(Long id) {
        return jobDataRepository.findOne(id);
    }

    @Override
    public JobData persist(JobData entity) {
        return jobDataRepository.save(entity);
    }

    @Override
    public JobData merge(JobData entity) {
        if(entity.getId()!=null) {
            return jobDataRepository.save(entity);
        }
        return null;
    }

    @Override
    public void remove(JobData entity) {
        jobDataRepository.delete(entity);
    }

    @Override
    public List<JobData> findAll() {
        return jobDataRepository.findAll();
    }
    
    
    
}
