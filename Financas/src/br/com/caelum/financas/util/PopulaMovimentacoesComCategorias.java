package br.com.caelum.financas.util;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class PopulaMovimentacoesComCategorias {

	public static void main(String[] args) {

		Categoria categoria1 = new Categoria("Viagem");
		Categoria categoria2 = new Categoria("Negocios");

		Conta conta = new Conta();
		conta.setId(2);

		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Viagem a S�o Paulo");
		movimentacao.setTipo(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("100.0"));
		movimentacao.setCategoria(Arrays.asList(categoria1, categoria2));
		movimentacao.setConta(conta);
		
		Calendar amanha  = Calendar.getInstance();
		amanha.add(Calendar.DAY_OF_MONTH, 1);

		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setData(amanha);//amanh�
		
		movimentacao2.setDescricao("Viagem ao Rio");
		movimentacao2.setTipo(TipoMovimentacao.SAIDA);
		movimentacao2.setValor(new BigDecimal("300.0"));
		movimentacao2.setCategoria(Arrays.asList(categoria1, categoria2));
		movimentacao2.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		em.persist(categoria1);
		em.persist(categoria2);
		
		em.persist(movimentacao);
		em.persist(movimentacao2);

		em.getTransaction().commit();
		em.close();

	}

}
