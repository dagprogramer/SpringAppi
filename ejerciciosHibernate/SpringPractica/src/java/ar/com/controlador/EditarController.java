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
import javax.servlet.http.HttpServletRequest;
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
@RequestMapping(value = "editar.htm")
public class EditarController {
    private PersonaValidar validar;
    private PersonaDao dao;
    private ObtenerSession factory;
    
    public EditarController() {
        validar=new PersonaValidar();
        factory=new ObtenerSession();
        dao=new PersonaDao(factory.getSessionFactory());
    }
    
    private Persona seleccionarPersona(Integer id){
        Persona persona=dao.getById(id);
        return persona;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView formulario(HttpServletRequest request){
        Integer id=Integer.parseInt(request.getParameter("id"));
        Persona datos=this.seleccionarPersona(id);
        ModelAndView mav=new ModelAndView();
        mav.setViewName("editar");
        mav.addObject("persona", new Persona(id, datos.getNombre(), datos.getApellido(), datos.getEdad()));
        return mav;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView formulario(@ModelAttribute(value = "persona")Persona p,BindingResult result,HttpServletRequest request){
        this.validar.validate(p, result);
        if(result.hasErrors()){
            ModelAndView mav=formulario(request);
            return mav;
        }else{
            dao.update(p);
            return new ModelAndView("redirect:/homeMio.htm");
        }
    }
    
}
