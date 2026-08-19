package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReservaHotelTest {

    @Test
    void calcularValorTotalDeveMultiplicarNoitesDiariaEHospedes() {

        ReservaHotel reserva = new ReservaHotel("Ana Silva", 3, 2, 150.0);


        double valorTotal = reserva.calcularValorTotal();

        assertEquals(900.0, valorTotal, 0.001);
    }

    @Test
    void reservaComSeteOuMaisNoitesDeveSerConsideradaLonga() {
        ReservaHotel reserva = new ReservaHotel("Carlos", 7, 1, 200.0);

        assertTrue(reserva.isReservaLonga());
    }

    @Test
    void reservaComMenosDeSeteNoitesNaoDeveSerConsideradaLonga() {
        ReservaHotel reserva = new ReservaHotel("Carlos", 5, 1, 200.0);

        assertFalse(reserva.isReservaLonga());
    }

    @Test
    void criarReservaComNumeroDeNoitesInvalidoDeveLancarExcecao() {
        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> new ReservaHotel("Maria", 0, 2, 180.0)
        );

        assertEquals("Número de noites deve ser maior que zero.", excecao.getMessage());
    }

    @Test
    void criarReservaComQuantidadeDeHospedesInvalidaDeveLancarExcecao() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new ReservaHotel("João", 3, 5, 150.0)
        );
    }

    @Test
    void construtorDeveInicializarTodosOsAtributosCorretamente() {
        ReservaHotel reserva = new ReservaHotel("Fernanda", 4, 3, 220.0);

        assertAll(
                "Dados da reserva",
                () -> assertEquals("Fernanda", reserva.getNomeHospede()),
                () -> assertEquals(4, reserva.getNumeroNoites()),
                () -> assertEquals(3, reserva.getQuantidadeHospedes()),
                () -> assertEquals(220.0, reserva.getValorDiaria(), 0.001)
        );
    }
}