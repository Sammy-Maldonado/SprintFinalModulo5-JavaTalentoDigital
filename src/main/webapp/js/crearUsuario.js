/**
 * 
 */

document.addEventListener("DOMContentLoaded", function() {
    const tipoUsuarioSelect = document.getElementById("tipoUsuario");
    const empresaDiv = document.getElementById("empresaDiv");
    const especialidadDiv = document.getElementById("especialidadDiv");

    tipoUsuarioSelect.addEventListener("change", function() {
        const tipoUsuario = tipoUsuarioSelect.value;

        // Ocultar todos los campos adicionales por defecto
        empresaDiv.classList.add("d-none");
        especialidadDiv.classList.add("d-none");

        // Mostrar el campo correspondiente según el tipo de usuario
        if (tipoUsuario === "Cliente") {
            empresaDiv.classList.remove("d-none");
        } else if (tipoUsuario === "Profesional") {
            especialidadDiv.classList.remove("d-none");
        }
    });
});