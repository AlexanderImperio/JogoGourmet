package jogoGourmet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import javax.swing.JOptionPane;

public class AdivinharComida {

	private static List<Comida> comidas = new ArrayList<Comida>();
	private static Integer result;
	private static Integer achou;
	private static String novaComida;
	private static String novaCaracteristica;
	private static Boolean acertei;
	private static List<Comida> sortComidas = new ArrayList<Comida>();
	private static List<Comida> comidasRestantes = new ArrayList<Comida>();
	private static List<String> caracteristicasAdicionais = new ArrayList<String>();
	private static List<String> caracteristicasRestantes = new ArrayList<String>();
	private static List<String> caracteristicas = new ArrayList<String>();

	public static void main(String[] args) {

		inicializarComidas();
		result = JOptionPane.OK_OPTION;

		do {
			sortComidas.addAll(comidas);
			comidasRestantes.addAll(comidas);
			caracteristicasRestantes.addAll(caracteristicas);
			caracteristicasAdicionais.clear();

			JOptionPane.showMessageDialog(null, "Pense em um prato que gosta");

			for (Comida sort : sortComidas) {
				if (Objects.nonNull(achou)
						&& (achou.equals(JOptionPane.OK_OPTION) || achou.equals(JOptionPane.NO_OPTION))) {
					break;
				}
				for (String caracteristica : caracteristicas) {

					result = JOptionPane.showConfirmDialog(null, "O prato que você pensou é " + caracteristica + "?");

					if (result.equals(JOptionPane.NO_OPTION)) {

						for (Iterator iterator = comidas.iterator(); iterator.hasNext();) {
							Comida comida = (Comida) iterator.next();
							if (comida.getCaracteristicas().contains(caracteristica)) {
								comidasRestantes.remove(comida);
							}
						}

						caracteristicasRestantes.remove(caracteristica);

					} else if (result.equals(JOptionPane.YES_OPTION)) {

						caracteristicasAdicionais.add(caracteristica);

						for (Iterator iterator = comidas.iterator(); iterator.hasNext();) {
							Comida comida = (Comida) iterator.next();
							if (!comida.getCaracteristicas().contains(caracteristica)) {
								comidasRestantes.remove(comida);
							}
						}

						break;
					} else {
						break;
					}
					if (verificaComidasRestantes()) {
						break;
					}

				}
				if (verificaComidasRestantes()) {
					break;
				}
				if (Objects.nonNull(result)
						&& (result == JOptionPane.CANCEL_OPTION || result == JOptionPane.CLOSED_OPTION)) {
					break;
				}

			}

			limpar();

		} while (Objects.isNull(result)
				|| (result != JOptionPane.CANCEL_OPTION && result != JOptionPane.CLOSED_OPTION));

	}

	public static void inicializarComidas() {

		List<String> caracteristicas1 = new ArrayList<String>();
		List<String> caracteristicas2 = new ArrayList<String>();
		List<String> caracteristicas3 = new ArrayList<String>();

		caracteristicas1.add("doce");
		caracteristicas2.add("massa");
		caracteristicas3.add("salgado");

		caracteristicas.add("doce");
		caracteristicas.add("massa");
		caracteristicas.add("salgado");

		comidas.add(new Comida(caracteristicas1, "bolo"));
		comidas.add(new Comida(caracteristicas2, "lasanha"));
		comidas.add(new Comida(caracteristicas3, "pastel"));

	}

	public static void adicionarComida() {
		novaComida = JOptionPane.showInputDialog(null, "Em qual comida você pensou?");
		if (Objects.nonNull(novaComida)) {
			novaCaracteristica = JOptionPane.showInputDialog(null,
					novaComida + " é ____________ mas " + comidas.get(0).getNome() + " não.");
			caracteristicas.add(novaCaracteristica);
			caracteristicasAdicionais.add(novaCaracteristica);
			List<String> novasCaracteristicas = caracteristicasAdicionais;
			comidas.add(new Comida(novasCaracteristicas, novaComida));
			
		}

	}

	public static void verificarCaracteristicasRestante(String validacaracteristica) {
		for (Comida comidaResntante : comidasRestantes) {
			for (String caracteristicaRestante : comidaResntante.getCaracteristicas()) {
				if (!validacaracteristica.equals(caracteristicaRestante)) {
					if (!caracteristicasRestantes.contains(caracteristicaRestante)) {
						caracteristicasRestantes.add(caracteristicaRestante);
					}
				}
			}
		}
	}

	public static Boolean verificaComidasRestantes() {
		Boolean res;

		if (comidasRestantes.size() == 1 || caracteristicasRestantes.size() == 1) {
			achou = showDialog("O prato que você pensou é  " + comidasRestantes.get(0).getNome() + "?");

			if (achou.equals(JOptionPane.OK_OPTION)) {
				JOptionPane.showMessageDialog(null, "Acertei de novo!");
			} else if (achou.equals(JOptionPane.NO_OPTION)) {
				adicionarComida();
			}
			return true;
		} else if (comidasRestantes.size() == 2) {
			String caracteristicaDistinta = caracteristicaDistinta();
			if (caracteristicaDistinta != null) {
				achou = showDialog("O prato que você pensou é  " + caracteristicaDistinta + "?");

				if (achou.equals(JOptionPane.OK_OPTION)) {

					if (comidasRestantes.get(0).getCaracteristicas().contains(caracteristicaDistinta)) {
						achou = showDialog("O prato que você pensou é  " + comidasRestantes.get(0).getNome() + "?");
						res = comidaCorreta(achou);
						if (res) {
							return true;
						} else {
							return false;
						}

					}
				} else if (achou.equals(JOptionPane.NO_OPTION)) {
					adicionarComida();
					return false;
				}

				return false;
			}

		}
		return false;
	}

	public static String caracteristicaDistinta() {
		List<String> caracteristcas1 = comidasRestantes.get(0).getCaracteristicas();
		List<String> caracteristcas2 = comidasRestantes.get(1).getCaracteristicas();

		for (String nome : caracteristcas1) {
			if (!caracteristcas2.contains(nome)) {
				return nome;
			}
		}
		return null;
	}

	public static Boolean comidaCorreta(Integer res) {
		if (res.equals(JOptionPane.OK_OPTION)) {
			JOptionPane.showMessageDialog(null, "Acertei de novo!");
			return true;
		} else if (res.equals(JOptionPane.NO_OPTION)) {
			adicionarComida();
			return false;
		} else {
			return null;
		}
	}

	public static Integer showDialog(String message) {
		Integer res;
		res = JOptionPane.showConfirmDialog(null, message);
		return res;
	}

	public static void limpar() {
		sortComidas.clear();
		comidasRestantes.clear();
		achou = null;
		novaCaracteristica = null;
		novaCaracteristica = null;
		caracteristicasRestantes.clear();
		result = null;
	}

}
