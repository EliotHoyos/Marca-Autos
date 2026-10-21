package com.dto.marca.marca_autos;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/marcas")
public class MarcaController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MarcaResponse registrar(@RequestBody MarcaRequest request){

        try {

            MarcaException.validar(request);

            CalculoFlete calculo = new CalculoFlete();
            double precio = request.getPrecio();
            double flete = calculo.calcularFlete(precio);
            double subtotal = precio + flete;
            double igv = calculo.calcularIgv(subtotal);
            double total = subtotal + igv;

            String mensajePersonalizado = "Se registró el auto " + request.getModelo() +
                    " con éxito. Flete: S/. " + flete + ", IGV: S/. " + igv + ", Total: S/. " + total;

            MarcaResponse response = MarcaResponse.builder()
                    .idMarca(1l)
                    .nombre(request.getNombre())
                    .modelo(request.getModelo())
                    .estado(request.getEstado())
                    .precio(precio)
                    .flete(flete)
                    .igv(igv)
                    .total(total)
                    .mensaje(mensajePersonalizado)
                    .build();
            return response;

        }catch (MarcaException e){

            return MarcaResponse.builder()
                    .mensaje(e.getMessage())
                    .build();

        }

    }

}
