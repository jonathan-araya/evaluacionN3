/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import cl.inacap.casoEvaluacion3.dto.Asistente;
import datos.AsistentesDAO;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author jonny
 */
public class AsistenteServiceImp implements AsistenteService{
    
    @Inject
    private AsistentesDAO asisDAO;

    @Override
    public List<Asistente> listaAsistentes() {
        return asisDAO.getAll();
    }

    @Override
    public void registrarAsistente(Asistente asistente) {
        asisDAO.save(asistente);
    }

    @Override
    public List<Asistente> listaAsistentes(String filtro) {
        return asisDAO.getAll();
    }
    
    
}
