/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.List;
import cl.inacap.casoEvaluacion3.dto.Asistente;

public interface AsistentesDAO {
    
    void save(Asistente asistente);
    List<Asistente> getAll();
    List<Asistente> getAll(String filtro);


}
