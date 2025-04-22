package pe.edu.upeu.sysalmacen.control;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.edu.upeu.sysalmacen.dtos.MarcaDTO;
import pe.edu.upeu.sysalmacen.excepciones.CustomResponse;
import pe.edu.upeu.sysalmacen.mappers.MarcaMapper;
import pe.edu.upeu.sysalmacen.modelo.Marca;
import pe.edu.upeu.sysalmacen.servicio.IMarcaService;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/marcas")
//@CrossOrigin("*")
public class MarcaController {
    private final IMarcaService marcaService;
    private final MarcaMapper marcaMapper;


    @GetMapping
    public ResponseEntity<List<MarcaDTO>> findAll() {
        List<MarcaDTO> list = marcaMapper.toDTOs(marcaService.findAll());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarcaDTO> findById(@PathVariable("id") Long id) {
        
    }
    
    @PostMapping
    public ResponseEntity<CustomResponse> save(@Valid @RequestBody MarcaDTO dto) {
        
    
    }

    @PutMapping("/{id}")
    public ResponseEntity<MarcaDTO> update(@Valid @PathVariable("id") Long id, @RequestBody MarcaDTO dto) {
        dto.setIdMarca(id);
        
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<CustomResponse> delete(@PathVariable("id") Long id) {
        CustomResponse operacion= marcaService.delete(id);
        return ResponseEntity.ok(operacion);
    }

    
}
}

