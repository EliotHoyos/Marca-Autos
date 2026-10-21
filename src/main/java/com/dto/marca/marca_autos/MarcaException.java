package com.dto.marca.marca_autos;

public class MarcaException extends RuntimeException {
    public MarcaException(String mensaje) {
        super(mensaje);
    }

    public static void validar(MarcaRequest request){
        if(request.getNombre() == null || request.getNombre().trim().isEmpty()){
            throw new MarcaException("El nombre de la marca no puede estar vacio");
        }
        if(request.getModelo() == null || request.getModelo().trim().isEmpty()){
            throw new MarcaException("El modelo del auto no puede estar vacio");
        }
        if(request.getPrecio() == null || request.getPrecio() <= 0){
            throw new MarcaException("El precio del auto tiene que ser mayor a 0");
        }
    }

}
