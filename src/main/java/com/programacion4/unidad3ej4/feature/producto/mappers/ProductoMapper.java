package com.programacion4.unidad3ej4.feature.producto.mappers;

import com.programacion4.unidad3ej4.feature.producto.dtos.request.ProductoCreateRequestDto;
import com.programacion4.unidad3ej4.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej4.feature.producto.models.Categoria;
import com.programacion4.unidad3ej4.feature.producto.models.Producto;

public class ProductoMapper {
    
    public static Producto toEntity(ProductoCreateRequestDto dto, Categoria categoria) {
        return Producto.builder()
                .nombre(capitalizeWords(to.getNombre()))
                .codigo(dto.getCodigo())
                .descripcion(capitalizeWords(dto.getDescripcion()))
                .precio(dto.getPrecio())
                .stock(dto.getStock())
                .categoria(categoria)
                .estaEliminado(false) 
                .build();
    }

    public static ProductoResponseDto toResponseDto(Producto producto) {
        return ProductoResponseDto.builder()
                .id(producto.getId())
                .nombre(producto.getNombre())
                .codigo(producto.getCodigo())
                .descripcion(producto.getDescripcion())
                .precio(producto.getPrecio())
                .stock(producto.getStock())
                .categoria(CategoriaMapper.toDto(producto.getCategoria()))
                .build();
    }

private static String capitalizeWords(String texto) {
    if (texto == null || texto.isEmpty()) return texto;

    texto = texto.toLowerCase();

    String[] palabras = texto.split(" ");
    StringBuilder resultado = new StringBuilder();

    for (String palabra : palabras) {
        if (!palabra.isEmpty()) {
            resultado.append(Character.toUpperCase(palabra.charAt(0)))
                     .append(palabra.substring(1))
                     .append(" ");
        }
    }

    return resultado.toString().trim();
}
}