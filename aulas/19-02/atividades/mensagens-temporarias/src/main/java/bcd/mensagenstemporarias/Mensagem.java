package bcd.mensagenstemporarias;

import java.time.LocalDateTime;

public record Mensagem(String conteudo, LocalDateTime tempoDeVida, int quantidadeDeUsos) {
    public Mensagem {
        if(tempoDeVida == null){
            tempoDeVida = LocalDateTime.now().plusDays(365);
        } if(quantidadeDeUsos <= 0) {
            quantidadeDeUsos = 1;
        }
    }
}
