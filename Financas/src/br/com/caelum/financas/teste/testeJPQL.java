package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class testeJPQL {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		BigDecimal valor = new BigDecimal(50.00);
		
		String jpql = "select m from Movimentacao m where m.valor > :pValor " + 
		" and m.tipo = :pTipo " + 
		" order by m.valor desc "; 

		TypedQuery<Movimentacao> query =  em.createQuery(jpql,Movimentacao.class);
		query.setParameter("pValor", valor);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		List<Movimentacao> resultados = query.getResultList();
		
		for (Movimentacao movimentacao : resultados) {
			System.out.println("Descri��o: " + movimentacao.getDescricao());
			System.out.println("Conta.id: " + movimentacao.getConta().getId());
			System.out.println("Valor: " + movimentacao.getValor());
			
		}
		
		em.getTransaction().commit();
		em.close();
		
	}
	
}
