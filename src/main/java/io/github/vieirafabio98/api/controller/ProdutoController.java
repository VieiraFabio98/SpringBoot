package io.github.vieirafabio98.api.controller;

import io.github.vieirafabio98.domain.repository.Produtos;
import io.github.vieirafabio98.domain.entity.Produto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/produtos")
public class ProdutoController {

    private Produtos produtos;

    public ProdutoController(Produtos produtos){
        this.produtos = produtos;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto save(@RequestBody Produto produto){
        return produtos.save(produto);
    }
}