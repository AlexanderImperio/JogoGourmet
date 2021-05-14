package jogoGourmet;

import java.util.List;

public class Comida {

	private List<String> caracteristicas;
	
	private  String nome;

	public List<String> getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristica(String caracteristicas) {
		this.caracteristicas.add(caracteristicas);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Comida(List<String> caracteristica, String nome) {
		super();
		this.caracteristicas = caracteristica;
		this.nome = nome;
	}
	

	
}
