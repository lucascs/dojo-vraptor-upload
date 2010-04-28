package br.com.caelum.vraptor.dojo.controller;

import java.io.ByteArrayInputStream;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dojo.util.Arquivo;
import br.com.caelum.vraptor.dojo.util.Diretorio;
import br.com.caelum.vraptor.interceptor.download.Download;
import br.com.caelum.vraptor.interceptor.download.InputStreamDownload;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.view.Results;

@Resource
public class ArquivoController {
    
	private final Diretorio diretorio;
	private final Result result;

	public ArquivoController(Diretorio diretorio, Result result) {
		this.diretorio = diretorio;
		this.result = result;
	}
	
	@Path("/")
	public void comecaUpload() {
		
	}

	@Path("/arquivos") @Post
	public void upload(UploadedFile arquivo) {
		diretorio.salva(arquivo.getFileName(), arquivo.getFile());
		
		result.redirectTo(this).lista();	
	}
	
	@Path("/arquivos") @Get
	public void lista() {
		result.include("arquivos", diretorio.listaArquivos());
	}
	
	@Path("/arquivos/{arquivo.nome}") @Get
	public Download download(Arquivo arquivo) {
		ByteArrayInputStream stream = (ByteArrayInputStream) diretorio.getArquivo(arquivo);
		
		if (stream == null) {
			result.notFound();
			return null;
		}
		return new InputStreamDownload(stream, 
				"text/plain", arquivo.getNome(), true, stream.available());
	}
	
	@Path("/arquivos/{arquivo.nome}") @Delete
	public void delete(Arquivo arquivo) {
		diretorio.remove(arquivo);
		
		result.redirectTo(this).lista();
	}

}
