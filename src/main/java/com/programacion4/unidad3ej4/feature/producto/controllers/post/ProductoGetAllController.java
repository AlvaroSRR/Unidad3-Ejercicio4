package main.java.com.programacion4.unidad3ej4.feature.producto.controllers.post;

import java.util.List;

import com.programacion4.unidad3ej4.feature.producto.dtos.response.ProductoResponseDto;

@RestController
@RequestMapping("/producto")
@AllArgsConstructor
public class ProductoGetAllController {

    private final ProductoGetAllService productoGetAllService;

    @GetMapping
    public ResponseEntity<List<ProductoResponseDto>> getAll() {

        List<ProductoResponseDto> productos = productoGetAllService.getAll();

        return ResponseEntity.ok(productos);
    }
}