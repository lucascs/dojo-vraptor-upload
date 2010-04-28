package br.com.caelum.vraptor.dojo.controller;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.ServletContext;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;

public class ArquivoControllerTest {
	
	private ServletContext context;
	private ArquivoController controller;
	private Mockery mockery;
	
	@Before
	public void setUp() {
		mockery = new Mockery();
		context = mockery.mock(ServletContext.class);
		controller = new ArquivoController(context);
		
	}
	@Test
	public void oArquivoEnviadoDeveEstarSalvo() throws Exception {
		final UploadedFile uf = mockery.mock(UploadedFile.class);
				
		mockery.checking(new Expectations() {{
			one(context).getRealPath("/imagens");
			will(returnValue(new File(".").getAbsolutePath()));
			one(uf).getFile();			
		}});
				
		controller.upload(uf);
		
		mockery.assertIsSatisfied();
		
	}
	
}
