# Conexiòn api cursos
### Actualmente existe 2 endpoints
* `http://localhost:8080/courses`  (Trae todos los cursos)
* `http://localhost:8080/courses/state-course/:state` (El campo (`state`) acepta solo estos dos estados para hacer el filtro `proceso` | `aprobado` )

### Esos dos endpoints son importantes tienen que tener levantado los dos proyectos de `Nodejs y Java` 
#### Adicional el backup esta en la misma carpeta llamada `conexion` ahi le pueden descargar y consumir en la base de datos del `cecy_curso`