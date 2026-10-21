package com.dto.marca.marca_autos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MarcaResponse {
    private Long idMarca;
    private String nombre;
    private String modelo;
    private Boolean estado;
    private Double precio;
    private Double flete;
    private Double igv;
    private Double total;
}
