package bcd.atividade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@SpringBootApplication
public class AtividadeApplication {

    @GetMapping("/api/verificador/{cpf}")
    public ResponseEntity<String> verificadorSemParametro (@PathVariable String cpf) {
        String cpfCompara = cpf.replaceAll("\\.", "").replaceAll("-", "");
        if(cpfCompara.length() == 11){
            int j = 10;
            int soma = 0;
            for (int i = 0; i < 9 ; i++) {
                int valor = cpfCompara.charAt(i) - '0';
                soma += valor * j;
                j--;
            }
            if((soma * 10) % 11  == cpfCompara.charAt(9) - '0') {
                j = 11;
                soma = 0;
                for (int i = 0; i < 10; i++) {
                    int valor = cpfCompara.charAt(i) - '0';
                    soma += valor * j;
                    j--;
                }
                if((soma * 10) % 11 == cpfCompara.charAt(10) - '0') {
                    return ResponseEntity.ok("cpf valido");
                }
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("cpf invalido");
    }

    @GetMapping("api/verificador")
    public ResponseEntity<String> verificadorComParametro(@RequestParam String cpf) {
        String cpfCompara = cpf.replaceAll("\\.", "").replaceAll("-", "");
        if(cpfCompara.length() == 11){
            int j = 10;
            int soma = 0;
            for (int i = 0; i < 9 ; i++) {
                int valor = cpfCompara.charAt(i) - '0';
                soma += valor * j;
                j--;
            }
            if((soma * 10) % 11  == cpfCompara.charAt(9) - '0') {
                j = 11;
                soma = 0;
                for (int i = 0; i < 10; i++) {
                    int valor = cpfCompara.charAt(i) - '0';
                    soma += valor * j;
                    j--;
                }
                if((soma * 10) % 11 == cpfCompara.charAt(10) - '0') {
                    return ResponseEntity.ok("cpf valido");
                }
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("cpf invalido");
    }

    @PostMapping("/api/verificador")
    public ResponseEntity<String> verificadorPost (@RequestParam String cpf){
        String cpfCompara = cpf.replaceAll("\\.", "").replaceAll("-", "");
        if(cpfCompara.length() == 11){
            int j = 10;
            int soma = 0;
            for (int i = 0; i < 9 ; i++) {
                int valor = cpfCompara.charAt(i) - '0';
                soma += valor * j;
                j--;
            }
            if((soma * 10) % 11  == cpfCompara.charAt(9) - '0') {
                j = 11;
                soma = 0;
                for (int i = 0; i < 10; i++) {
                    int valor = cpfCompara.charAt(i) - '0';
                    soma += valor * j;
                    j--;
                }
                if((soma * 10) % 11 == cpfCompara.charAt(10) - '0') {
                    return ResponseEntity.ok("cpf valido");
                }
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("cpf invalido");
    }


    public static void main(String[] args) {
        SpringApplication.run(AtividadeApplication.class, args);
    }

}
