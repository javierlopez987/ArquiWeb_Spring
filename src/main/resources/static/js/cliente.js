"use strict";
document.addEventListener("DOMContentLoaded", function () {
    const URL = "http://localhost:8080/";
    let msjError = document.querySelector(".errorMsj");
    msjError.setAttribute("display", "none");



    let btnAltaCliente = document.querySelector(".btnAddCliente");
    btnAltaCliente.addEventListener("click", async function (e) {
        e.preventDefault();
        let cliente = {
            "nombre": document.querySelector(".nombre").value,
        };
        let contenedor = document.querySelector(".contenedor");
        contenedor.innerHTML = "<span>Espere por favor...</span>";
        try {
            let request = fetch(URL + "clientes/", {
                "method": "POST",
                "headers": { "Content-Type": "application/json" },
                "body": JSON.stringify(cliente)
            });
            let response = await request;
            if (response.ok) {
                let text = await response.status;
                console.log(text);
                contenedor.innerHTML = "";
                contenedor.innerHTML = "<span>Cliente agregado con éxito</span>";
                contenedor.innerHTML += "<a href='clientes.html'>Volver</a>";
            }
            else {
                contenedor.innerHTML = "";
                contenedor.innerHTML = "<span>Falla de URL</span>";
                contenedor.innerHTML += "<a href='clientes.html'>Volver</a>";
            }
        }
        catch (exc) {
            console.log(exc);
            contenedor.innerHTML = "";
            contenedor.innerHTML = "<span>Falla de conexión</span>";
            contenedor.innerHTML += "<a href='estudiante.html'>Volver</a>";
        }
    });


    let btnListarClientes= document.querySelector("#btnClientes");
    let btnModificarCliente= document.querySelector("#btnModificarCliente");
    let btnEliminarCliente= document.querySelector("#btnEliminarCliente");
    btnListarClientes.addEventListener('click',listarClientes);
    btnEliminarCliente.addEventListener('click',eliminarCliente);
    btnLu.addEventListener('click',listarEstudiante);
    
    
    
    
    async function listarClientes(){
        let container = document.querySelector("#tableClientes");
        try {
            let request = fetch(URL+"clientes/");
            let response = await request;
            if (response.ok){
                let clientes = await response.json();
                container.innerHTML = "";
                for (let elemento of clientes){
                        container.innerHTML += "<tr><td>"+
                         elemento.id+"</td>"+
                        "<td>"+ elemento.nombre+"</td>";
                }
            }
            else {
                container.innerHTML = "<h1>Falla de URL</h1>";
            }
        
        }
        catch (exc) {
            container.innerHTML = "<h1>Fallo conexion</h1>";
        }
    }

    async function eliminarCliente(){
        let idCliente = document.querySelector("#idCliente");
        try {
            let request = fetch(URL + "clientes/"+idCliente, {
                "method": "DELETE",
                "headers": { "Content-Type": "application/json" },
            });
            let response = await request;
            if (response.ok){
                let clientes = await response.json();
                //elimnado..
            }
            else {
                container.innerHTML = "<h1>Falla de URL</h1>";
            }
        
        }
        catch (exc) {
            container.innerHTML = "<h1>Fallo conexion</h1>";
        }
    }

});