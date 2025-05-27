package l2code.yanmiranda.api.service;

import l2code.yanmiranda.api.domain.caixa.Caixa;
import l2code.yanmiranda.api.domain.pedidos.Pedido;
import l2code.yanmiranda.api.domain.pedidos.request.PedidoRequest;
import l2code.yanmiranda.api.domain.pedidos.response.PedidoResponse;
import l2code.yanmiranda.api.domain.produto.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmbalagemService {

    private static final String WITHOUT_BOX = "Sem caixa adequada";

    private final List<Caixa> availableBoxes = List.of(
            new Caixa("Caixa 1", 30, 40, 80),
            new Caixa("Caixa 2", 80, 50, 40),
            new Caixa("Caixa 3", 50, 80, 60)
    );

    public List<PedidoResponse> processOrders(PedidoRequest pedidoRequest) {
        return pedidoRequest.getPedidos().stream()
                .map(this::processSingleOrder)
                .toList();
    }

    private PedidoResponse processSingleOrder(Pedido pedido) {
        Map<String, List<String>> alocacoes = new HashMap<>();
        Map<String, String> observacoes = new HashMap<>();

        for (Produto product : pedido.getProdutos()) {
            Caixa caixa = findMostSuitableBox(product);
            String key = (caixa != null) ? caixa.getNome() : WITHOUT_BOX;

            alocacoes.computeIfAbsent(key, k -> new ArrayList<>())
                    .add(product.getProduto_id());

            if (caixa == null) {
                observacoes.put(key, "Produto não cabe em nenhuma caixa disponível.");
            }
        }

        List<PedidoResponse.CaixaResultado> usedBoxes = alocacoes.entrySet().stream()
                .map(entry -> new PedidoResponse.CaixaResultado(
                        WITHOUT_BOX.equals(entry.getKey()) ? null : entry.getKey(),
                        entry.getValue(),
                        observacoes.get(entry.getKey())
                ))
                .toList();

        return new PedidoResponse(pedido.getPedido_id(), usedBoxes);
    }

    private Caixa findMostSuitableBox(Produto produto) {
        return availableBoxes.stream()
                .filter(c -> produto.getDimensoes().cabeEm(c))
                .min(Comparator.comparing(Caixa::getVolume))
                .orElse(null);
    }
}
