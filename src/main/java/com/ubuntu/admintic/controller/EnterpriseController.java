package com.ubuntu.admintic.controller;

import com.ubuntu.admintic.entity.Enterprise;
import com.ubuntu.admintic.services.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EnterpriseController {

    @Autowired
    EnterpriseService services;

//    public EnterpriseController(EnterpriseService services){
//        this.services=services;
//    }

    @GetMapping ("/empresas")
    private String verEmpresa(Model model){
        model.addAttribute("enterprises", services.verEmpresa());
        return "empresas";
    }

    @GetMapping("/nuevaEmpresa")
    private String verFormNuevaEmpresa(Enterprise enterprise){
        return "nuevaEmpresa";
    }

    @PostMapping("empresas")
    private String crearEmpresa(Enterprise enterprise){
        services.crearYActualizarEmpresa(enterprise);
        return "redirect:/empresas";
    }

    @GetMapping("/empresas/borrar/{id}")
    private String eliminarEmpresa(@PathVariable("id") Long id){
        services.eliminarEmpresa(id);
        return "redirect:/empresas";
    }

    @GetMapping("empresas/editar/{id}")
    private String verEmpresaPorId(@PathVariable("id") Long id, Model model){
        Enterprise enterprise = services.verEmpresaPorId(id);
        model.addAttribute("enterprise", enterprise);
        return "ActualizarEmpresa";
    }

    @PostMapping("empresas/actualizar/{id}")
    private String editarEmpresa(@PathVariable("id") Long id, Enterprise enterprise){
        services.crearYActualizarEmpresa(enterprise);
        return "redirect:/empresas";
    }
//    @GetMapping("/enterprise")
//    public List<Enterprise> EnterpriseList(){
//        return this.services.getEnterpriseList();
//    }

//    @PostMapping("/enterprise")
//    public Enterprise createEnterprise(@RequestBody Enterprise enterprise){
//        return this.services.createEnterprise(enterprise);
//    }
//
//    @GetMapping(value="/enterprise/{id}")
//    public Optional<Enterprise> findBy (@PathVariable long id){
//        return this.services.findEnterprise(id);
//    }
//
//    @DeleteMapping("/enterprise/{id}")
//    public String deleteEnterprise(@PathVariable int id){
//        return "";
//    }
//
//    @PatchMapping("/enterprise/{id}")
//    public String updateEnterprise(@PathVariable int id){
//        return "";
//    }
}



