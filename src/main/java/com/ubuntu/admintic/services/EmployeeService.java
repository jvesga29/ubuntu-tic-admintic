package com.ubuntu.admintic.services;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ubuntu.admintic.entity.Employee;
import com.ubuntu.admintic.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;


    /*
    @JsonManagedReference
    public List<Employee> getEmployeeList(){
        return this.repository.findAll();
    }

    public Employee createEmployee(Employee newEmployee){
        return this.repository.save(newEmployee);
    } */

    public void crearYActualizarUsuario(Employee employee){
        repository.save(employee);
    }

    public List<Employee> verUsuario(){
        return this.repository.findAll();
    }

    public Employee verUsuarioPorId(Long id){
        return repository.findById(id).get();
    }

    public void eliminarUsuario(Long id){
        repository.deleteById(id);
    }

}


