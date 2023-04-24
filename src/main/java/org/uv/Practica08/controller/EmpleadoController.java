package org.uv.Practica08.controller;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 */
@RestController
@RequestMapping("/api")
public class EmpleadoController {
    @Autowired
    private RepositoryEmpleado repositoryEmpleado;
    
    @GetMapping("/msg")
    public String holaMundo() {
        return "hola mundo";
    }
    
   @GetMapping("/empleado/{id}")
    public DTOEmpleado obtenerEmpleado(@PathVariable("id") long id){
        DTOEmpleado emp = null;
        
        if (id ==10){
        emp = new DTOEmpleado();
        emp.setClave(10);
        emp.setNombre("sag");
        emp.setDireccion("Av 1");
        emp.setTelefono("1234");
    }
       return emp;
}
    
     @GetMapping("/empleado")
     public List<DTOEmpleado> obtenerTodosLosEmpleados(){
     List<DTOEmpleado> lstEmpleados=new ArrayList<>();
     DTOEmpleado emp1 = new DTOEmpleado();
        emp1.setClave(10);
        emp1.setNombre("Sag 2");
        emp1.setDireccion("Av 1");
        emp1.setTelefono("12345");
        
       
       lstEmpleados.add(emp1);
       DTOEmpleado emp2= new DTOEmpleado();
        emp2.setClave(10);
        emp2.setNombre("sagnax");
        emp2.setDireccion("Av 1");
        emp2.setTelefono("1234");
        lstEmpleados.add(emp2);
        
        return lstEmpleados;
     }
     
     @PostMapping("/empleado")
     public DTOEmpleado crearEmpleado(@RequestBody DTOEmpleado empleadoDTO){
         Empleado empleadoPojo = new Empleado();
         empleadoPojo.setNombre(empleadoDTO.getNombre());
         empleadoPojo.setDireccion(empleadoDTO.getDireccion());
         empleadoPojo.setTelefono(empleadoDTO.getTelefono());
         
         Empleado empleadoPojoNew=repositoryEmpleado.save(empleadoPojo);
         
         DTOEmpleado empleadoDTONew = new DTOEmpleado();
         empleadoDTONew.setClave(empleadoPojoNew.getClave());
         empleadoDTONew.setNombre(empleadoPojoNew.getNombre());
         empleadoDTONew.setDireccion(empleadoPojoNew.getDireccion());
         empleadoDTONew.setTelefono(empleadoPojoNew.getTelefono());
                  
         //Se guardaria
         return empleadoDTONew;
     
     }
     
     @DeleteMapping("/empleado/{id}")
     public void borrarEmpleado(@PathVariable Long id){
         //borrar
         return;
     }
    
    @PutMapping("/empleado/{id}") 
    public DTOEmpleado modificarEmpleado(@PathVariable("id") Long id,
        @RequestBody DTOEmpleado empleado){
        //mapeo
        //buscar id
        //update
        return empleado;
    }
}