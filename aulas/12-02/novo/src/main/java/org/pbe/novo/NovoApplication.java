package org.pbe.novo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@RestController
@SpringBootApplication
public class NovoApplication {

    record DataHorario (String data, String horario){}
    record Datas(String data) {}
    record Horario(String horario){}

    @GetMapping("/data")
    public Datas data() {
        LocalDate hoje = LocalDate.now();
        var formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return new Datas(formato.format(hoje));
    }

    @GetMapping("/horario")
    public Horario Horarios() {
        LocalTime hoje = LocalTime.now();
        var formato = DateTimeFormatter.ofPattern("hh:mm:ss");
        return new Horario(formato.format(hoje));
    }

    @GetMapping("/agora")
    public DataHorario dataHorario () {
        LocalDateTime hoje = LocalDateTime.now();
        var formatoHorario = DateTimeFormatter.ofPattern("hh:mm:ss");
        var formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return new DataHorario(formatoData.format(hoje), formatoHorario.format(hoje));
    }

    public static void main(String[] args) {
        SpringApplication.run(NovoApplication.class, args);
    }

}
