<div class="modal fade" id="crearEmpanada" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="crearEmpanadaTitle">Agregar empanada</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="${pageContext.request.contextPath}/empanadas?accion=crear" method="post">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="titulo">Nombre:</label>
                        <input type="text" maxlength="50" class="form-control" name="nombre" required>
                    </div>
                    <div class="form-group">
                        <label for="descripcion">Descripción:</label>
                        <input type="text" maxlength="255" class="form-control" name="descripcion" required>
                    </div>
                    <div class="form-group">
                        <label for="precio">Precio:</label>
                        <input type="number" step="any" maxlength="5" class="form-control" name="precio" required>
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
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                    <input type="submit" class="btn btn-primary" value="Crear">
                </div>
            </form>
        </div>
    </div>
</div>

