package sistemabancario;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GerencioadorasContasTeste2 {
	
	private GerenciadoraContas gerContas;
	
	@Test
	public void testTransfereValor() {
		
		int idConta01 = 1;
		int idConta02 = 2;
		
		// Montgem do cenário
		ContaCorrente conta01 = new ContaCorrente(idConta01, 100, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);
		
		List<ContaCorrente> contaDoBanco = new ArrayList<>();
		contaDoBanco.add(conta01);
		contaDoBanco.add(conta02);
		
		gerContas = new GerenciadoraContas(contaDoBanco);
		
		//Execução do negócio selecionado para o teste
		boolean sucesso = gerContas.transfereValor(idConta01, 200, idConta02);//passa o valor da conta 1 para a 2
		
		//Verificação e Análise
		assertTrue(sucesso); //asser quer testar se é true ou falso
		assertThat(conta01.getSaldo(), is(100.0));
		assertThat(conta02.getSaldo(), is(200.0));//Verifica se o saldo esta -100
	}

	@Test
	public void testTransfereValor2() {
		//Teste quando o saldo é insuficiente, entrando no cheque especial
		int idConta01 = 1;
		int idConta02 = 2;
		
		// Montgem do cenário
		ContaCorrente conta01 = new ContaCorrente(idConta01, 100, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);
		
		List<ContaCorrente> contaDoBanco = new ArrayList<>();
		contaDoBanco.add(conta01);
		contaDoBanco.add(conta02);
		
		gerContas = new GerenciadoraContas(contaDoBanco);
		
		//Execução do negócio selecionado para o teste
		boolean sucesso = gerContas.transfereValor(idConta01, 200, idConta02);//passa o valor da conta 1 para a 2
		
		//Verificação e Análise
		assertTrue(sucesso); //asser quer testar se é true ou falso
		assertThat(conta01.getSaldo(), is(-100.0));
		assertThat(conta02.getSaldo(), is(200.0));//Verifica se o saldo esta -100
	}
	@Test
	public void testTransfereValor3() {
		//Teste quando o saldo é insuficiente, entrando no cheque especial
		int idConta01 = 1;
		int idConta02 = 2;
		
		// Montgem do cenário
		ContaCorrente conta01 = new ContaCorrente(idConta01, -100, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);
		
		List<ContaCorrente> contaDoBanco = new ArrayList<>();
		contaDoBanco.add(conta01);
		contaDoBanco.add(conta02);
		
		gerContas = new GerenciadoraContas(contaDoBanco);
		
		//Execução do negócio selecionado para o teste
		boolean sucesso = gerContas.transfereValor(idConta01, 200, idConta02);//passa o valor da conta 1 para a 2
		
		//Verificação e Análise
		assertTrue(sucesso); //asser quer testar se é true ou falso. Se conseguiu fazer
		assertThat(conta01.getSaldo(), is(-300.0));// Verifica se os valores estao corretos
		assertThat(conta02.getSaldo(), is(200.0));//Verifica se o saldo esta -100
	}
	
	@Test
	public void testTransfereValor4() {
		//Teste quando o saldo é insuficiente, entrando no cheque especial
		int idConta01 = 1;
		int idConta02 = 2;
		
		// Montgem do cenário
		ContaCorrente conta01 = new ContaCorrente(idConta01, -100, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, -100, true);
		
		List<ContaCorrente> contaDoBanco = new ArrayList<>();
		contaDoBanco.add(conta01);
		contaDoBanco.add(conta02);
		
		gerContas = new GerenciadoraContas(contaDoBanco);
		
		//Execução do negócio selecionado para o teste
		boolean sucesso = gerContas.transfereValor(idConta01, 200, idConta02);//passa o valor da conta 1 para a 2
		
		//Verificação e Análise
		assertTrue(sucesso); //asser quer testar se é true ou falso. Se conseguiu fazer
		assertThat(conta01.getSaldo(), is(-300.0));// Verifica se os valores estao corretos
		assertThat(conta02.getSaldo(), is(100.0));//Verifica se o saldo esta -100
	}
}
