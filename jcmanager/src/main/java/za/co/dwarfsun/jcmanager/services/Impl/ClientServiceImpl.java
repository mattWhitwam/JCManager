/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.co.dwarfsun.jcmanager.services.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.dwarfsun.jcmanager.domain.Client;
import za.co.dwarfsun.jcmanager.repository.ClientRepository;
import za.co.dwarfsun.jcmanager.services.ClientService;

/**
 *
 * @author Matthew
 */
@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository jlientRepository;

    @Override
    public Client find(Long id) {
        return jlientRepository.findOne(id);
    }

    @Override
    public Client persist(Client entity) {
        return jlientRepository.save(entity);
    }

    @Override
    public Client merge(Client entity) {
        if(entity.getId()!=null) {
            return jlientRepository.save(entity);
        }
        return null;
    }

    @Override
    public void remove(Client entity) {
        jlientRepository.delete(entity);
    }

    @Override
    public List<Client> findAll() {
        return jlientRepository.findAll();
    }
    
    
    
}
