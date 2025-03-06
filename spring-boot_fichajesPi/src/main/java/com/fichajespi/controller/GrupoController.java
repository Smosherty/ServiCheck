package com.fichajespi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fichajespi.controller.common.CommonController;
import com.fichajespi.dto.entity.GrupoDto;
import com.fichajespi.dto.entity.GrupoDtoEdit;
import com.fichajespi.dto.converter.GrupoDtoConverter;
import com.fichajespi.entity.Grupo;
import com.fichajespi.service.GrupoService;
import com.fichajespi.specifications.GrupoSpecifications;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/grupos")
public class GrupoController extends CommonController<Grupo, GrupoService> {

    @Autowired
    private GrupoDtoConverter dtoConverter;

    @Autowired
    private GrupoSpecifications grupoSpecifications;

    @ApiOperation("Obtiene una lista paginada de grupos con filtros opcionales")
    @GetMapping("/pagesFiltered")
    public ResponseEntity<Page<GrupoDto>> getGroups(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(defaultValue = "id") String order,
            @RequestParam(defaultValue = "true") boolean asc,
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String horarioAtencion,
            @RequestParam(required = false) List<Long> centrosDeTrabajoIds) {

        Sort sort = asc ? Sort.by(order).ascending() : Sort.by(order).descending();
        PageRequest pageRequest = PageRequest.of(page, size, sort);

        Page<Grupo> groups = service.pagesAndSpec(
                grupoSpecifications.nombreGrupoContains(nombre)
                        .and(grupoSpecifications.emailContains(email))
                        .and(grupoSpecifications.horarioAtencionEquals(horarioAtencion))
                        .and(grupoSpecifications.centrosDeTrabajoIn(centrosDeTrabajoIds)),
                pageRequest);

        Page<GrupoDto> groupDtos = groups.map(dtoConverter::inverseTransform);
        return ResponseEntity.ok(groupDtos);
    }

    @ApiOperation("Obtiene un grupo por su id")
    @GetMapping("/get/{id}")
    public ResponseEntity<GrupoDto> getGroupById(@PathVariable Long id) {
        return service.findById(id)
                .map(grupo -> ResponseEntity.ok(dtoConverter.inverseTransform(grupo)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ApiOperation("Crea un nuevo grupo")
    @PostMapping
    public ResponseEntity<?> createGroup(@RequestBody GrupoDto grupoDto) {
        if (service.existsByNombre(grupoDto.getNombre()) || service.existsByEmail(grupoDto.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El nombre o email ya está en uso.");
        }
        Grupo grupo = dtoConverter.transformNew(grupoDto);
        Grupo savedGrupo = service.save(grupo);
        return ResponseEntity.status(HttpStatus.CREATED).body(dtoConverter.inverseTransform(savedGrupo));
    }

    @ApiOperation("Edita un grupo")
    @PutMapping("/put/{id}")
    public ResponseEntity<?> editGroup(@PathVariable Long id, @RequestBody GrupoDtoEdit grupoDtoEdit) {
        return service.findById(id).map(grupo -> {
            if (service.existsByEmail(grupoDtoEdit.getEmail()) && !grupo.getEmail().equals(grupoDtoEdit.getEmail())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El email ya está en uso.");
            }
            grupo = dtoConverter.transformEdit(grupo, grupoDtoEdit);
            Grupo savedGrupo = service.save(grupo);
            return ResponseEntity.ok(dtoConverter.inverseTransform(savedGrupo));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ApiOperation("Elimina un grupo por su id")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
