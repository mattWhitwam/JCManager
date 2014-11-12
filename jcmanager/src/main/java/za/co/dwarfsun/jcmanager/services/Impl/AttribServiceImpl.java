/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.co.dwarfsun.jcmanager.services.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.dwarfsun.jcmanager.domain.Attrib;
import za.co.dwarfsun.jcmanager.repository.AttribRepository;
import za.co.dwarfsun.jcmanager.services.AttribService;

/**
 *
 * @author Matthew
 */
@Service
public class AttribServiceImpl implements AttribService {
    @Autowired
    private AttribRepository attribRepository;

    @Override
    public Attrib find(Long id) {
        return attribRepository.findOne(id);
    }

    @Override
    public Attrib persist(Attrib entity) {
        return attribRepository.save(entity);
    }

    @Override
    public Attrib merge(Attrib entity) {
        if(entity.getId()!=null) {
            return attribRepository.save(entity);
        }
        return null;
    }

    @Override
    public void remove(Attrib entity) {
        attribRepository.delete(entity);
    }

    @Override
    public List<Attrib> findAll() {
        return attribRepository.findAll();
    }
    
    
    
}
