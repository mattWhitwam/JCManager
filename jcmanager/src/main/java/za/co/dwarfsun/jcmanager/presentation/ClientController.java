/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.dwarfsun.jcmanager.presentation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *
 * @author Matt
 */
@Controller
public class ClientController {
   
    @RequestMapping(value="clients")
    public String clients(){
        return "clients";
    }
    
    @RequestMapping(value="clients/edit")
    public String editClients(Model model,
            @RequestParam(value="clientId", required=false, defaultValue = "") Long clientId, 
            @RequestParam(value="clientName", required=false) String clientName
            ){
        
        //model.addAttribute("clientID", (clientId != null) ? clientId : null);
        model.addAttribute("clientId", clientId);
        model.addAttribute("clientName", clientName);
        
        
        return "clientEdit";
    }
    
}
