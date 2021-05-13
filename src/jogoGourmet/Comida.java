package jogoGourmet;

import java.util.List;

public class Comida {

	private List<Caracteristica> caracteristica;
	
	private  String nome;

	public List<Caracteristica> getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(List<Caracteristica> caracteristica) {
		this.caracteristica = caracteristica;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Comida(List<Caracteristica> caracteristica, String nome) {
		super();
		this.caracteristica = caracteristica;
		this.nome = nome;
	}
	

	
}
