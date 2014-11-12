/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.co.dwarfsun.jcmanager.services.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.dwarfsun.jcmanager.domain.JobInfo;
import za.co.dwarfsun.jcmanager.repository.JobInfoRepository;
import za.co.dwarfsun.jcmanager.services.JobInfoService;

/**
 *
 * @author Matthew
 */
@Service
public class JobInfoServiceImpl implements JobInfoService {
    @Autowired
    private JobInfoRepository jobInfoRepository;

    @Override
    public JobInfo find(Long id) {
        return jobInfoRepository.findOne(id);
    }

    @Override
    public JobInfo persist(JobInfo entity) {
        return jobInfoRepository.save(entity);
    }

    @Override
    public JobInfo merge(JobInfo entity) {
        if(entity.getId()!=null) {
            return jobInfoRepository.save(entity);
        }
        return null;
    }

    @Override
    public void remove(JobInfo entity) {
        jobInfoRepository.delete(entity);
    }

    @Override
    public List<JobInfo> findAll() {
        return jobInfoRepository.findAll();
    }
    
    
    
}
