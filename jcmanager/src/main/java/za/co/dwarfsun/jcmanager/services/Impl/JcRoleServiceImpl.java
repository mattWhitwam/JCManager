/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.co.dwarfsun.jcmanager.services.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.dwarfsun.jcmanager.domain.JcRole;
import za.co.dwarfsun.jcmanager.repository.JcRoleRepository;
import za.co.dwarfsun.jcmanager.services.JcRoleService;

/**
 *
 * @author Matthew
 */
@Service
public class JcRoleServiceImpl implements JcRoleService {
    @Autowired
    private JcRoleRepository jcRoleRepository;

    @Override
    public JcRole find(Long id) {
        return jcRoleRepository.findOne(id);
    }

    @Override
    public JcRole persist(JcRole entity) {
        return jcRoleRepository.save(entity);
    }

    @Override
    public JcRole merge(JcRole entity) {
        if(entity.getId()!=null) {
            return jcRoleRepository.save(entity);
        }
        return null;
    }

    @Override
    public void remove(JcRole entity) {
        jcRoleRepository.delete(entity);
    }

    @Override
    public List<JcRole> findAll() {
        return jcRoleRepository.findAll();
    }
    
    
    
}
