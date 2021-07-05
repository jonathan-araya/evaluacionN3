/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import cl.inacap.casoEvaluacion3.dto.Asistente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 *
 * @author jonny
 */
public class AsistenteDAOimp implements AsistentesDAO{
    
    @PersistenceContext(unitName="ASISTENTE_PU")
    EntityManager em;


    
    @Override
    @Transactional
    public void save(Asistente asistente) {
        em.persist(asistente);
        
        
    }

    @Override
    public List<Asistente> getAll() {
        return em.createNamedQuery("Asistente.getAll").getResultList();
    }

    @Override
    public List<Asistente> getAll(String filtro) {
        Query query = em.createQuery("from Asistente a where a.name LIKE :filtro");
        query.setParameter("filtro", "%" + filtro + "%");
        return query.getResultList();
    }


    
   
}
