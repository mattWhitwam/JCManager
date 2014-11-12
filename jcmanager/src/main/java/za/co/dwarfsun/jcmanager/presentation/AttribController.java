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
import za.co.dwarfsun.jcmanager.domain.Attrib;
import za.co.dwarfsun.jcmanager.services.AttribService;

/**
 *
 * @author Matt
 */
@Controller
public class AttribController {
    @Autowired
    private AttribService attribService;
    
    @RequestMapping(value="attribs")
    public String attribs(Model model){
        List<Attrib> attribs = attribService.findAll();
        model.addAttribute("attribs", attribs);
        return "attribs";
    }

    @RequestMapping(value="attribs/edit")
    public String editAttribs(Model model,
            @RequestParam(value="attribId", required=false, defaultValue = "") Long attribId, 
            @RequestParam(value="attribDescription", required=false) String attribDescription,
            @RequestParam(value="attribTblName", required=false) String attribTblName,
            @RequestParam(value="attribFldName", required=false) String attribFldName,
            @RequestParam(value="attribIsAKey", required=false) boolean attribIsAKey
            ){
        Attrib attrib = null;
        if(attribDescription != null && !attribDescription.isEmpty()) {
            if (attribId == null) {
                attrib = new Attrib.Builder(attribDescription)
                        .tblName(attribTblName)
                        .fldName(attribFldName)
                        .isakey(attribIsAKey)
                        .build();
                attribService.persist(attrib);
            } 
            else {
                attrib = attribService.find(attribId);
                if (attrib != null) {
                    attrib.setDescription(attribDescription);
                    attrib.setTableName(attribTblName);
                    attrib.setField(attribFldName);
                    attrib.setIskey(attribIsAKey);
                    attribService.merge(attrib);
                }
            }
        }
        model.addAttribute("attrib", attrib);
        return "attribEdit";
    }
    
}
