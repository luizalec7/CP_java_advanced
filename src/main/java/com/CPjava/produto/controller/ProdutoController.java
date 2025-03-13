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

    // ✅ Listar todos os produtos
    @GetMapping
    public String listar(Model model) {
        List<Produto> produtos = produtoService.listarTodos();
        model.addAttribute("produtos", produtos);
        return "produtos/listar"; // Certifique-se de que esse nome corresponde ao arquivo listar.html
    }

    // ✅ Exibir formulário para criar um novo produto
    @GetMapping("/novo")
    public String formularioNovo(Model model) {
        Produto produto = new Produto(); // Certifique-se de criar um novo objeto
        model.addAttribute("produto", produto);
        return "produtos/formulario"; // Nome correto do template
    }

    // ✅ Salvar um novo produto ou atualizar um existente
    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("produto") Produto produto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("produto", produto); // Retorna os dados já preenchidos no formulário
            return "produtos/formulario";
        }
        produtoService.salvar(produto);
        return "redirect:/produtos";
    }

    // ✅ Editar um produto existente
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Produto> produtoOpt = produtoService.buscarPorId(id);
        if (produtoOpt.isPresent()) {
            model.addAttribute("produto", produtoOpt.get());
            return "produtos/formulario";
        } else {
            return "redirect:/produtos"; // Redireciona caso o ID não seja encontrado
        }
    }

    // ✅ Excluir um produto por ID
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        produtoService.excluir(id);
        return "redirect:/produtos";
    }
}