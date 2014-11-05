/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.dwarfsun.jcmanager.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import za.co.dwarfsun.jcmanager.services.SiteService;

/**
 *
 * @author Matt
 */
@Controller
public class SiteController {
    @Autowired
    private SiteService siteService;
    
    @RequestMapping(value="sites")
    public String sites(Model model){
        return "index";
    }
}
