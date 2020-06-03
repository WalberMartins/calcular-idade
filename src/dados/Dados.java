package dados;

import java.util.ArrayList;
import java.util.List;

import entidades.Usuario;

public class Dados {
		
	private static List<Usuario> lista = new ArrayList<Usuario>();
	
	private Dados() {
		
	}
	
	public static List<Usuario> getList() {
		return lista;
	}

}
