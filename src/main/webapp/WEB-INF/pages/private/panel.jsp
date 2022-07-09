<%@page import="entities.Empanada"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../commons/head.jsp"/>
<div >
    <header class="py-5 bg-warning text-white jumbotron jumbotron-fluid ">
        <div class="container">
            <h1><i class="fa fa-solid fa-gear fa-spin"></i>  Malena's &REG; PANEL DE CONTROL </h1>
        </div>
    </header>
    <main class="container-fluid">
        <section>
            <div class="py-5">
                <h2 class="">Empanadas</h2>
            </div>
            <div class="btn btn-warning text-white shadow fw-bold fs-4 mb-4" data-bs-toggle="modal" data-bs-target="#crearEmpanada">Añadir Empanada</div>
            <div class="py-4 border border-warning rounded shadow mb-3">
            <table class="table fs-5">
                <th>Id Producto</th>
                <th>Nombre</th>
                <th>Descripcion</th>
                <th>Precio</th>
                <th>Tipo</th>
                <th>Habilitada</th>
                <th>Acciones</th>
                    <c:forEach var="empanada" items="${empanadas}">
                    <tr>
                        <td class="text-center">${empanada.id}</td>
                        <td>${empanada.nombre}</td>
                        <td>${empanada.descripcion}</td>
                        <td>$${empanada.precio}</td>
                        <td>${empanada.tipo}</td>
                        <c:choose>
                            <c:when test="${empanada.baja == 0}">
                                <td class="text-center">Sí</td>
                            </c:when>
                            <c:otherwise>
                                <td class="text-center">No</td>
                            </c:otherwise>
                        </c:choose>
                        <td>
                                   <a class="text-light text-decoration-none" href="${pageContext.request.contextPath}/empanadas?accion=editar&id=${empanada.id}"><div class="btn btn-success" data-bs-toggle="tooltip" data-bs-placement="top" title="Editar"><i class="fa fa-solid fa-marker"></i></div></a><!--Parametros: ?accion=editar&id=${empanada.id}"-->
                                    <c:choose>
                                        <c:when test="${empanada.baja == 0}">
                                    <a href="${pageContext.request.contextPath}/empanadas?accion=deshabilitar&id=${empanada.id}"><div class="btn btn-warning" data-bs-toggle="tooltip" data-bs-placement="top" title="Deshabilitar momentáneamente"><i class="fa fa-regular fa-stop"></i></div></a>
                                        </c:when>
                                        <c:otherwise>
                                    <a href="${pageContext.request.contextPath}/empanadas?accion=habilitar&id=${empanada.id}"><div class="btn btn-dark" data-bs-toggle="tooltip" data-bs-placement="top" title="Habilitar"><i class="fa fa-regular fa-play"></i></div></a>
                                        </c:otherwise>
                                    </c:choose>
                            <a class="text-light text-decoration-none" href="${pageContext.request.contextPath}/empanadas?accion=eliminar&id=${empanada.id}"><div class="btn btn-danger" data-bs-toggle="tooltip" data-bs-placement="top" title="Eliminar"><i class="fa fa-solid fa-trash"></i></div></a> <!-- Parametros: ?accion=editar&id=${empanada.id} -->
                        </td>
                    </tr>
                </c:forEach>
            </table>
            </div>
            <div class="py-5 justify-content-center text-center border border-warning rounded shadow">
                <h3>Menu Preview</h3>
                <iframe  class="border border-dark" src='http://localhost:8080/Integrador/home' title="Menu Preview" width="50%" height="500px" ></iframe>
            </div>
    </main>
    <jsp:include page="../modals/crearEmpanada.jsp"/>
</div>
<jsp:include page="../commons/footer.jsp"/>

