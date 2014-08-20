package test.java.ar.edu.utn.frba.ia.ag;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.regex.Pattern;

import main.java.ar.edu.utn.frba.ia.ag.UTgeNesUtils;

import org.junit.Assert;
import org.junit.Test;

public class UTgeNesUtilsTest {
	
	@Test
	public void testArmarSetter() throws NoSuchFieldException, SecurityException {
		
		Method setter = UTgeNesUtils.armarSetter(new IndividuoDePrueba(), IndividuoDePrueba.class.getDeclaredField("prop1"));
		Assert.assertEquals("setProp1", setter.getName());
		
		Method setterNoCamelCase = UTgeNesUtils.armarSetter(new IndividuoDePrueba(), IndividuoDePrueba.class.getDeclaredField("prop2"));
		Assert.assertTrue("setprop2".equalsIgnoreCase(setterNoCamelCase.getName()));
		Assert.assertNotEquals("setprop2", setterNoCamelCase.getName());
	}
	
	@Test
	public void testArmarGetter() throws NoSuchFieldException, SecurityException {
		
		Method getter = UTgeNesUtils.armarGetter(new IndividuoDePrueba(), IndividuoDePrueba.class.getDeclaredField("prop1"));
		Assert.assertEquals("getProp1", getter.getName());
		
		Method getterNoCamelCase = UTgeNesUtils.armarGetter(new IndividuoDePrueba(), IndividuoDePrueba.class.getDeclaredField("prop2"));
		Assert.assertTrue("getprop2".equalsIgnoreCase(getterNoCamelCase.getName()));
		Assert.assertNotEquals("getprop2", getterNoCamelCase.getName());
	}
	
	@Test
	public void testAlguno() {
		
		Integer numeros[] = {0};
		Assert.assertEquals(0, UTgeNesUtils.alguno(numeros));
		
		Integer unoADiez[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		Integer numero = (Integer)UTgeNesUtils.alguno(unoADiez);
		Assert.assertNotNull(unoADiez);
		Assert.assertTrue(Arrays.asList(unoADiez).contains(numero));
	}
	
	@Test
	public void testArmarRandomString() {
		
		Assert.assertEquals("", UTgeNesUtils.armarRandomString(0));
		
		String randomString10 = UTgeNesUtils.armarRandomString(10);
		Assert.assertEquals(10, randomString10.length());
		
		Assert.assertTrue(Pattern.compile("[a-z]+").matcher(randomString10).matches());
	}
	
}
