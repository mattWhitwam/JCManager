/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.co.dwarfsun.jcmanager.services.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.dwarfsun.jcmanager.domain.ContactPerson;
import za.co.dwarfsun.jcmanager.repository.ContactPersonRepository;
import za.co.dwarfsun.jcmanager.services.ContactPersonService;

/**
 *
 * @author Matthew
 */
@Service
public class ContactPersonServiceImpl implements ContactPersonService {
    @Autowired
    private ContactPersonRepository contactPersonRepository;

    @Override
    public ContactPerson find(Long id) {
        return contactPersonRepository.findOne(id);
    }

    @Override
    public ContactPerson persist(ContactPerson entity) {
        return contactPersonRepository.save(entity);
    }

    @Override
    public ContactPerson merge(ContactPerson entity) {
        if(entity.getId()!=null) {
            return contactPersonRepository.save(entity);
        }
        return null;
    }

    @Override
    public void remove(ContactPerson entity) {
        contactPersonRepository.delete(entity);
    }

    @Override
    public List<ContactPerson> findAll() {
        return contactPersonRepository.findAll();
    }
    
    
    
}
