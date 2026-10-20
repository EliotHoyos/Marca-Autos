package com.dto.marca.marca_autos;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/marcas")
public class MarcaController {

    @PostMapping
    public MarcaResponse registrar(@RequestBody MarcaRequest request){

        MarcaResponse response = MarcaResponse.builder()
                .idMarca(1l)
                .nombre(request.getNombre())
                .modelo(request.getModelo())
                .estado(request.getEstado())
                .build();
        return response;

    }

}
