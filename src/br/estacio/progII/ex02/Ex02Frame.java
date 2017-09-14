package br.estacio.progII.ex02;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class Ex02Frame extends JFrame {
	// JPanel principais do Frame
	JPanel jpSuperior;
	JPanel jpCentral;
	JPanel jpInferior;
	// Layout padrão do Jframe
	BorderLayout layoutFrame = new BorderLayout();
	// Componentes do JpSuperior
	JLabel jlSalarioBruto;
	JTextField jtSalarioBruto;
	JButton jbCalcular;
	JCheckBox jcbFormatar;
	// Componentes do jpCentral
	JLabel jlBaseInss;
	JTextField jtBaseInss;
	JLabel jlDescontoInss;
	JTextField jtDescontoInss;
	JLabel jlBaseIrpf;
	JTextField jtBaseIrpf;
	JLabel jlDescontoIrpf;
	JTextField jtDescontoIrpf;
	// Componentes JpInferior
	JLabel jlSalarioLiquido;
	JTextField jtSalarioLiquido;

	public Ex02Frame() {
		this.configuraJframePrincipal();
		this.instanciaElementosJframe();
		this.adicionaComponentesJframe();
		this.eventos();
		this.setVisible(true);
	}

	private void eventos() {
		jbCalcular.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double salarioBruto = Double.parseDouble(jtSalarioBruto.getText());

				Ex02Class classeCalculo = new Ex02Class(salarioBruto);

				try {
					if (!jcbFormatar.isSelected()) {
						NumberFormat numberFormat = new DecimalFormat("###0.00",
								new DecimalFormatSymbols(new Locale("pt", "BR")));
						jtBaseInss.setText(String.valueOf(numberFormat.format(classeCalculo.getSalarioBruto())));
						jtDescontoInss.setText(String.valueOf(numberFormat.format(classeCalculo.getDescontoInss())));
						jtBaseIrpf.setText(String.valueOf(numberFormat.format(classeCalculo.getBaseIrpf())));
						jtDescontoIrpf.setText(String.valueOf(numberFormat.format(classeCalculo.getDescontoIrpf())));
						jtSalarioLiquido
								.setText(String.valueOf(numberFormat.format(classeCalculo.getSalarioLiquido())));
					} else {
						NumberFormat numberFormat = new DecimalFormat("R$ #,##0.00",
								new DecimalFormatSymbols(new Locale("pt", "BR")));
						jtBaseInss.setText(String.valueOf(numberFormat.format(classeCalculo.getSalarioBruto())));
						jtDescontoInss.setText(String.valueOf(numberFormat.format(classeCalculo.getDescontoInss())));
						jtBaseIrpf.setText(String.valueOf(numberFormat.format(classeCalculo.getBaseIrpf())));
						jtDescontoIrpf.setText(String.valueOf(numberFormat.format(classeCalculo.getDescontoIrpf())));
						jtSalarioLiquido
								.setText(String.valueOf(numberFormat.format(classeCalculo.getSalarioLiquido())));
					}

				} catch (Exception ex) {
					System.out.println(ex.getStackTrace());
				}

			}
		});
	}

	private void adicionaComponentesJframe() {
		this.add(jpSuperior, BorderLayout.PAGE_START);
		this.add(jpCentral, BorderLayout.CENTER);
		this.add(jpInferior, BorderLayout.PAGE_END);
	}

	private void instanciaElementosJframe() {

		// Configuração JpSuperior
		jpSuperior = new JPanel(new FlowLayout());
		//
		jlSalarioBruto = new JLabel("Salário bruto:");
		jtSalarioBruto = new JTextField("5000",10);
		jbCalcular = new JButton("Calcular");
		jbCalcular.setPreferredSize(new Dimension(85, 20));
		jcbFormatar = new JCheckBox("Formatar");

		jpSuperior.add(jlSalarioBruto);
		jpSuperior.add(jtSalarioBruto);
		jpSuperior.add(jbCalcular);
		jpSuperior.add(jcbFormatar);
		///////////////////////////
		// Configuração JpCentral
		jpCentral = new JPanel(new GridLayout(4, 1));
		//
		jlBaseInss = new JLabel("Base INSS:");
		jlDescontoInss = new JLabel("Desconto INSS:");
		jlBaseIrpf = new JLabel("Base IRPF:");
		jlDescontoIrpf = new JLabel("Desconto IRPF:");
		//
		jtBaseInss = new JTextField(10);
		jtDescontoInss = new JTextField(10);
		jtBaseIrpf = new JTextField(10);
		jtDescontoIrpf = new JTextField(10);
		//
		jpCentral.add(jlBaseInss);
		jpCentral.add(jtBaseInss);
		jpCentral.add(jlDescontoInss);
		jpCentral.add(jtDescontoInss);
		jpCentral.add(jlBaseIrpf);
		jpCentral.add(jtBaseIrpf);
		jpCentral.add(jlDescontoIrpf);
		jpCentral.add(jtDescontoIrpf);
		///////////////////////////
		// Configuração JpInferior
		jpInferior = new JPanel(new FlowLayout());
		//
		jlSalarioLiquido = new JLabel("Salário líquido:");
		jtSalarioLiquido = new JTextField(10);
		//
		jpInferior.add(jlSalarioLiquido);
		jpInferior.add(jtSalarioLiquido);
	}

	private void configuraJframePrincipal() {
		this.setTitle("Calculador de Salário");
		this.setLayout(layoutFrame);
		this.setSize(380, 200);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
