package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConta {

	public static void main(String[] args) {

		Conta conta = new Conta();

		conta.setTitular("Alexandre Borba");
		conta.setAgencia("3306");
		conta.setNumero("123456");
		conta.setBanco("Santander");

		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();

		em.close();
	}

}
