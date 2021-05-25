<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../template/header.jsp"></jsp:include>

<main class="container mt-6 ">
<div class="field">
							<label class="label" for="tipoSolicitud-select">Tipo de
								Solicitud</label>
							<div class="control">
								<div class="select">

									<select name="tipoSolicitud-select" id="tipoSolicitud-select">
										<option>Solicitud de Cédula de identidad</option>
										<option>Retiro de Cédula de identidad</option>
										<option>Solicitud de Certificado de Nacimiento</option>
										<option>Solicitud de Certificado de Defucón</option>
									</select>
                                   
								</div>
							</div>
						</div>
						<button type="submit" class="button is-primary">filtrar</button>
	<div class="columns is-centered">
		<div class="column is-8">
			<table class="table is-hovered is-bordered is-fullwidth">
				<thead class="has-background-primary">
					<tr>
						<th>Nro</th>
						<th>Nombre del cliente</th>
						<th>Tipo de Solicitud</th>
						<th>Accion</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="registro" items="${registros}">
						<tr>
							<td>${registro.num}</td>
							<td>${registro.nombre}</td>
							<td>${registro.tipoSolicitud}</td>
                            <td><a href="VerSolicitudController.do?nombreEliminar=${registro.nombre}"
                            class="hast-text-primary">Atender</a>
                            </td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</main>
</body>
</html>
