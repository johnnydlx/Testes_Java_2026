package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContaBancariaTest {

    @Test
    void depositarValorValidoDeveAumentarSaldo() {
        // ARRANGE
        ContaBancaria conta = new ContaBancaria("Maria", "123");

        // ACT
        conta.depositar(100.0);

        // ASSERT
        assertEquals(100.0, conta.getSaldo(), 0.001);
    }

    @Test
    void sacarValorMaiorQueSaldoDeveLancarExcecao() {
        // ARRANGE
        ContaBancaria conta = new ContaBancaria("Maria", "123");

        // ACT + ASSERT
        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> conta.sacar(50.0)
        );

        assertEquals("Saldo insuficiente", excecao.getMessage());
    }

    @Test
    void sacarComSaldoDisponivelDeveReduzirSaldo() {
        // ARRANGE
        ContaBancaria conta = new ContaBancaria("Maria", "123");
        conta.depositar(100.0);

        // ACT + ASSERT
        assertDoesNotThrow(() -> conta.sacar(40.0));

        // ASSERT
        assertEquals(60.0, conta.getSaldo(), 0.001);
    }

    @Test
    void depositarZeroDeveLancarExcecao() {
        ContaBancaria conta = new ContaBancaria("Maria", "123");

        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> conta.depositar(0.0)
        );

        assertEquals("O valor do depósito deve ser maior que zero.", excecao.getMessage());
    }

    @Test
    void sacarValorNegativoDeveLancarExcecao() {
        ContaBancaria conta = new ContaBancaria("Maria", "123", 100.0);

        assertThrows(
                IllegalArgumentException.class,
                () -> conta.sacar(-20.0)
        );
    }

    @Test
    void construtorDeveInicializarTodosOsAtributos() {
        // ARRANGE + ACT
        ContaBancaria conta = new ContaBancaria("João", "99999-9");

        // ASSERT
        assertAll(
                "Dados iniciais da conta",
                () -> assertEquals("João", conta.getTitular()),
                () -> assertEquals("99999-9", conta.getNumeroConta()),
                () -> assertEquals(0.0, conta.getSaldo(), 0.001)
        );
    }
}