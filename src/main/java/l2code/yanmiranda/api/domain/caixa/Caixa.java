package l2code.yanmiranda.api.domain.caixa;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Caixa {
    private final String nome;
    private final Integer altura;
    private final Integer largura;
    private final Integer profundidade;

    public Caixa(String nome, int altura, int largura, int profundidade) {
        this.nome = nome;
        this.altura = altura;
        this.largura = largura;
        this.profundidade = profundidade;
    }

    public int getVolume() {
        return altura * largura * profundidade;
    }
}
