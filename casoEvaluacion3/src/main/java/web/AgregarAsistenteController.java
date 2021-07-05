/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import cl.inacap.casoEvaluacion3.dto.Asistente;
import servicio.AsistenteService;

/**
 *
 * @author jonny
 */
@WebServlet(name = "AgregarAsistenteController", urlPatterns = {"/AgregarAsistenteController.do"})
public class AgregarAsistenteController extends HttpServlet {

    @Inject
    AsistenteService asistServ;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AgregarAsistenteController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AgregarAsistenteController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/vistas/agregarAsistente.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<String> errores = new ArrayList<String>();

        String rut = request.getParameter("rut-txt").trim();
        if (!validarRut(rut)) {
            errores.add("ingrese rut solo numeros y guion");
        }
        String nombre = request.getParameter("nombre-txt").trim();
        if (nombre == null) {
            errores.add("ingrese un nombre");
        }
        String apellido = request.getParameter("apellido-txt").trim();
        if (apellido == null) {
            errores.add("ingrese un apellido");
        }
        String edad = request.getParameter("edad-txt").trim();
        if (!validarNum(edad)) {
            errores.add("edad no valida");
        }
        String empresa = request.getParameter("empresa-txt").trim();
        if (empresa == null) {
            errores.add("agregue una empresa valida");
        }
        String estado = request.getParameter("estado-select").trim();
        String region = request.getParameter("region-select").trim();
        if (errores.isEmpty()) {

            int edadInt = Integer.parseInt(edad);

            Asistente asistente = new Asistente();

            asistente.setRut(rut);
            asistente.setNombre(nombre);
            asistente.setApellido(apellido);
            asistente.setEdad(edadInt);
            asistente.setEmpresa(empresa);
            asistente.setEstado(estado);
            asistente.setRegion(region);
            asistServ.registrarAsistente(asistente);
            request.setAttribute("mensaje", "consola Registrada exitosamente");
        } else {
            request.setAttribute("errores", errores);
        }

        doGet(request, response);
    }

    public static boolean validarNum(String edad) {

        try {
            boolean validacion = false;

            boolean match = edad.matches("[0-9]*");

            int menorquetres = Integer.parseInt(edad);

            boolean minimo = menorquetres >= 18;

            validacion = ((match = true) && (match && minimo));

            return validacion;
        } catch (Exception ex) {
            return false;
        }
    }

    public static boolean validarRut(String rut) {

        boolean validacion = false;

        boolean match = rut.contains("-");

        boolean largo = rut.length() <= 10;

        boolean ulti = rut.matches("^[\\d.]*-[\\dk]$");

        validacion = ((match = true) && (match && largo && ulti));

        return validacion;
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
