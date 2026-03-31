package bcd.calculadora.service;

import bcd.calculadora.dto.CalculadoraDTO;
import bcd.calculadora.dto.CalculadoraOperacaoDTO;
import bcd.calculadora.model.Calculadora;
import bcd.calculadora.repository.CalculadoraRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {
    private final CalculadoraRepository calculadoraRepository;

    public CalculadoraService(CalculadoraRepository calculadoraRepository) {
        this.calculadoraRepository = calculadoraRepository;
    }

    public CalculadoraDTO criarCalculadora () {
        CalculadoraDTO calculadoraDTO = new CalculadoraDTO();
        Calculadora calculadora = new Calculadora();
        calculadoraRepository.save(calculadora);
        return calculadoraDTO;
    }

    public CalculadoraDTO pegarAcumulador (long id) {
        Calculadora calculadora = calculadoraRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Calculadora não encontrada"));
        return new CalculadoraDTO(calculadora.getAcumulador());
    }

    public void resetaCalculadora (long id) {
        Calculadora calculadora = calculadoraRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Calculadora não encontrada"));
        calculadora.setAcumulador(0);
        calculadoraRepository.save(calculadora);
    }

    public void apagarCalculadora (long id) {
        Calculadora calculadora = calculadoraRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Calculadora não encontrada"));
        calculadoraRepository.delete(calculadora);
    }

    public CalculadoraDTO realizaOperacao (long id, CalculadoraOperacaoDTO calculadoraOperacaoDTO) {
        Calculadora calculadora = calculadoraRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Calculadora não encontrada"));
        switch (calculadoraOperacaoDTO.getOperacao()) {
            case "somar":
                calculadoraOperacaoDTO.setAcumulador();
        }
    }
}
