package br.usjt.usjt_ccp3anmca_jpa_hibernate.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.usjt.usjt_ccp3anmca_jpa_hibernate.model.DiasDaSemana;
import br.usjt.usjt_ccp3anmca_jpa_hibernate.model.Previsao;

public class TestePrevisaoComDia {
	
	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		
		DiasDaSemana d = new DiasDaSemana();
		d.setDia("Quarta");
		manager.persist(d);
		
		Previsao p = new Previsao();
		p.setTempMin(30.0);
		p.setTempMax(31.0);
		p.setUmidade(70);
		p.setDescricao("Chuvas");
		p.setLatitude("40");
		p.setLongitude("50");
		p.setHora("3horas");
		
		p.setDiasDaSemana(d);
		manager.persist(p);
		
		transaction.commit();
		manager.close();
		JPAUtil.close();
	}
}
