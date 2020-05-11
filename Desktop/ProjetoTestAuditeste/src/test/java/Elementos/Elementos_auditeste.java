package Elementos;

import org.openqa.selenium.By;

public class Elementos_auditeste {

private By txtEmail = By.xpath("//input[@type='email']");
	
	private By txtSenha = By.xpath("//input[@type='password']");
	
	private By btnEntrar = By.xpath("//a[@id='MainContent_BtnEntrar']");

	public By getTxtEmail() {
		return txtEmail;
	}

	public By getTxtSenha() {
		return txtSenha;
	}

	public By getBtnEntrar() {
		return btnEntrar;
	}
	
	private By linkUsuarioLogado = By.xpath("//*[@id='ctl01']/div[4]/p/b[1]");
	
	public By getLinkUsuarioLogado() {
		return linkUsuarioLogado;
	}

	private By labelError = By.xpath("//span[@id='MainContent_lbl_Msg']");
	
	public By getLabelError() {
		return labelError;
	}



}
