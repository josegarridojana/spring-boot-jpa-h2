package com.prueba.spring.jpa.h2;

import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.prueba.spring.jpa.h2.model.Prueba;

@SpringBootTest
class SpringBootPruebaApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	public void pruebaObjectConstructWithEmpty() {
		Prueba prueba = new Prueba();
		prueba.setDescripcion(null);
		prueba.setFechaActualizacion(null);
		prueba.setFechaCreacion(null);
		prueba.setId(new Long(1));
		prueba.setNombre(null);
		prueba.setVigente(false);

		Assert.assertEquals(null, prueba.getDescripcion());
		Assert.assertEquals(null, prueba.getFechaActualizacion());
		Assert.assertEquals(null, prueba.getFechaCreacion());
		Assert.assertEquals(null, prueba.getNombre());
		Assert.assertEquals(null, prueba.getFechaActualizacion());
		Assert.assertEquals(false, prueba.isVigente());

		assertNotNull(prueba.toString());
	}
	
	@Test
	public void pruebaObjectConstructWith() {
		Prueba prueba = new Prueba( null,  null, false);
		prueba.setDescripcion(null);
		prueba.setFechaActualizacion(null);
		prueba.setFechaCreacion(null);
		prueba.setId(new Long(1));
		prueba.setNombre(null);
		prueba.setVigente(false);

		Assert.assertEquals(null, prueba.getDescripcion());
		Assert.assertEquals(null, prueba.getFechaActualizacion());
		Assert.assertEquals(null, prueba.getFechaCreacion());
		Assert.assertEquals(null, prueba.getNombre());
		Assert.assertEquals(null, prueba.getFechaActualizacion());
		Assert.assertEquals(false, prueba.isVigente());

		assertNotNull(prueba.toString());
	}


}
