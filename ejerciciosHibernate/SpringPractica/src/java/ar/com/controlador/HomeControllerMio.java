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
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author yo
 */
public class HomeControllerMio {
    private PersonaDao dao;
    private ObtenerSession factory;

    public HomeControllerMio() {
        factory=new ObtenerSession();
        dao=new PersonaDao(factory.getSessionFactory());
    }
    
    @RequestMapping(value = "homeMio.htm")
    public ModelAndView home(){
        ModelAndView mav=new ModelAndView();
        List<Persona>datos=dao.select();
        mav.setViewName("homeMio");
        mav.addObject("datos", datos);
        return mav;
    }
}
