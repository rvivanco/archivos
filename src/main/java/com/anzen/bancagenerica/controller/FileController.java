package com.anzen.bancagenerica.controller;

import org.springframework.web.bind.annotation.*;
import com.anzen.bancagenerica.logic.FileValidator;

import java.util.Map;

/**
 * Created by raul on 10/04/17.
 */
@RestController
@RequestMapping("/")
public class FileController {

    @PostMapping()
    public Map<String, Object> execute(@RequestBody Map<String, Object> json)
    {
        Map<String, Object> innerJson= (Map<String, Object>) json.get("FileDefinition");
        //Integer s= (Integer) innerJson.get("Side");
        //System.out.println(s);
        FileValidator fileValidator= new FileValidator((Map<String, Object>) json.get("FileDefinition"));
        if(fileValidator.validarLinea("000000000000151004170001                              abcdef             archivo02                         ordenes de pago112"))
        {
            System.out.println("Controller: Linea Valida ");
        }
        else
            System.out.println("Controller: Linea Invalida");


        fileValidator.validarLinea("0121230000000000000100201300000000000123456789                             Referencia1                                           beneficiario                           Instrucciones             Descripcion123401234569");
        fileValidator.validarLinea("99123123456000000000000010050123456000000000000020020");

        return (Map<String, Object>) innerJson.get("FileLines");
    }
}
