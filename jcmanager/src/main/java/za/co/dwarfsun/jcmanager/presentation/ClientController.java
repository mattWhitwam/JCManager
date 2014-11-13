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
        model.addAttribute("clients", clients);
        return "clients";
    }

    @RequestMapping(value="clients/edit")
    public String editClients(Model model,
            @RequestParam(value="clientId", required=false, defaultValue = "") Long clientId, 
            @RequestParam(value="clientName", required=false) String clientName
            ){
        Client client = null;
        if (clientId == null) {
            if(clientName != null && !clientName.isEmpty()) {
                client = new Client.Builder(clientName)
                        .contactPerson(null)
                        .site(null)
                        .build();
                clientService.persist(client);
            }
        }
        else {
            client = clientService.find(clientId);            
            if (clientName != null && !clientName.isEmpty()) {
                client.setName(clientName);
            }
            clientService.merge(client);
        }
        model.addAttribute("client", client);
        return "clientEdit";
    }
}
