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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import za.co.dwarfsun.jcmanager.domain.Client;
import za.co.dwarfsun.jcmanager.domain.ContactPerson;
import za.co.dwarfsun.jcmanager.services.ClientService;
import za.co.dwarfsun.jcmanager.services.ContactPersonService;

/**
 *
 * @author Matthew
 */
//@RestController
@Controller
public class ContactPersonController {
    @Autowired
    private ContactPersonService contactService;
    @Autowired
    private ClientService clientService;
    
    @RequestMapping(value="contacts/details")
    public String editContact(Model model,
            @RequestParam(value="clientId", required=true) Long clientId,
            @RequestParam(value="contactId", defaultValue="") Long contactId){
        
        model.addAttribute("clientId", clientId);
        if (contactId != null) {
            ContactPerson contact = contactService.find(contactId);
            model.addAttribute("contactId", contact.getId());
            model.addAttribute("contactDescription", contact.getDescription());
        }
        return "contactEdit";
    }

    @RequestMapping(value="sites/saveContact", method=RequestMethod.POST)
    public String saveContact(Model model,
            @RequestParam(value="clientId", required=true) Long clientId,
            @RequestParam(value="contactId", defaultValue="") Long contactId,
            @RequestParam(value="contactDescription", required=true) String contactDescription
    ){
        if (contactId != null) {
            ContactPerson contact = contactService.find(contactId);
            contact.setDescription(contactDescription);
            contact.setFirstname(null);
            contact.setLastname(null);
            /*
            contact.setTitle(null);
            contact.setEmail(null);
            contact.setPhone(null);
            */
        }
        else {
            ContactPerson contact = new ContactPerson.Builder(contactDescription)
                    .build();
            contactService.persist(contact);
            Client client = clientService.find(clientId);
            client.addContactPerson(contact);
            clientService.merge(client);
        }
        return "index";
    }
    
}
