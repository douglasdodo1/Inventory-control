package com.inventorycontrol.inventorycontrol.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.inventorycontrol.inventorycontrol.models.ProductModel;
import com.inventorycontrol.inventorycontrol.repository.ProductRepository;
import jakarta.validation.Valid;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)

public class ProductController {

    @Autowired
    private ProductRepository pr;

    @RequestMapping(value="/registrarProduto", method = RequestMethod.GET)
    public String form(){
        return "formProduto";
    }
 
    @RequestMapping(value="/registrarProduto", method = RequestMethod.POST)
    public String form(@Valid ProductModel productModel, BindingResult bindingResult){
        if (!bindingResult.hasErrors()) {
            if (productModel.getQuantityInStock().length() < 3) {
                String corrigedQuantity = "";
                int lenght = productModel.getQuantityInStock().length();

                for (int i = lenght; i < 3; i++) {
                    corrigedQuantity += "0";
                }
                corrigedQuantity += productModel.getQuantityInStock();
                productModel.setQuantityInStock(corrigedQuantity);
            }

            float floatPrice = (float) Float.valueOf(productModel.getPrice()).floatValue();
                String newPrice = String.format("%.2f", floatPrice);
                productModel.setPrice(newPrice);

                String[] validity = productModel.getValidity().split("-");
                String invertedString = "";

                for (int i = validity.length-1; i >= 0 ; i--) {
                    invertedString += validity[i];
                    if (i >=1) {
                        invertedString += "/";
                    }
                }

                productModel.setValidity(invertedString);
            pr.save(productModel);
        }

        return "redirect:/registrarProduto";
    }

    @RequestMapping("/produtos")
    public ModelAndView listProducts(){
        var mv = new ModelAndView("index");
        Iterable<ProductModel> productList = pr.findAll();
        mv.addObject("produtos", productList);
        return mv;
    }   

    @GetMapping("/deletar/{id}")
    public String deletarProduto(@PathVariable("id") Long id){
        pr.deleteById(id);
        return "redirect:/produtos";
    }

    @RequestMapping(value="/editar/{id}", method=RequestMethod.GET)
    public ModelAndView alterar(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("alterarDados");
        ProductModel productModel = pr.findById(id).get();
        mv.addObject("product",productModel);
        return mv;
    }
}   
