package bcd.calculadora.repository;

import bcd.calculadora.model.Calculadora;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalculadoraRepository extends JpaRepository<Calculadora, Long> {
    Calculadora getCalculadoraById(long id);
}
