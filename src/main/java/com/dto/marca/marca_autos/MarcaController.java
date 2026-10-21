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

        CalculoFlete calculo = new CalculoFlete();
        double precio = request.getPrecio();
        double flete = calculo.calcularFlete(precio);
        double subtotal = precio + flete;
        double igv = calculo.calcularIgv(subtotal);
        double total = subtotal + igv;

        MarcaResponse response = MarcaResponse.builder()
                .idMarca(1l)
                .nombre(request.getNombre())
                .modelo(request.getModelo())
                .estado(request.getEstado())
                .precio(precio)
                .flete(flete)
                .igv(igv)
                .total(total)
                .build();
        return response;

    }

}
