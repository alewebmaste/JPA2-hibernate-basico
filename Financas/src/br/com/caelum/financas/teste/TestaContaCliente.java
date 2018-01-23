package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Cliente;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaContaCliente {

	public static void main(String[] args) {

		Cliente cliente = new Cliente();
		cliente.setNome("Alexandre");
		cliente.setEndereco("Silva Bueno, 1312");
		cliente.setProfissao("Analista");
		
		Cliente cliente2 = new Cliente();
		cliente2.setNome("Gabriela");
		cliente2.setEndereco("Silva Bueno, 844");
		cliente2.setProfissao("Vendedora");
		
		Conta conta = new Conta();
		conta.setId(2);
		
		cliente2.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(cliente2);
	
		em.getTransaction().commit();
		
		em.close();
	}

}
