/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.co.dwarfsun.jcmanager.services.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.dwarfsun.jcmanager.domain.JcUser;
import za.co.dwarfsun.jcmanager.repository.JcUserRepository;
import za.co.dwarfsun.jcmanager.services.JcUserService;

/**
 *
 * @author Matthew
 */
@Service
public class JcUserServiceImpl implements JcUserService {
    @Autowired
    private JcUserRepository jcUserRepository;

    @Override
    public JcUser find(Long id) {
        return jcUserRepository.findOne(id);
    }

    @Override
    public JcUser persist(JcUser entity) {
        return jcUserRepository.save(entity);
    }

    @Override
    public JcUser merge(JcUser entity) {
        if(entity.getId()!=null) {
            return jcUserRepository.save(entity);
        }
        return null;
    }

    @Override
    public void remove(JcUser entity) {
        jcUserRepository.delete(entity);
    }

    @Override
    public List<JcUser> findAll() {
        return jcUserRepository.findAll();
    }
    
    
    
}
