<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="WEB-INF/pages/commons/head.jsp"/>
<div class="container-fluid  position-relative py-5 px-5">
    <div class="row">
        <div class="col-12 text-center mb-3 bg-warning text-light py-4">
            <div>
                <img src="./static/images/logo/logo.png" width="width" height="height" alt="alt"/>
            </div>
            <h1 class="h1">Menu de empanadas Malena's</h1>
            <p class="lead">A continuación les presentamos nuestras distintas opciones de empanadas.</p>
        </div>
            <div class="py-4 col-12 mt-5">
                <h3 class="text-center h2">Empanadas de la casa</h3>
                <hr class="accent my-5">
            </div>
            <c:forEach var="casa" items="${lacasa}">
                <div class="card-columns">
                    <div class="card card-body fs-5">
                        <span class="float-right font-weight-bold">$${casa.precio}</span>
                        <h6 class="fs-4">${casa.nombre}</h6>
                        <p class="small">${casa.descripcion}</p>
                    </div>
                </div>
            </c:forEach>
            <div class="py-4 mt-5">
                <h3 class="text-center">Empanadas clásicas</h3>
                <hr class="accent my-5">
            </div>
            <div class="card-columns">
                <c:forEach var="clasica" items="${clasicas}">
                    <div class="card card-body fs-5">
                        <span class="float-right font-weight-bold">$${clasica.precio}</span>
                        <h6 class="fs-4">${clasica.nombre}</h6>
                        <p class="small">${clasica.descripcion}</p>
                        <span class="font-weight-bold small"></span>
                    </div>
                </c:forEach>
            </div>
        
        <div class="py-4 col-12 mt-5">
            <h3 class="text-center">Empanadas Veggie</h3>
            <hr class="accent my-5">
        </div>
        <c:forEach var="veggie" items="${veggies}">
            <div class="card-columns">
                <div class="card card-body fs-5 ">
                    <span class="float-right  font-weight-bold">$${veggie.precio}</span>
                    <h6 class="fs-4">${veggie.nombre}</h6>
                    <p class="small">${veggie.descripcion}</p>
                </div>
            </c:forEach>

            <div class="col-12 mt-5 border border-right-0 border-left-0">
                <div class="row">
                    <div class="col h5">Malena's</div>
                    <div class="col h5 text-right">1 800-889-Malenas</div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="WEB-INF/pages/commons/footer.jsp" />