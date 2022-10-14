package sistemabancario;

import static org.junit.Assert.assertNull;

//Classe de teste criada para garantir o funcionamento das principais operações
//sobre clientes, realizada pela classe
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertFalse;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// Inserindo os testes de limites das regras de negócio:
// Testando a regra de idade

public class GerenciadoraClienteTeste3 {
	
	private GerenciadoraClientes gerClientes;
	
	private int idCliente01 = 1;
	private int idCliente02 = 2;
	
	@Before
	public void setUp() {
		
		//Abrir conexao com o banco e fechar no final do teste		
		
		Cliente cliente01 = new Cliente(idCliente01, "Vitor", 24, "vitorhp@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(idCliente02, "Joao", 60, "joao@gmail.com", 2, true);
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente01);
		clientes.add(cliente02);
		
		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);
	}
	
	@After
	public void tearDown() {
		gerClientes.limpa();
	}
	
	@Test
	public void testPesquisaClient(){
		
		//int idCliente01 = 1;
		//int idCliente02 = 2;
		
		//criando clientes
		//Cliente cliente01 = new Cliente(idCliente01, "Vitor", 24, "vitorhp@gmail.com", 1, true);
		//Cliente cliente02 = new Cliente(idCliente02, "Joao", 60, "joao@gmail.com", 2, true);
		
		//List<Cliente> clientes = new ArrayList<>();
		//clientes.add(cliente01);
		//clientes.add(cliente02);
		
		//GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);
		
		Cliente cliente = gerClientes.pesquisaCliente(idCliente01);
		
		assertThat(cliente.getId(), is(1)); // Responsavel por mandar a mensagem pro junit. 
		assertThat(cliente.getEmail(), is("vitorhp@gmail.com"));;
	}
	
	@Test
	public void testPesquisaClientInexistente(){
				
		Cliente cliente = gerClientes.pesquisaCliente(10);
		
		assertNull(cliente); // Responsavel por mandar a mensagem pro junit. 
	}
	
	@Test 
	public void testeAdicionaCliente() {
		
		List <Cliente> clientes = new ArrayList<>();
		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);
		Cliente cliente01 = new Cliente(1, "Clayton", 47, "clayton@gmail.com", 1 ,true);
		gerClientes.adicionaCliente(cliente01);
		
		Cliente cliente02 = new Cliente(2, "José Roberto", 30, "parente.25@gmail.com", 1, true);
		gerClientes.adicionaCliente(cliente02);
		
	}
	/*Criar um google docs para os Caso de Teste e um google docs com o Plano de Teste
	 * (este documento mdede a cobertura dos seus testes como um todo)*/
	

	@Test
	public void testeRemoveCliente() {
		
		//montagem dos cenários
		int idCliente03 = 3;
		int idCliente05 = 5;
		
		List <Cliente> clientes = new ArrayList<>();
		
		//criando alguns clientes
		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);
		Cliente cliente03 = new Cliente(idCliente03, "João Simões", 21, "joaos@gmail.com", 3 , true);
		Cliente cliente5 = new Cliente (idCliente05, "Ana Carolina", 26, "carolana@gmail.com", 5, true);
		gerClientes.adicionaCliente(cliente03);
		gerClientes.pesquisaCliente(3);
		
		//execução do teste
		boolean clienteRemovido = gerClientes.removeCliente(3);
		
		//gerClientes.removeCliente(3);
		
		//análise da remoção esperada. VERIFICAÇÕES
		assertThat(clienteRemovido, is(false));
		assertFalse(clienteRemovido);
		assertThat(gerClientes.getClientesDoBanco().size(), is(2));
		//teste do método remover. Para assegurar que removemos com sucesso um cliente, adicionamos e pesquisamos ele só em caso, pois o método remoção precisa de clientes adicionados
	}
	
	@Test
	public void testeRemoveClienteInexistente() {
		
		//montagem dos cenários
		//int idCliente03 = 3;
		//int idCliente05 = 5;
		
		//List <Cliente> clientes = new ArrayList<>();
		
		//criando alguns clientes
		//GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);
		//Cliente cliente03 = new Cliente(idCliente03, "João Simões", 21, "joaos@gmail.com", 3 , true);
		//Cliente cliente5 = new Cliente (idCliente05, "Ana Carolina", 26, "carolana@gmail.com", 5, true);
		//gerClientes.adicionaCliente(cliente03);
		//gerClientes.pesquisaCliente(3);
		
		//execução do teste
		boolean clienteRemovido = gerClientes.removeCliente(10);
		
		//gerClientes.removeCliente(3);
		
		//análise da remoção esperada. VERIFICAÇÕES
		assertThat(clienteRemovido, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), is(0));
		assertNull(gerClientes.pesquisaCliente(3));
		//teste do método remover. Para assegurar que removemos com sucesso um cliente, adicionamos e pesquisamos ele só em caso, pois o método remoção precisa de clientes adicionados
	}

	@Test
	public void testClientIdadePermitida1() throws IdadeNaoPermitidaException{
	// Cenario costumizado para esse teste
		Cliente cliente = new Cliente(3, "vitor hernandez", 26, "vitorhp@gmail.com", 1, true);
		//Execução
		boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());
		//Verificação
		assertTrue(idadeValida);
	}
	
	@Test
	public void testClientIdadePermitida2() throws IdadeNaoPermitidaException{
	// Cenario costumizado para esse teste
		Cliente cliente = new Cliente(4, "joao", 18, "joao@gmail.com", 1, true);
		//Execução
		boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());
		//Verificação
		assertTrue(idadeValida);
	}
	
	@Test
	public void testClientIdadePermitida3() throws IdadeNaoPermitidaException{
	// Cenario costumizado para esse teste
		Cliente cliente = new Cliente(5, "arthur", 65, "arthur@gmail.com", 1, true);
		//Execução
		boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());
		//Verificação
		assertTrue(idadeValida);
	}
	
	//Validação quando o cliente esta fora do intervalo de idade permitido na borda inferior
	@Test
	public void testClientIdadePermitida4() throws IdadeNaoPermitidaException{
	// Cenario costumizado para esse teste
		Cliente cliente = new Cliente(6, "felipe", 17, "felipe@gmail.com", 1, true);
		//Execução
		try {
			gerClientes.validaIdade(cliente.getIdade());
			fail();
		} catch (Exception e) {
			assertThat(e.getMessage(), is(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA));
		}
	}
	
	@Test
	public void testClientIdadePermitida5() throws IdadeNaoPermitidaException{
	// Cenario costumizado para esse teste
		Cliente cliente = new Cliente(7, "leonardo", 70, "leonardo@gmail.com", 1, true);
		//Execução
		try {
			gerClientes.validaIdade(cliente.getIdade());
			fail();
		} catch (Exception e) {
			assertThat(e.getMessage(), is(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA));
		}
	}
}

