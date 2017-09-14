package br.estacio.progII.ex01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ex01Class {

	private int numeroTabuada, numeroInicioTabuada, numeroFimTabuada;

	// Constructor
	public Ex01Class(int numeroTabuada, int numeroInicioTabuada, int numeroFimTabuada) {

		setNumeroTabuada(numeroTabuada);
		setNumeroInicioTabuada(numeroInicioTabuada);
		setNumeroFimTabuada(numeroFimTabuada);
	}

	// getters and setters
	void setNumeroTabuada(int numeroTabuada) {
		this.numeroTabuada = numeroTabuada;
	}

	void setNumeroInicioTabuada(int numeroInicioTabuada) {
		this.numeroInicioTabuada = numeroInicioTabuada;
	}

	void setNumeroFimTabuada(int numeroFimTabuada) {
		this.numeroFimTabuada = numeroFimTabuada;
	}

	private int getNumeroTabuada() {
		return numeroTabuada;
	}

	private int getNumeroInicioTabuada() {
		return numeroInicioTabuada;
	}

	private int getNumeroFimTabuada() {
		return numeroFimTabuada;
	}

	List<String> calculo() {

		List<String> listaResultado = new LinkedList<String>();

		int numeroInicio = this.getNumeroInicioTabuada(), resultadoCalculo = 0;
		for (int i = this.getNumeroInicioTabuada(); i <= this.getNumeroFimTabuada(); i++) {
			resultadoCalculo = this.getNumeroTabuada() * numeroInicio++;
			listaResultado.add(String.valueOf(resultadoCalculo));
		}

		return listaResultado;

	}

	List<String> geraListaResultadoFormatado(List<String> _listaResultados) {

		List<String> listaFormatada = new ArrayList<String>();
		int inicial = getNumeroInicioTabuada();
		String formatacao;
		for (String resultado : _listaResultados) {
			formatacao = this.getNumeroTabuada() + " * " + (inicial++) + " = " + resultado + " /  ";
			listaFormatada.add(formatacao);
		}

		return listaFormatada;
	}

}
