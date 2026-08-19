package com.example.demo;

public class ReservaHotel {

    private String nomeHospede;
    private int numeroNoites;
    private int quantidadeHospedes;
    private double valorDiaria;

    public ReservaHotel(String nomeHospede, int numeroNoites, int quantidadeHospedes, double valorDiaria) {
        if (nomeHospede == null || nomeHospede.isBlank()) {
            throw new IllegalArgumentException("Nome do hóspede é obrigatório.");
        }
        if (numeroNoites <= 0) {
            throw new IllegalArgumentException("Número de noites deve ser maior que zero.");
        }
        if (quantidadeHospedes < 1 || quantidadeHospedes > 4) {
            throw new IllegalArgumentException("Quantidade de hóspedes deve ser entre 1 e 4.");
        }
        if (valorDiaria <= 0) {
            throw new IllegalArgumentException("Valor da diária deve ser maior que zero.");
        }

        this.nomeHospede = nomeHospede;
        this.numeroNoites = numeroNoites;
        this.quantidadeHospedes = quantidadeHospedes;
        this.valorDiaria = valorDiaria;
    }

    public double calcularValorTotal() {
        return numeroNoites * valorDiaria * quantidadeHospedes;
    }

    public boolean isReservaLonga() {
        return numeroNoites >= 7;
    }

    // Getters
    public String getNomeHospede() {
        return nomeHospede;
    }

    public int getNumeroNoites() {
        return numeroNoites;
    }

    public int getQuantidadeHospedes() {
        return quantidadeHospedes;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }
}