package l2code.yanmiranda.api.domain.pedidos;

import l2code.yanmiranda.api.domain.produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Pedido {
    private int pedido_id;
    private List<Produto> produtos;
}
