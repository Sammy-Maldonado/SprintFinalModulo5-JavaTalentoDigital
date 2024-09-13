/**
 * 
 */

function validarFormulario() {
       var nombre = document.getElementById("nombre").value;
       var detalle = document.getElementById("detalle").value;

       if (nombre === "" || detalle === "") {
           alert("Todos los campos son obligatorios.");
           return false;
       }
       return true;
   }