/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import cl.inacap.casoEvaluacion3.dto.Asistente;
import java.util.List;

/**
 *
 * @author jonny
 */
public interface AsistenteService {
    
    public List<Asistente> listaAsistentes();
    
    public List<Asistente> listaAsistentes(String filtro);
    
    public void registrarAsistente(Asistente asistente);
}
