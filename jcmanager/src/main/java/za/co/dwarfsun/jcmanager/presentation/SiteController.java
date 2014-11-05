/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.dwarfsun.jcmanager.presentation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import za.co.dwarfsun.jcmanager.domain.Client;
import za.co.dwarfsun.jcmanager.domain.Site;
import za.co.dwarfsun.jcmanager.services.ClientService;
import za.co.dwarfsun.jcmanager.services.SiteService;

/**
 *
 * @author Matt
 */
@Controller
public class SiteController {
    @Autowired
    private SiteService siteService;
    @Autowired
    private ClientService clientService;
    
    @RequestMapping(value="sites")
    public String sites(Model model){
        return "index";
    }
    
    @RequestMapping(value="sites/details", method=RequestMethod.POST)
    public String editSite (Model model,
            @RequestParam(value="clientId", required=true) Long clientId,
            @RequestParam(value="siteId", defaultValue="") Long siteId) {
        
        model.addAttribute("clientId", clientId);
        if (siteId != null) {
            Site site = siteService.find(siteId);
            model.addAttribute("siteId", site.getId());
            model.addAttribute("siteName", site.getName());
            model.addAttribute("siteAddress", site.getAddress());
        }
        return "siteEdit";
    }
    
    @RequestMapping(value="sites/saveSite", method=RequestMethod.POST)
    public String saveSite(Model model,
            @RequestParam(value="clientId", required=true) Long clientId,
        @RequestParam(value="siteId", defaultValue="") Long siteId,
        @RequestParam(value="siteName", required=true) String siteName,
        @RequestParam(value="siteAddress", required=true) String siteAddress
    ){
        
        if (siteId != null) { 
            Site site = siteService.find(siteId);
            site.setName(siteName);
            site.setAddress(siteAddress);
            siteService.merge(site);
        }
        else {
            Site site = new Site.Builder(siteName)
                    .address(siteAddress)
                    .build();
            siteService.persist(site);
            Client client = clientService.find(clientId);
            List<Site> sites = client.getSites();
            sites.add(site);
            client.setSites(sites);
            clientService.merge(client);
        }
        model.addAttribute("clientId", clientId);
        
        return "index";
    }
    
}
