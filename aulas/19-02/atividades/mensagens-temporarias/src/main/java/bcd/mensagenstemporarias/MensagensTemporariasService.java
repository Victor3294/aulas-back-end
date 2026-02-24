package bcd.mensagenstemporarias;

import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class MensagensTemporariasService {

    public HashMap<String, Deque<Mensagem>> mapaDeMensagensTemporaria = new HashMap<>();

    public MensagensTemporariasService(){}

    public void adicionarMensagem(String chave, String conteudo){
        Mensagem msg = new Mensagem(conteudo);
        if(!mapaDeMensagensTemporaria.containsKey(chave)){
            Deque<Mensagem> lista = new ArrayDeque<>();
            mapaDeMensagensTemporaria.put(chave, lista);
        }
        mapaDeMensagensTemporaria.get(chave).add(new Mensagem(conteudo));
    }

    public Mensagem listarMensagem(String chave){
        if(mapaDeMensagensTemporaria.containsKey(chave)){
            Mensagem msg = new Mensagem(mapaDeMensagensTemporaria.get(chave).getLast().conteudo());
            mapaDeMensagensTemporaria.get(chave).pop();
            return msg;
        }
        return null;
    }

}
