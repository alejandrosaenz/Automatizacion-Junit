package com.qualitystream.tutorial;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
	
	private WebDriver driver;
	
	

	@Before
	public void setUp() {
		// carga el driver
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		// crear el objeto webdriver
		driver = new ChromeDriver();
		// abre una instancia del navegador
		driver.manage().window().maximize();
		// url que queremos abrir
		driver.get("https://www.choucairtesting.com/empleos-testing/");
	}

	@Test
	public void testGooglePage() {
		// obtiene la caja de búsqueda de google
		WebElement searchbox = driver.findElement(By.name("search_keywords"));
		// limpia la caja de búsqueda
		//searchbox.clear();
		// contenido que deseas buscar
		searchbox.sendKeys("Automatización");
		// envia el texto
		searchbox.submit();
		// tiempo de carga de los resultados de búsqueda
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// el contenido de búsqueda debe ser igual al título de la página de resultado
		//assertEquals("empleos testing - Choucair Testing", driver.getTitle()); // nota: se tiene que poner "- Buscar con 		//Google" o "- Google Search" para que el resultado coincida

	}
	
	@Test
	public void testGooglePage1() {
		// obtiene la caja de búsqueda de google
		WebElement searchbox = driver.findElement(By.name("search_location"));
		// limpia la caja de búsqueda
		//searchbox.clear();
		// contenido que deseas buscar
		searchbox.sendKeys("Bogota");
		// envia el texto
		searchbox.submit();
		// tiempo de carga de los resultados de búsqueda
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// el contenido de búsqueda debe ser igual al título de la página de resultado
		//assertEquals("empleos testing - Choucair Testing", driver.getTitle()); // nota: se tiene que poner "- Buscar con 		//Google" o "- Google Search" para que el resultado coincida

	}

	@After
	public void tearDown() {
		// cierra el navegador una vez que completa la prueba
		//driver.quit();
	}

}
