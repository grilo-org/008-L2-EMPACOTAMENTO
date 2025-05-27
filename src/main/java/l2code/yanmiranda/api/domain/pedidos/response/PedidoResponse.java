package l2code.yanmiranda.api.domain.pedidos.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.List;

public record PedidoResponse(int pedido_id, List<CaixaResultado> caixas) {

    @Getter
    public static class CaixaResultado {
        private final String caixa_id;
        private final List<String> produtos;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private final String observacao;

        public CaixaResultado(String caixa_id, List<String> produtos, String observacao) {
            this.caixa_id = caixa_id;
            this.produtos = produtos;
            this.observacao = observacao;
        }
    }
}

