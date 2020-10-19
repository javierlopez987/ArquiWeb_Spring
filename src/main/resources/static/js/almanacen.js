"use strict";
document.addEventListener("DOMContentLoaded", function () {
    const URL = "http://localhost:8080/";
    let msjError = document.querySelector(".errorMsj");
    msjError.setAttribute("display", "none");

    let cliente = null;
    let toDate = new Date();
    toDate = Date.now();
    // LISTA CARRERAS
    let btnProductos = document.querySelector("#btnProductos");
    btnProductos.addEventListener('click',listarProductos);

    async function listarProductos(){
        let request = URL + "productos/";
        let container = document.querySelector("#listProd");
        container.innerHTML = "<li>Cargando...</li>";
        try {
            let response = await fetch(request);
            if (response.ok) {
                let dato = await response.json();
                container.innerHTML = "";
                for (let elemento of dato) {
                    container.innerHTML += "<tr><td>"+
                    elemento.id+"</td>"+
                    "<td>"+ elemento.id+"</td>";
                   "<td>"+ elemento.nombre+"</td>";
                   "<td>"+ elemento.costo+"</td>";
                   "<td>"+ elemento.stock+"</td>";
                }
            } else {
                container.innerHTML = "";
            	msjError.setAttribute("display", "visible");
            	msjError.innerHTML = "Error - Por favor, contáctese con proveedor del servicio";
                console.log("URL error");
                console.log(response);
            }
        } catch (response) {
            container.innerHTML = "";
            msjError.setAttribute("display", "visible");
            msjError.innerHTML = "Error - Por favor, contáctese con proveedor del servicio";
            console.log("Connection error");
            console.log(response);
        }
    }

})