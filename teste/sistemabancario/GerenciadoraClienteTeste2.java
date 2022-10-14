package sistemabancario;

import static org.junit.Assert.assertNull;

//Classe de teste criada para garantir o funcionamento das principais operações
//sobre clientes, realizada pela classe
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GerenciadoraClienteTeste2 {
	
	
	
	private int idCliente01 = 1;
	private int idCliente02 = 2;
	List<Cliente> clientes = new ArrayList<>();
	private GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);
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
	public void testeIsAtivo() {
		List <Cliente> clientes = new ArrayList<>();
		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);
		Cliente cliente04 = new Cliente(4, "Caio", 18, "caio@gmail.com", 4, true);
		Cliente cliente05 = new Cliente(5, "Ricardo Carvalho", 62, "ricardo@gmail.com", 5, false);
		gerClientes.clienteAtivo(4);
		gerClientes.clienteAtivo(5);
		
		//o método cliente Ativo testa se um determinado clietne está ativo ou não. Buscammos o cliente por ID, verificamos se o metodo clienteAtivo é igual a true, e retornamos o cliente ativo. Para prepararmos o ambiente de teste, adicionamos dois clientes: um com valor booleano true e outro com false.
	}
}
