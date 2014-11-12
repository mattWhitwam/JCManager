/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.co.dwarfsun.jcmanager.services.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.dwarfsun.jcmanager.domain.AuditTrail;
import za.co.dwarfsun.jcmanager.repository.AuditTrailRepository;
import za.co.dwarfsun.jcmanager.services.AuditTrailService;

/**
 *
 * @author Matthew
 */
@Service
public class AuditTrailServiceImpl implements AuditTrailService {
    @Autowired
    private AuditTrailRepository auditTrailRepository;

    @Override
    public AuditTrail find(Long id) {
        return auditTrailRepository.findOne(id);
    }

    @Override
    public AuditTrail persist(AuditTrail entity) {
        return auditTrailRepository.save(entity);
    }

    @Override
    public AuditTrail merge(AuditTrail entity) {
        if(entity.getId()!=null) {
            return auditTrailRepository.save(entity);
        }
        return null;
    }

    @Override
    public void remove(AuditTrail entity) {
        auditTrailRepository.delete(entity);
    }

    @Override
    public List<AuditTrail> findAll() {
        return auditTrailRepository.findAll();
    }
    
    
    
}
