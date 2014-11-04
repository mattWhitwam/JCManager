/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.co.dwarfsun.jcmanager.services.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.dwarfsun.jcmanager.domain.Site;
import za.co.dwarfsun.jcmanager.repository.SiteRepository;
import za.co.dwarfsun.jcmanager.services.SiteService;

/**
 *
 * @author Matthew
 */
@Service
public class SiteServiceImpl implements SiteService {
    @Autowired
    private SiteRepository siteRepository;

    @Override
    public Site find(Long id) {
        return siteRepository.findOne(id);
    }

    @Override
    public Site persist(Site entity) {
        return siteRepository.save(entity);
    }

    @Override
    public Site merge(Site entity) {
        if(entity.getId()!=null) {
            return siteRepository.save(entity);
        }
        return null;
    }

    @Override
    public void remove(Site entity) {
        siteRepository.delete(entity);
    }

    @Override
    public List<Site> findAll() {
        return siteRepository.findAll();
    }
    
    
    
}
