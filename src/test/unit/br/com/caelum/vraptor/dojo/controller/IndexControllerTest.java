package br.com.caelum.vraptor.dojo.controller;

import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Before;


public class IndexControllerTest {
	
	private Mockery mockery;

	@Before
	public void setUp() {
		mockery = new Mockery();
		mockery.setImposteriser(ClassImposteriser.INSTANCE);
	}	
	
}
