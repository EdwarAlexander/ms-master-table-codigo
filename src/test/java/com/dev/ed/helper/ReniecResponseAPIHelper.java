package com.dev.ed.helper;

import com.dev.ed.infrastructure.helper.response.ReniecResponseHelper;

public class ReniecResponseAPIHelper {

    public static ReniecResponseHelper createReniecResponseHelper(){
        ReniecResponseHelper api = new ReniecResponseHelper();
        api.setApellidoMaterno("Apellido");
        api.setNombres("nombre");
        api.setApellidoPaterno("apellido");
        api.setTipoDocumento("DNI");
        api.setNumeroDocumento("45632178");
        api.setDigitoVerificador("");
        return api;
    }
}
