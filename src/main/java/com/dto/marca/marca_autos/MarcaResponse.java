package com.dto.marca.marca_autos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MarcaResponse {
    private Long idMarca;
    private String nombre;
    private String modelo;
    private Boolean estado;
    private Double precio;
    private Double flete;
    private Double igv;
    private Double total;
    private String mensaje;
}
