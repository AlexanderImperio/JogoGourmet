package jogoGourmet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


public class Dialogo {
	

	public static void main(String[] args) {
		String response;
		Integer result;
		
		List<Caracteristica> caracteristicas1 = new ArrayList<Caracteristica>();
		List<Caracteristica> caracteristicas2 = new ArrayList<Caracteristica>();

		List<Comida> comidas = new ArrayList<Comida>();
		List<Comida> sortComidas = new ArrayList<Comida>();

		
		caracteristicas1.add(new Caracteristica("doce"));
		caracteristicas2.add(new Caracteristica("salgado"));		

		comidas.add(new Comida (caracteristicas1, "bolo"));
		
		comidas.add(new Comida(caracteristicas2, "pastel"));
		
		do {
			
			JOptionPane.showMessageDialog(null,"Pense em um prato que gosta");
			
			for (Comida comida : comidas) {	
				for (Caracteristica caracteristica: comida.getCaracteristica()) {
					result = JOptionPane.showConfirmDialog(null, "O prato que você pensou é " + caracteristica.getNome());
					
					if (result.equals(JOptionPane.OK_OPTION)) {
						sortComidas
					}
				}
			}
			
			response = JOptionPane.showInputDialog(null, "teste");
			
			
		} while (response == null);

	}

}
