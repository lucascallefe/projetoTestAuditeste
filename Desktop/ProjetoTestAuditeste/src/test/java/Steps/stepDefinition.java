package Steps;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class stepDefinition extends Elementos.Elementos_auditeste {

	WebDriver driver;

	@Before
	public void BeforeClass() throws IOException {

		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(120, TimeUnit.SECONDS);
	}

	@After
	public void AfterClass() throws InterruptedException {
		Thread.sleep(3000);
		// driver.manage().deleteAllCookies();
		driver.quit();
		driver = null;
	}

	@Given("que acesso o sistema {string}")
	public void que_acesso_o_sistema(String url) {
		driver.get(url);

	}

	@Given("optp por verificar campos existentes")
	public void optp_por_verificar_campos_existentes() {
		if (driver.findElements(getTxtEmail()).size() != 0) {
			System.out.println("O campo email existe na tela");
		} else {
			System.out.println("O campo email não existe na tela");
			driver.close();
		}

		if (driver.findElements(getTxtSenha()).size() != 0) {
			System.out.println("O campo senha existe na tela");

		} else {
			System.out.println("O campo senha não existe na tela");
			driver.close();
		}

	}

	@Given("opto por preencher email {string}")
	public void opto_por_preencher_email(String email) {

		driver.findElement(getTxtEmail()).sendKeys(email);
	}

	@Given("opto por preencher senha {string}")
	public void opto_por_preencher_senha(String senha) {

		driver.findElement(getTxtSenha()).sendKeys(senha);
	}

	@Then("opto por clicar em Entrar")
	public void opto_por_clicar_em_Entrar() throws InterruptedException {
		driver.findElement(getBtnEntrar()).click();

		Thread.sleep(3000);
	}

	@Given("opto por acessar tela inicial com titulo {string}")
	public void opto_por_acessar_tela_inicial_com_titulo(String string) {

	}

	@Given("opto por verificar usuario logado {string}")
	public void opto_por_verificar_usuario_logado(String usuario) {

		if (driver.getCurrentUrl().contains("http://187.35.155.198:5722/Login.aspx")) {

			if (driver.findElement(getLabelError()).getText().contains("E-mail não Localizado")) {
				System.out.println("Mensagem: " + driver.findElement(getLabelError()).getText());
				driver.close();
			} else if (driver.findElement(getLabelError()).getText().contains("Senha não Localizada")) {
				System.out.println("Mensagem: " + driver.findElement(getLabelError()).getText());
				driver.close();
			} else {
				String usuarioLogado = driver.findElement(getLinkUsuarioLogado()).getText();
				System.out.println("==== Usuario: " + usuarioLogado);

				Assert.assertEquals(usuario, usuarioLogado);
				System.out.println("Erro ao realizar login");
			}

		} else {
			System.out.println("não houve erro ao tentar logar");
		}

	}

}
