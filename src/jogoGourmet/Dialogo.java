package jogoGourmet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import javax.swing.JOptionPane;

public class Dialogo {

	private static List<Comida> comidas = new ArrayList<Comida>();
	private String response;
	private static Integer result;
	private static Integer achou;
	private static String novaComida;
	private static String novaCaracteristica;
	private static List<Comida> sortComidas = new ArrayList<Comida>();
	private static List<Comida> comidasRestantes = new ArrayList<Comida>();

	public static void main(String[] args) {

		inicializarComidas();

		do {
			sortComidas.addAll(comidas);
			comidasRestantes.addAll(comidas);

			JOptionPane.showMessageDialog(null, "Pense em um prato que gosta");

			for (Comida sort : sortComidas) {
				for (String caracteristica : sort.getCaracteristicas()) {
					result = JOptionPane.showConfirmDialog(null, "O prato que você pensou é " + caracteristica + "?");

					if (result.equals(JOptionPane.NO_OPTION)) {

						for (Iterator iterator = comidas.iterator(); iterator.hasNext();) {
							Comida comida2 = (Comida) iterator.next();
							if (comida2.getCaracteristicas().contains(caracteristica)) {
								comidasRestantes.remove(comida2);
							}
						}

					} else if (result.equals(JOptionPane.YES_OPTION)) {

						for (Iterator iterator = comidas.iterator(); iterator.hasNext();) {
							Comida comida2 = (Comida) iterator.next();
							if (!comida2.getCaracteristicas().contains(caracteristica)) {
								comidasRestantes.remove(comida2);
							}
						}
					} else {
						break;
					}
					if (comidasRestantes.size() == 1) {
						achou = JOptionPane.showConfirmDialog(null,
								"O prato que você pensou é  " + comidasRestantes.get(0).getNome() + "?");

						if (achou.equals(JOptionPane.OK_OPTION)) {
							JOptionPane.showMessageDialog(null, "Acertei de novo!");
						} else if (achou.equals(JOptionPane.NO_OPTION)) {
							adicionarComida();
						}
						break;
					}

				}

				if (result == JOptionPane.CANCEL_OPTION || result == JOptionPane.CLOSED_OPTION) {
					break;
				}

			}

			limpar();

		} while (result != JOptionPane.CANCEL_OPTION && result != JOptionPane.CLOSED_OPTION);

	}

	public void adivinhaComida() {

	}

	public static void inicializarComidas() {

		List<String> caracteristicas1 = new ArrayList<String>();
		List<String> caracteristicas2 = new ArrayList<String>();
		List<String> caracteristicas3 = new ArrayList<String>();

		caracteristicas1.add("doce");
		caracteristicas2.add("massa");
		caracteristicas3.add("salgado");

		comidas.add(new Comida(caracteristicas1, "bolo"));
		comidas.add(new Comida(caracteristicas2, "lasanha"));
		comidas.add(new Comida(caracteristicas3, "pastel"));

	}

	public static void adicionarComida() {
		novaComida = JOptionPane.showInputDialog(null, "Em qual comida você pensou?");
		novaCaracteristica = JOptionPane.showInputDialog(null,
				novaComida + " é ____________ mas " + comidas.get(0).getNome() + " não.");
		comidas.add(new Comida(Arrays.asList(novaCaracteristica), novaComida));
	}

	public static void limpar() {
		sortComidas.clear();
		comidasRestantes.clear();
		achou = null;
		novaCaracteristica = null;
		novaCaracteristica = null;
	}

}
