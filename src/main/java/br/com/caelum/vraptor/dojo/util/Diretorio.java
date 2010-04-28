package br.com.caelum.vraptor.dojo.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;

@Component
@ApplicationScoped
public class Diretorio {

	Map<Arquivo, InputStream> arquivos = new HashMap<Arquivo, InputStream>();
	
	public Diretorio() {
	}

	public void salva(String nome, InputStream conteudo) {
		arquivos.put(new Arquivo(nome), conteudo);
	}

	public Set<Arquivo> listaArquivos() {
		return arquivos.keySet();
	}

	public InputStream getArquivo(Arquivo arquivo) {
		return arquivos.get(arquivo);
	}

	public void remove(Arquivo arquivo) {
		arquivos.remove(arquivo);
	}
}
