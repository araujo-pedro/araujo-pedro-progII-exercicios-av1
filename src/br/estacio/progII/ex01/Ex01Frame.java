package br.estacio.progII.ex01;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ex01Frame extends JFrame {

	JPanel jpSuperior;
	JPanel jpCentro;
	//
	JLabel jlTabuada;
	JLabel jlDe;
	JLabel jlAte;
	//
	JTextField jtTabuada;
	JTextField jtDe;
	JTextField jtAte;
	//
	JButton jbCalcular;

	// Layout frame principal
	BorderLayout jfBorderLayout = new BorderLayout(5, 5);

	public Ex01Frame() {
		configuracaoJframe();
		instanciaComponentesFrame();
		addComponentesJframe();
		eventos();
		this.setVisible(true);
	}

	private void eventos() {
		jbCalcular.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				int numeroCalculoTabuada = Integer.parseInt(jtTabuada.getText().trim());
				int numeroDe = Integer.parseInt(jtDe.getText());
				int numeroAte = Integer.parseInt(jtAte.getText());

				Ex01Class classeCalculo = new Ex01Class(numeroCalculoTabuada, numeroDe, numeroAte);

				try {

					jpCentro.removeAll();

					List<String> resultados = classeCalculo.calculo();
					List<String> listaResultadoCalculo = classeCalculo.geraListaResultadoFormatado(resultados);

					for (String valor : listaResultadoCalculo) {
						JLabel jLabel = new JLabel(valor);
						jLabel.setHorizontalAlignment(jLabel.CENTER);
						jpCentro.add(jLabel);
					}
				} finally {

					jpCentro.validate();

				}

			}
		});

	}

	private void configuracaoJframe() {
		this.setTitle("Tabuada Dinamica");
		this.setSize(450, 300);
		this.setLayout(jfBorderLayout);
		//this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void addComponentesJframe() {
		jpSuperior.add(jlTabuada);
		jpSuperior.add(jtTabuada);
		//
		jpSuperior.add(jlDe);
		jpSuperior.add(jtDe);
		//
		jpSuperior.add(jlAte);
		jpSuperior.add(jtAte);
		//
		jpSuperior.add(jbCalcular);
		//
		this.add(jpSuperior, BorderLayout.PAGE_START);
		this.add(jpCentro, BorderLayout.CENTER);
	}

	private void instanciaComponentesFrame() {
		jpSuperior = new JPanel(new FlowLayout());

		jlTabuada = new JLabel("Tabuada do: ");
		jlDe = new JLabel("De: ");
		jlAte = new JLabel("Até: ");
		//
		jtTabuada = new JTextField("5", 5);
		jtDe = new JTextField("5", 5);
		jtAte = new JTextField("9", 5);
		//
		jbCalcular = new JButton("Calcular");
		jbCalcular.setPreferredSize(new Dimension(85, 19));
		//
		jpCentro = new JPanel(new FlowLayout());

	}

}
