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
import javax.servlet.http.HttpServletRequest;
import org.hibernate.SessionFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author yo
 */
public class EliminarController {
    private PersonaDao dao;
    private ObtenerSession factory;
    
    public EliminarController() {
        factory=new ObtenerSession();
        dao=new PersonaDao(factory.getSessionFactory());
    }
    
    private Persona seleccionarPersona(Integer id){
        return dao.getById(id);
    }
    
    @RequestMapping(value = "eliminar.htm")
    public ModelAndView home(HttpServletRequest request){
        ModelAndView mav=new ModelAndView();
        Integer id=Integer.parseInt(request.getParameter("id"));
        Persona persona=this.seleccionarPersona(id);
        dao.delete(persona);
        mav.setViewName("redirect:/homeMio.htm");
        return mav;
    }
    
}
