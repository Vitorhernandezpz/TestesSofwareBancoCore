package sistemabancario;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GerencioadorasContasTeste1 {
	
	private GerenciadoraContas gerContas;
	
	@Test
	public void testTransfereValor() {
		
		int idConta01 = 1;
		int idConta02 = 2;
		
		// Montgem do cenário
		ContaCorrente conta01 = new ContaCorrente(idConta01, 200, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);
		
		List<ContaCorrente> contaDoBanco = new ArrayList<>();
		contaDoBanco.add(conta01);
		contaDoBanco.add(conta02);
		
		gerContas = new GerenciadoraContas(contaDoBanco);
		
		//Execução do negócio selecionado para o teste
		boolean sucesso = gerContas.transfereValor(idConta01, 100, idConta02);//passa o valor 100 da conta 1 para a 2
		
		//Verificação e Análise
		assertTrue(sucesso);
		assertThat(conta01.getSaldo(), is(100.0));
		assertThat(conta02.getSaldo(), is(0));
	}

}
