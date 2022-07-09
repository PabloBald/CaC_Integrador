<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:include page="WEB-INF/pages/commons/head.jsp" />
<section class="vh-100" style="background-color: #5a5a5a">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                <div class="card shadow-2-strong" style="border-radius: 1rem;">
                    <div class="card-body p-5 text-center">

                        <h3 class="mb-5">Malena's panel de administracion</h3>
                        <form action="${pageContext.request.contextPath}/login" method="POST">
                            <c:choose >
                                <c:when test="${mensaje != '' && mensaje != null}">
                                    <div>
                                        <div class="alert alert-warning alert-dismissible fade show" role="alert">
                                            ${mensaje}
                                        </div>
                                    </div>
                                </c:when> 
                            </c:choose>
                            <div class="form-floating mb-4">
                                <input type="text" name="email" id="user" class="form-control form-control-lg ${validacion}" />
                                <label for="user">Usuario</label>
                            </div>
                            <div class="form-floating mb-4">
                                <input type="password" name="password" id="password" class="form-control form-control-lg ${validacion}" />
                                <label for="password">Contraseña</label>
                            </div>
                            <button class="btn btn-primary btn-lg btn-block" type="submit">Ingresar</button>
                    </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>

