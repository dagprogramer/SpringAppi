/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.controlador;

import ar.com.dao.PersonaDao;
import ar.com.manager.ObtenerSession;
import ar.com.manager.SessionManager;
import ar.com.modelo.Persona;
import ar.com.modelo.PersonaValidar;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author yo
 */
@Controller
@RequestMapping(value = "agregar.htm")
public class AgregarController {
    private ObtenerSession factory;
    private PersonaValidar validar;
    private PersonaDao dao;

    public AgregarController() {
        validar=new PersonaValidar();
        factory=new ObtenerSession();
        dao=new PersonaDao(factory.getSessionFactory());
    }
    
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView formulario(){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("agregar");
        mav.addObject("persona", new Persona());
        return mav;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView formulario(@ModelAttribute(value = "persona")Persona p,BindingResult result){
        this.validar.validate(p, result);
        if(result.hasErrors()){
            ModelAndView mav=formulario();
            return mav;
        }else{
            dao.save(p);
            return new ModelAndView("redirect:/homeMio.htm");
        }
    }
    
}
