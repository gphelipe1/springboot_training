package com.example.demo.controller;

import com.example.demo.dto.MercadoriasDTO;
import com.example.demo.dto.Venda_mercadoriaDTO;
import com.example.demo.entidades.Mercadorias;
import com.example.demo.entidades.Venda_mercadoria;
import com.example.demo.entidades.Vendas;
import com.example.demo.services.MercadoriasService;
import com.example.demo.services.exceptions.RegraNegocioRunTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/mercadorias")
/**Em geral
 * Salvar é uma função POST
 * Autenticar pode ser POST
 * Os dois entram em conflito (2 posts no mesmo endpoint,
 *      portanto terá que fazer o mapeamento separado
 *      para 1 deles
 * Para obter algo, usa-se o GET
 */
public class MercadoriasController {
    @Autowired
    MercadoriasService service;

    @PostMapping("/salva")
    public ResponseEntity salvar(@RequestBody MercadoriasDTO dto) {
        Mercadorias mercadoria = Mercadorias.builder().descricao(dto.getDescricao()).build();
        
        try {
            Mercadorias salvo = service.salvar(mercadoria);
            return new ResponseEntity(salvo, HttpStatus.CREATED);
        } catch (RegraNegocioRunTime e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
  
    }

    @PostMapping("/venda")
    public ResponseEntity venderMerc(@RequestBody Venda_mercadoriaDTO dto){
        
        Vendas venda = Vendas.builder()
                        .data_venda(dto.getVenda()
                            .getData_venda())
                                .build();
        
        Mercadorias mercadoria = Mercadorias.builder()
                                .descricao(dto.getMercadoria()
                                    .getDescricao())
                                        .build();

        Venda_mercadoria vendaMerc = Venda_mercadoria.builder()
                                        .mercadoria(mercadoria)
                                        .venda(venda)
                                            .build();
        try {
            service.venderMercadoria(mercadoria, venda, vendaMerc);
            return ResponseEntity.ok(true);

        } catch (RegraNegocioRunTime e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        
    }


    

}
