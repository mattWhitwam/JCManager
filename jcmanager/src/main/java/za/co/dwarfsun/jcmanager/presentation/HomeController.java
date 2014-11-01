/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.dwarfsun.jcmanager.presentation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Matthew
 */
//@RestController
@Controller
public class HomeController {
    
    @RequestMapping(value="/")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/x",method = RequestMethod.GET)
    public String x(Model model){
        model.addAttribute("value", "This is <b>X</b>");
        return "index";
    }
    @RequestMapping(value = "/y",method = RequestMethod.GET)
    public String y(Model model){
        model.addAttribute("value", "This is <b>Y</b>");
        return "index";
    }
    
    
}
