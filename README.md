# Conexiòn para los 2 backend
### Base de datos
* #### Se unifico las dos bd que habia en los dos api y ahora se llama `cecy`

###     Migraciones:
* #### Primero empezar desde el backend de nodejs con los comandos que se encuentran en el repositorio `cecy_curso`.
* #### Segundo agregar credenciales en el proyecto de Java y correrlo normal.

###     Utilizar la tabla de `courses`
* #### Agregar `nuevos campos` | `relaciones para sus tablas` en el archivo ```Curso``` esta el modelo que mapea la tabla ahi se puede implementar esa logica

### Actualmente existe 2 endpoints que conectane el api Nodejs
* `http://localhost:8080/courses`  (Trae todos los cursos)
* `http://localhost:8080/courses/state-course/:state` (El campo (`state`) acepta solo estos dos estados para hacer el filtro `proceso` | `aprobado` )

### Crud con la tabla de cursos (`courses`)
* GET `http://localhost:8080/api/cursos/` (trae los cursos con los campos nuevos que le agregues a la tabla)
* PUT `http://localhost:8080/api/cursos/{id}` (Actualiza tus campos que le agregaste a la tabla de courses)
* POST `http://localhost:8080/api/cursos/` (Agrega la data al campo nuevo que se creo en la tabla de `courses`)
* DELETE `No se puede eliminar un curso porque depende de varias fk` Entonces en su lugar se va crear una logica para que el curso tenga un estado en `finalizado` | `proceso`

### Esos dos endpoints son importantes tienen que tener levantado los dos proyectos de `Nodejs y Java` 
#### Adicional el backup esta en la misma carpeta llamada `conexion` ahi le pueden descargar y consumir en la base de datos del `cecy_curso`