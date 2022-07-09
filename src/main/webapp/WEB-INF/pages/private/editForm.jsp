<jsp:include page="../commons/head.jsp"/>
<div class="container-fluid">
    <div class="row">
        <div class="col-12 text-center bg-warning text-light">
            <h1>Editando empanada</h1>
        </div>

        <form action="${pageContext.request.contextPath}/empanadas?accion=editar" method="post">
            <div>
                <input name="id" value="${empanada.id}"hidden>
                <div class="form-group my-4">
                    <label for="titulo">Nombre:</label>
                    <input type="text" maxlength="50" class="form-control" name="nombre" value=${empanada.nombre} required>
                </div>
                <div class="form-group">
                    <label for="descripcion">Descripción:</label>
                    <input type="text" value="${empanada.descripcion}" maxlength="255" class="form-control" name="descripcion" required>
                </div>
                <div class="form-group">
                    <label for="precio">Precio:</label>
                    <input type="number" value="${empanada.precio}" step="any" maxlength="5" class="form-control" name="precio" required>
                </div>
                <div class="form-group">
                    <label for="tipo">Tipo:</label>
                    <select name="tipo" class="form-select" required>
                        <option value="" selected disabled hidden>
                            Seleccione una opción
                        </option>
                        <option value="veggie">Veggie</option>
                        <option value="casa">De la casa</option>
                        <option value="clasica">Clásica</option>
                    </select>
                </div>
            </div>
            <div class="form-group py-3">
                <input type="submit" class="btn btn-warning" value="Modificar">
                <a href="${pageContext.request.contextPath}/panel"><input type="button" class="btn btn-secondary" value="Volver"></a>
            </div>
        </form>
    </div>
</div>
<jsp:include page="../commons/footer.jsp"/>