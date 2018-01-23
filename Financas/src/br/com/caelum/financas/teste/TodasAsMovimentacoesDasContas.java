package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TodasAsMovimentacoesDasContas {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		String jpql = "select distinct c from Conta c left join fetch c.movimentacoes";
		
		TypedQuery<Conta> query = em.createQuery(jpql,Conta.class);
		
		List<Conta> todasAsContas = query.getResultList();
		
		for (Conta conta : todasAsContas) {
			
			System.out.println("Titular: " + conta.getTitular());
			System.out.println("Id: " + conta.getId());
			System.out.println("Movimentações");
			System.out.println(conta.getMovimentacoes());
			
		}
		
	}

}
