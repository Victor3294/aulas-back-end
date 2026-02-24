package bcd.mensagenstemporarias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MensagensTemporariasController {

    @Autowired
    MensagensTemporariasService mensagensTemporariasService;

    @PostMapping("/mensageiro/publica/{chave}")
    public ResponseEntity<String> publicarMensagem(@PathVariable String chave, @RequestBody Mensagem mensagem) {
        mensagensTemporariasService.adicionarMensagem(chave,mensagem.conteudo());
        return ResponseEntity.ok("Mensagem gravada");
    }

    @GetMapping("/mensageiro/acessa/{chave}")
    public ResponseEntity<String> listarUltimaMensagem(@PathVariable String chave) {
        Mensagem msg = mensagensTemporariasService.listarMensagem(chave);
        if(msg == null){
            return ResponseEntity.status(404).body("Chave não encontrada");
        }
        return ResponseEntity.ok(msg.conteudo());
    }

}
