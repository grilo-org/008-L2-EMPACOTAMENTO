package l2code.yanmiranda.api.domain.pedidos.request;

import l2code.yanmiranda.api.domain.pedidos.Pedido;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PedidoRequest {
    private List<Pedido> pedidos;
}

