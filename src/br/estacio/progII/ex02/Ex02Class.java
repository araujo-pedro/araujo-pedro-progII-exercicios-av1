package br.estacio.progII.ex02;

import java.math.BigDecimal;

public class Ex02Class {
	private double salarioBruto, baseInss, descontoInss, baseIrpf, descontoIrpf, salarioLiquido;

	private void setSalarioBruto(double salarioBruto) {
		this.salarioBruto = salarioBruto;
	}

	private void setBaseInss(double baseInss) {
		this.baseInss = baseInss;
	}

	private void setDescontoInss(double descontoInss) {
		this.descontoInss = descontoInss;
	}

	private void setBaseIrpf(double baseIrpf) {
		this.baseIrpf = baseIrpf;
	}

	private void setDescontoIrpf(double descontoIrpf) {
		this.descontoIrpf = descontoIrpf;
	}

	private void setSalarioLiquido(double salarioLiquido) {
		this.salarioLiquido = salarioLiquido;
	}

	////

	double getDescontoInss() {
		return descontoInss;
	}

	double getBaseInss() {
		return baseInss;
	}

	double getSalarioBruto() {
		return salarioBruto;
	}

	double getDescontoIrpf() {
		return descontoIrpf;
	}

	double getSalarioLiquido() {
		return salarioLiquido;
	}

	double getBaseIrpf() {
		return baseIrpf;
	}
	///

	Ex02Class(double _salarioBruto) {
		this.setSalarioBruto(_salarioBruto);
		this.setBaseInss(_salarioBruto);
		this.calculaDeducoes();
	}

	void calculaDeducoes() {
		this.calculaDescontoInss();
		this.calculaDescontoIR();
		this.calculaSalarioLiquido();

	}

	private void calculaDescontoInss() {

		double valorDesconto = 0;
		double aliquotaDefinida = this.defineAliquotaDescontoInss(this.getSalarioBruto());

		if (aliquotaDefinida != 0) {
			valorDesconto = this.getSalarioBruto() * aliquotaDefinida;
		} else {
			valorDesconto = 608.45;
		}

		this.setDescontoInss(valorDesconto);

	}

	private double defineAliquotaDescontoInss(double baseCalculoInss) {
		if (baseCalculoInss <= 1659.38)
			return 0.08;
		if (baseCalculoInss >= 1659.39 && baseCalculoInss <= 2765.66)
			return 0.09;
		if (baseCalculoInss >= 2765.67 && baseCalculoInss <= 5531.31)
			return 0.11;

		return 0;
	}

	private void calculaDescontoIR() {
		// Verificar a aliquota correspondente a base de calculo
		double baseCalculoIR, aliquota = 0, deducao = 0, resultadoCalculo;

		baseCalculoIR = this.getSalarioBruto() - this.getDescontoInss();
		this.setBaseIrpf(baseCalculoIR);

		if (baseCalculoIR > 1903.98) {

			if (baseCalculoIR >= 1903.99 && baseCalculoIR <= 2826.65) {
				aliquota = 0.075;
				deducao = 142.80;
			} else if (baseCalculoIR >= 2826.66 && baseCalculoIR <= 3751.05) {
				aliquota = 0.15;
				deducao = 354.80;
			} else if (baseCalculoIR >= 3751.06 && baseCalculoIR <= 4664.68) {
				aliquota = 0.225;
				deducao = 636.13;
			} else {
				aliquota = 0.275;
				deducao = 869.36;
			}
		}

		resultadoCalculo = (baseCalculoIR * aliquota) - deducao;

		if (resultadoCalculo != 0) {
			this.setDescontoIrpf(resultadoCalculo);
		}
	}

	private void calculaSalarioLiquido() {
		double resultadoCalculo = this.getSalarioBruto() - this.getDescontoInss() - this.getDescontoIrpf();
		this.setSalarioLiquido(resultadoCalculo);
	}

}
