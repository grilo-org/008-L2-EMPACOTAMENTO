package l2code.yanmiranda.api.domain.produto;

import l2code.yanmiranda.api.domain.dimensoes.Dimensoes;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Produto {
    private String produto_id;
    private Dimensoes dimensoes;

    public Produto(String produto_id, Dimensoes dimensoes) {
        this.produto_id = produto_id;
        this.dimensoes = dimensoes;
    }
}

