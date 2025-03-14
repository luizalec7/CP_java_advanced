package com.CPjava.produto.controller;

import com.CPjava.produto.model.Produto;
import com.CPjava.produto.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    
    @GetMapping
    public String listar(Model model) {
        List<Produto> produtos = produtoService.listarTodos();
        model.addAttribute("produtos", produtos);
        return "produtos/listar"; 
    }

    
    @GetMapping("/novo")
    public String formularioNovo(Model model) {
        Produto produto = new Produto(); 
        model.addAttribute("produto", produto);
        return "produtos/formulario"; 
    }

    
    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("produto") Produto produto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("produto", produto); 
            return "produtos/formulario";
        }
        produtoService.salvar(produto);
        return "redirect:/produtos";
    }

   
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Produto> produtoOpt = produtoService.buscarPorId(id);
        if (produtoOpt.isPresent()) {
            model.addAttribute("produto", produtoOpt.get());
            return "produtos/formulario";
        } else {
            return "redirect:/produtos"; 
        }
    }

    
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        produtoService.excluir(id);
        return "redirect:/produtos";
    }
}
