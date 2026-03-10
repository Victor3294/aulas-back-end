package bcd.mensagenstemporarias;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
@Service
public class MensagensTemporariasService {

    public HashMap<String, Deque<Mensagem>> mapaDeMensagensTemporaria = new HashMap<>();

    public MensagensTemporariasService(){}

    public void adicionarMensagem(String chave, Mensagem mensagem){
        if(!mapaDeMensagensTemporaria.containsKey(chave)){
            Deque<Mensagem> lista = new ArrayDeque<>();
            mapaDeMensagensTemporaria.put(chave, lista);
        }
        mensagem.tempoDeVida().plusSeconds(LocalDateTime.now());
        mapaDeMensagensTemporaria.get(chave).add(mensagem);
    }

    public Mensagem listarMensagem(String chave){
        if(mapaDeMensagensTemporaria.containsKey(chave)){
            if()
        }
        return null;
    }

}
