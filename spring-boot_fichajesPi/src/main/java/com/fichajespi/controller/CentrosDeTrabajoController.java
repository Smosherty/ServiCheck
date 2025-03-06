package com.fichajespi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fichajespi.controller.common.CommonController;
import com.fichajespi.dto.converter.CentrosDeTrabajoDtoConverter;
import com.fichajespi.dto.entity.CentrosDeTrabajoDto;
import com.fichajespi.dto.entity.CentrosDeTrabajoDtoEdit;
import com.fichajespi.entity.CentrosDeTrabajo;
import com.fichajespi.service.CentrosDeTrabajoService;
import com.fichajespi.specifications.CentrosDeTrabajoSpecifications;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/centrosDeTrabajo")
public class CentrosDeTrabajoController extends CommonController<CentrosDeTrabajo, CentrosDeTrabajoService> {

    @Autowired
    private CentrosDeTrabajoDtoConverter dtoConverter;

    @Autowired
    private CentrosDeTrabajoSpecifications centroDeTrabajoSpecifications;

    @ApiOperation("Obtiene una lista paginada de centros de trabajo con filtros opcionales")
    @PostMapping("/pagesFiltered")
    public ResponseEntity<Page<CentrosDeTrabajoDto>> getCentrosDeTrabajo(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(defaultValue = "id") String order,
            @RequestParam(defaultValue = "true") boolean asc,
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String direccion) {

        Sort sort = asc ? Sort.by(order).ascending() : Sort.by(order).descending();
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<CentrosDeTrabajo> centros = service.pagesAndSpec(
                centroDeTrabajoSpecifications.nombreContains(nombre)
                        .and(centroDeTrabajoSpecifications.direccionContains(direccion)),
                pageRequest);

        Page<CentrosDeTrabajoDto> centroDtos = centros.map(dtoConverter::inverseTransform);
        return ResponseEntity.ok(centroDtos);
    }

    @ApiOperation("Obtiene un centro de trabajo por su id")
    @GetMapping("/get/{id}")
    public ResponseEntity<CentrosDeTrabajoDto> getCentroDeTrabajoById(@PathVariable Long id) {
        return service.findById(id)
                .map(centro -> ResponseEntity.ok(dtoConverter.inverseTransform(centro)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ApiOperation("Crea un nuevo centro de trabajo")
    @PostMapping
    public ResponseEntity<?> createCentroDeTrabajo(@RequestBody CentrosDeTrabajoDto centroDto) {
        CentrosDeTrabajo centro = dtoConverter.transformNew(centroDto);
        CentrosDeTrabajo savedCentro = service.save(centro);
        return ResponseEntity.status(HttpStatus.CREATED).body(dtoConverter.inverseTransform(savedCentro));
    }

    @ApiOperation("Edita un centro de trabajo")
    @PutMapping("/put/{id}")
    public ResponseEntity<?> editCentroDeTrabajo(@PathVariable Long id, @RequestBody CentrosDeTrabajoDtoEdit centroDtoEdit) {
        return service.findById(id).map(centro -> {
            centro = dtoConverter.transformEdit(centro, centroDtoEdit);
            CentrosDeTrabajo savedCentro = service.save(centro);
            return ResponseEntity.ok(dtoConverter.inverseTransform(savedCentro));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ApiOperation("Elimina un centro de trabajo por su id")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCentroDeTrabajo(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
