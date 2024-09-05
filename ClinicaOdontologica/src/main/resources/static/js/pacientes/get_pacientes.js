window.addEventListener("load", function () {
  (function () {
    // Capturamos el tbody de la tabla
    const tablaBody = document
      .getElementById("tablaPacientes")
      .getElementsByTagName("tbody")[0];

    // Realizamos el consumo del endpoint de pacientes
    const url = "/paciente";
    const settings = {
      method: "GET",
    };

    fetch(url, settings)
      .then((response) => response.json())
      .then((data) => {
        for (paciente of data) {
          // Por cada paciente agregamos una fila al tbody
          let pacienteFila = tablaBody.insertRow();
          pacienteFila.id = "tr_" + paciente.id;
          pacienteFila.classList.add("hover:bg-emerald-100");
          pacienteFila.classList.add("flex-row");
          let deletButton = `
            <button id="delete_${paciente.id}" class="cursor-pointer bg-red-700 rounded-lg">
              <svg
                xmlns="http://www.w3.org/2000/svg"
                fill="none"
                viewBox="0 0 24 24"
                stroke-width="1.5"
                stroke="currentColor"
                class="size-8 rounded-lg text-white">
                <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  d="m14.74 9-.346 9m-4.788 0L9.26 9m9.968-3.21c.342.052.682.107 1.022.166m-1.022-.165L18.16 19.673a2.25 2.25 0 0 1-2.244 2.077H8.084a2.25 2.25 0 0 1-2.244-2.077L4.772 5.79m14.456 0a48.108 48.108 0 0 0-3.478-.397m-12 .562c.34-.059.68-.114 1.022-.165m0 0a48.11 48.11 0 0 1 3.478-.397m7.5 0v-.916c0-1.18-.91-2.164-2.09-2.201a51.964 51.964 0 0 0-3.32 0c-1.18.037-2.09 1.022-2.09 2.201v.916m7.5 0a48.667 48.667 0 0 0-7.5 0"/>
              </svg>
            </button>`;

          let updateButton = `
            <button id="update_${paciente.id}" class="cursor-pointer bg-blue-950 rounded-lg flex justify-center">
              <svg
                xmlns="http://www.w3.org/2000/svg"
                fill="none"
                viewBox="0 0 24 24"
                stroke-width="1.5"
                stroke="currentColor"
                class="size-8 rounded-lg text-white">
                <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  d="m16.862 4.487 1.687-1.688a1.875 1.875 0 1 1 2.652 2.652L10.582 16.07a4.5 4.5 0 0 1-1.897 1.13L6 18l.8-2.685a4.5 4.5 0 0 1 1.13-1.897l8.932-8.931Zm0 0L19.5 7.125M18 14v4.75A2.25 2.25 0 0 1 15.75 21H5.25A2.25 2.25 0 0 1 3 18.75V8.25A2.25 2.25 0 0 1 5.25 6H10" />
              </svg>
            </button>`;

          pacienteFila.innerHTML = `
            <td class="py-2 px-4 border-b text-center font-bold text-2xl">
              ${paciente.id}
            </td>
            <td class="py-2 px-4 border-b text-center">${paciente.nombre.toUpperCase()}</td>
            <td class="py-2 px-4 border-b text-center">${paciente.apellido.toUpperCase()}</td>
            <td class="py-2 px-4 border-b text-center">${paciente.cedula.toUpperCase()}</td>
            <td class="py-2 px-4 border-b text-center">${paciente.email.toUpperCase()}</td>
            <td class="py-2 px-4 border-b text-center">${
              paciente.fechaIngreso
            }</td>
            <td class="py-2 px-4 border-b text-center">${paciente.domicilio.calle.toUpperCase()}</td>
            <td class="py-2 px-4 border-b text-center">${
              paciente.domicilio.numero
            }</td>
            <td class="py-2 px-4 border-b text-center">${paciente.domicilio.localidad.toUpperCase()}</td>
            <td class="py-2 px-4 border-b text-center">${paciente.domicilio.provincia.toUpperCase()}</td>
            <td class="py-2 px-4 border-b content-center">
              ${updateButton}
            </td>
            <td class="py-2 px-4 border-b content-center">
              ${deletButton}
            </td>
          `;
        }
      });
  })();
});
