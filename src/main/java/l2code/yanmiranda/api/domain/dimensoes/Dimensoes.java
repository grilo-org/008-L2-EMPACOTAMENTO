package l2code.yanmiranda.api.domain.dimensoes;

import l2code.yanmiranda.api.domain.caixa.Caixa;

public record Dimensoes(int altura, int largura, int profundidade) {
    public boolean cabeEm(Caixa caixa) {
        return this.altura <= caixa.getAltura()
                && this.largura <= caixa.getLargura()
                && this.profundidade <= caixa.getProfundidade();
    }
}
