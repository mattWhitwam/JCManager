/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.dwarfsun.jcmanager.presentation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import za.co.dwarfsun.jcmanager.domain.JcRole;
import za.co.dwarfsun.jcmanager.services.JcRoleService;

/**
 *
 * @author Matt
 */
@Controller
public class JcRoleController {
    @Autowired
    private JcRoleService jcRoleService;
    
    @RequestMapping(value="jcRoles")
    public String jcRoles(Model model){
        List<JcRole> jcRoles = jcRoleService.findAll();
        model.addAttribute("jcRoles", jcRoles);
        return "jcRoles";
    }

    @RequestMapping(value="jcRoles/edit")
    public String editJcRoles(Model model,
            @RequestParam(value="jcRoleId", required=false, defaultValue = "") Long jcRoleId, 
            @RequestParam(value="jcRoleDescription", required=false) String jcRoleDescription
            ){
        JcRole jcRole = null;
        if(jcRoleDescription != null && !jcRoleDescription.isEmpty()) {
            if (jcRoleId == null) {
                jcRole = new JcRole.Builder(jcRoleDescription)
                        .build();
                jcRoleService.persist(jcRole);
            } 
            else {
                jcRole = jcRoleService.find(jcRoleId);
                if (jcRole != null) {
                    jcRole.setDescription(jcRoleDescription);
                    jcRoleService.merge(jcRole);
                }
            }
        }
        model.addAttribute("jcRole", jcRole);
        return "jcRoleEdit";
    }
    
}
