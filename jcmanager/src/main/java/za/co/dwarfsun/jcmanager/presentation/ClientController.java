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
import za.co.dwarfsun.jcmanager.domain.Client;
import za.co.dwarfsun.jcmanager.services.ClientService;
/**
 *
 * @author Matt
 */
@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;
    
    @RequestMapping(value="clients")
    public String clients(Model model){
        List<Client> clients = clientService.findAll();
        
        String template = "<form action=\"clients/edit\" method=\"POST\" class=\"listed\"><input readonly type=\"text\" name=\"clientId\" value=\" %s \"/><input readonly type=\"text\" name=\"clientName\" value=\" %s \"/><input type=\"submit\" value=\"Manage\"/></form>";
        String clientsAsHTML = "";
        for (Client client : clients) {
            clientsAsHTML += String.format(template, client.getId(), client.getName()) ;
        }
        model.addAttribute("clientsAsHTML", clientsAsHTML);
        model.addAttribute("numClients", clients.size());
        return "clients";
    }
    
    @RequestMapping(value="clients/edit")
    public String editClients(Model model,
            @RequestParam(value="clientId", required=false, defaultValue = "") Long clientId, 
            @RequestParam(value="clientName", required=false) String clientName
            ){
        
        if (clientId == null) {
            if(clientName != null && !clientName.isEmpty()) {
                Client client = new Client.Builder(clientName)
                        .contactPerson(null)
                        .site(null)
                        .build();
                clientService.persist(client);
                clientId = client.getId();
            }
            else {
                //
            }
        }
        else {
            Client client = clientService.find(clientId);
            clientName = client.getName();
        }
        model.addAttribute("clientId", clientId);
        model.addAttribute("clientName", clientName);
        return "clientEdit";
    }
    
}
