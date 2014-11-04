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
import za.co.dwarfsun.jcmanager.domain.Site;
import za.co.dwarfsun.jcmanager.services.ClientService;
import za.co.dwarfsun.jcmanager.services.SiteService;
/**
 *
 * @author Matt
 */
@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private SiteService siteService;
    
    @RequestMapping(value="clients")
    public String clients(Model model){
        List<Client> clients = clientService.findAll();
        model.addAttribute("numClients", clients.size());
        String template = "<form action=\"clients/edit\" method=\"POST\" class=\"listed\"><input readonly type=\"text\" name=\"clientId\" value=\" %s \"/><input readonly type=\"text\" name=\"clientName\" value=\" %s \"/><input type=\"submit\" value=\"Manage\"/> %s sites; %s contacts; </form>";
        String clientsAsHTML = "";
        for (Client client : clients) {
            int t = client.getSites().size();
            clientsAsHTML += String.format(template, client.getId(), client.getName(), client.getSites().size(), client.getContactPersons().size() );
        }
        model.addAttribute("clientsAsHTML", clientsAsHTML);
        
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
            if (clientName != null && !clientName.isEmpty()) {
                client.setName(clientName);
            }
            else {
                clientName = client.getName();
            }
            clientService.persist(client);
        }
        model.addAttribute("clientId", clientId);
        model.addAttribute("clientName", clientName);
        return "clientEdit";
    }
    
}
