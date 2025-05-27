package l2code.yanmiranda.api.controller;

import l2code.yanmiranda.api.domain.pedidos.request.PedidoRequest;
import l2code.yanmiranda.api.domain.pedidos.response.PedidoResponse;
import l2code.yanmiranda.api.service.EmbalagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/embalagem")
public class EmbalagemController {

    @Autowired
    private EmbalagemService embalagemService;

    @PostMapping
    public ResponseEntity<List<PedidoResponse>> packOrders(@RequestBody PedidoRequest pedidoRequest) {
        List<PedidoResponse> resposta = embalagemService.processOrders(pedidoRequest);
        return ResponseEntity.ok(resposta);
    }
}
