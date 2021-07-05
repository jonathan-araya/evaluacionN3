<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../templates/header.jsp"></jsp:include>
    <main class="container mt-5">
        <div class="columns is-centered">
            <div class="column is-8">
                <form method="GET" action="asistentes">
                    <input type="search" name="filtro"><input type="submit" value="BUSCAR">
                </form>
            </div>
        </div>
	<div class="columns is-centered">
            <div class="column is-8">
		<table class="table is-hovered is-bordered is-fullwidth">
                    <thead class="has-background-info">
			<tr>
                            <th class="has-text-white">Nombre Completo</th>
				<th class="has-text-white">Empresa</th>
				<th class="has-text-white">Region</th>
				<th class="has-text-white">Estado</th>
                            </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="asistente" items="${asistentes}">
                            <tr>
                                <td>${asistente.nombre} ${asistente.apellido}</td>
                                <td>${asistente.empresa}</td>
                                <td>${asistente.region}</td>
                                <td>${asistente.estado}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
		</table>
            </div>
	</div>
    </main>
</body>
</html>