<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../templates/header.jsp"></jsp:include>
    <main class="container mt-5">

    <c:if test="${mensaje != null}">
        <div class="columns is-centered mb-6">
            <div class="column is-6">
                <div class="notification is-info">
                    <p>${mensaje}</p>
                </div>
            </div>
        </div>
    </c:if>

    <c:if test="${errores != null}">
        <div class="columns is-centered mb-6">
            <div class="column is-6">
                <div class="notification is-danger">
                    <h6>Existen errores en el formulario</h6>
                    <ul>
                        <c:forEach var="error" items="${errores}">
                            <li>${error}</li>
                            </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </c:if>

    <div class="columns is-centered">
        <div class="column is-6">
            <form method="POST" action="AgregarAsistenteController.do">
                <div class="card">
                    <div class="card-header has-background-link">
                        <span class="card-header-title has-text-white is-centered">Registrar Asistente</span>
                    </div>
                    <div class="card-content">
                        <div class="label">
                            <label class="label">rut</label>
                            <div class="control">
                                <input type="text" class="input" id="rut-txt" name="rut-txt"/>
                            </div>
                        </div>


                        <div class="label">
                            <label class="label">nombre</label>
                            <div class="control">
                                <input type="text" class="input" id="nombre-txt" name="nombre-txt"/>
                            </div>
                        </div>


                        <div class="label">
                            <label class="label">apellido</label>
                            <div class="control">
                                <input type="text" class="input" id="apellido-txt" name="apellido-txt"/>
                            </div>
                        </div>


                        <div class="label">
                            <label class="label">edad</label>
                            <div class="control">
                                <input type="text" class="input" id="edad-txt" name="edad-txt"/>
                            </div>
                        </div>


                        <div class="label">
                            <label class="label">empresa</label>
                            <div class="control">
                                <input type="text" class="input" id="empresa-txt" name="empresa-txt"/>
                            </div>
                        </div>


                        <div class="field">
                            <label class="label" for="estado-select">estado</label>
                            <div class="control">
                                <div class="select">
                                    <select name="estado-select" id="estado-select">
                                        <option>pagada</option>
                                        <option>con deuda</option>
                                    </select>
                                </div>
                            </div>
                        </div>


                        <div class="field">
                            <label class="label" for="region-select">region</label>
                            <div class="control">
                                <div class="select">
                                    <select name="region-select" id="region-select">
                                        <option>valparaiso</option>
                                        <option>santiago</option>
                                        <option>norte de chile</option>
                                        <option>sur de chile</option>
                                        <option>internacional</option>
                                    </select>
                                </div>
                            </div>
                        </div>


                    </div>
                    <div class="card-footer has-text-centered">
                        <div class="card-footer-item">
                            <button type="submit" class="button is-primary">Registrar</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>	
    </div>
</main>
</body>
</html>