/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.dwarfsun.jcmanager.repository;

import za.co.dwarfsun.jcmanager.domain.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Matt
 */
public interface AttributeRepository  extends JpaRepository<Attribute, Long>{
    
}
