## Teste prático de automação - http://187.35.155.198:5722/Login.aspx

### Como executar o cenário ?
#### src/test/java > Executar > CucumberExecute.java > Botão direito do mouse > Run As > 1 JUnit Test

#### ou

#### src/test/java > features > feature_auditeste.feature > Botão direito do mouse > 1 Cucumber Feature


### Feature:

```java
#enconding: utf-8
Feature: Auditeste CA 
	Como usuáro
  Quero preencher informações
  Para continuar o processo 
  	
Background: 
	Given que acesso o sistema "http://187.35.155.198:5722/Login.aspx" 
	
@LoginSucesso 
Scenario: Deve validar login com sucesso 
	Given optp por verificar campos existentes 
	And opto por preencher email "veron.oliveira@auditeste.com.br" 
	And opto por preencher senha "auditeste" 
	When opto por clicar em Entrar 
	Then opto por verificar usuario logado "Ana Sousa" 
	
@erroEmail 
Scenario: Deve validar email 
	Given optp por verificar campos existentes 
	And opto por preencher email "teste@hotmail.com" 
	And opto por preencher senha "teste" 
	When opto por clicar em Entrar 
	Then opto por verificar usuario logado "Ana Sousa" 
	
@erroSenha 
Scenario: Deve validar senha 
	Given optp por verificar campos existentes 
	And opto por preencher email "veron.oliveira@auditeste.com.br" 
	And opto por preencher senha "teste" 
	When opto por clicar em Entrar 
	Then opto por verificar usuario logado "Ana Sousa" 
   ```
   
