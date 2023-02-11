package com.pruebaTecnicaBack.laudex.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebaTecnicaBack.laudex.Model.AlumnoModel;
import com.pruebaTecnicaBack.laudex.Service.AlumnoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/alumnosapi")
public class AlumnoController {
    @Autowired
    private AlumnoService alumnoService;
    @ApiOperation(value = "Buscar todo", notes = "Busca la Lista de todos")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente", response = Student.class, responseContainer = "List")})
    @GetMapping("/alumnos")
    public List<AlumnoModel> listarAlumnos(){
        return alumnoService.findAll();
    }
    @ApiOperation(value = "Guardar estudiante", notes = "Guarda los estudiantes")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK. El recurso se agrega correctamente", response = Student.class)})
    @PostMapping("/alumno")
    public AlumnoModel GuardarAlumno(@RequestBody AlumnoModel alumno){
        return alumnoService.save(alumno);
    }
    @ApiOperation(value = "Busqueda de alumnos", notes = "Busqueda de alumnos")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente", response = Student.class)})
    @GetMapping("/alumno/{id}")
    public AlumnoModel BuscarAlumno(@PathVariable Integer id){
        return alumnoService.findById(id);
    }

    @ApiOperation(value = "Borrar estudiantes", notes = "Borrado de estudiantess para el desarrollo")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK. El recurso se borro correctamente", response = String.class)})
    @DeleteMapping("/alumno/{id}")
    public void EliminarAlumno(@PathVariable Integer id){
        alumnoService.delete(id);
    }
}
