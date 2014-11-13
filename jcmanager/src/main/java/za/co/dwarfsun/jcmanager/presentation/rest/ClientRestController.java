/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.dwarfsun.jcmanager.presentation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import za.co.dwarfsun.jcmanager.domain.Client;
import za.co.dwarfsun.jcmanager.services.ClientService;
/**
 *
 * @author Matthew
 */
@RestController
@RequestMapping(value = "api/client")
public class ClientRestController {
    @Autowired
    ClientService clientService;
    
    boolean delEnabled = false;
    
    @RequestMapping(value = "create",method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody Client client) {
        clientService.persist(client);
        return "Client: " + client.getName() + " created...";
    }
    
    @RequestMapping(value = "update",method = RequestMethod.PUT)
    @ResponseBody
    public String update(@RequestBody Client client) {
        clientService.merge(client);
        return "Client: " + client.getName() + " updated...";
    }    

    @RequestMapping(value = "id/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Client getClient(@PathVariable Long id) {
        return clientService.find(id);
    }

    @RequestMapping(value = "getClients", method = RequestMethod.GET)
    @ResponseBody
    public List<Client> getClients(){
        return clientService.findAll();
    }
    
    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String delete(@RequestBody Client client) {
        if (delEnabled) {
            clientService.remove(client);
            return "Client: " + client.getName() + " deleted...";
        }
        else {
            return "Client: " + client.getName() + " could not be deleted...";
        }
    }
}
