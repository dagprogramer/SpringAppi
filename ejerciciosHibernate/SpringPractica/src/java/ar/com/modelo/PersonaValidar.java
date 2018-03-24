/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.modelo;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author yo
 */
public class PersonaValidar implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return Persona.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Persona p=(Persona)o;
        ValidationUtils.rejectIfEmpty(errors, "nombre", "required.nombre", "el campo nombre es obligatorio");
        ValidationUtils.rejectIfEmpty(errors, "apellido", "required.apellido", "el campo apellido es obligatorio");
        ValidationUtils.rejectIfEmpty(errors, "edad", "required.edad", "el campo edad es obligatorio");
    }
    
}
