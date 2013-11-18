
;Fernando De Freitas
;Iñaki De Tejada Plessmann
;Francisco López
;
;Ingenieria del Conocimiento
;
;Proyecto

;---
;Templates
;---
	;--
	; Template Persona
	;		Utilizada para definir a todas las instancias de persona (Profesor, estudiante, egresado, empleado)
	;--
		(deftemplate persona
			(slot nombre (type STRING))
			(slot cedula (type STRING))
			(multislot tipo (type STRING))
			(slot status (type STRING))
			(slot nucleo (type STRING))
			(slot escuela (type STRING))
		)

	;--
	; Template Operacion
	;		Utilizada para especificar el tipo de operacion realizada (Validacion para el Registro o Postulacion)
	;--
		(deftemplate operacion
			(slot nombre (type STRING))	
		)

	;--
	; Template Eleccion
	;	Utilizada para definir el tipo y ubicacion de las elecciones convocadas
	;--
		(deftemplate eleccion
			(slot tipo (type STRING))
			(slot nucleo (type STRING))
		)

	;--
	; Template Regla
	;	Utilizada para almacenar en la BH la regla disparada
	;--
		(deftemplate regla
			(slot nombre (type STRING))
		)

	;--
	; Template Candidato
	;	Utilizada para almacenar en la BH el resultado del query sobre si una persona puede ser candidata a una eleccion determinada
	;--
		(deftemplate candidato
			(slot nombre (type STRING))
		)

	;--
	; Template Registro
	;	Utilizada para almacenar en la BH el resultado del query sobre si una persona puede votar en una eleccion determinada
	;--
		(deftemplate registro
			(slot nombre (type STRING))
		)

;---
;Fin Templates
;---

;-----------------------------------------------------------------------------
;Reglas
;-----------------------------------------------------------------------------

	; ------------------------------- 
	; REGLAS REGISTROS 
	;	Reglas para validar que una persona pueda ser incluida en el Registro Electoral de una eleccion
	;	tomando en cuenta variables como tipo de eleccion, nucleo, tipo de persona y condiciones 
	;	especiales.
	; -------------------------------
		; --
		;Registro para Eleccion de Rector para Estudiantes Regulares
		; --
			(defrule ReglaRegistroRectorEstudianteRegular "Regla Registro Rector, Vicerrector y Secretario"
				(operacion (nombre "registro"))
				(eleccion (tipo "rector, vicerrector y secretario")(nucleo ?n))
				(persona (tipo "estudiante")(status "regular"))
				=>
				(assert(registro (nombre "Si")))
				(assert (regla (nombre "ReglaRegistroRector")))
				(printout t " Regla RegistroRector Estudiante Regular" crlf)
			)
			
		;--
		;Registro para Eleccion de Rector para Profesores
		;--
			(defrule ReglaRegistroRectorProfesor "Regla Registro Rector, Vicerrector y Secretario"
				(operacion (nombre "registro"))
				(eleccion (tipo "rector, vicerrector y secretario")(nucleo ?n))
				(persona (tipo "profesor"))
				=>
				(assert(registro (nombre "Si")))
				(assert (regla (nombre "ReglaRegistroRector")))
				(printout t " Regla RegistroRector Profesor" crlf)
			)

		;--
		;Registro para Eleccion de Rector para Egresados
		;--
			(defrule ReglaRegistroRectorEgresado "Regla Registro Rector, Vicerrector y Secretario"
				(operacion (nombre "registro"))
				(eleccion (tipo "rector, vicerrector y secretario")(nucleo ?n))
				(persona (tipo "egresado"))
				=>
				(assert(registro (nombre "Si")))
				(assert (regla (nombre "ReglaRegistroRector")))
				(printout t " Regla RegistroRector Egresado" crlf)
			)
			
		; --
		; Registro para Eleccion de Junta Superior Universitaria para Estudiantes Regulares
		; --
			(defrule ReglaRegistroJuntaSuperiorUniversitariaEstudianteRegular "Regla Registro Junta Superior Universitaria"
				(operacion (nombre "registro"))
				(eleccion (tipo "junta superior universitaria")(nucleo ?n))
				(persona (tipo "estudiante")(status "regular"))
				=>
				(assert(registro (nombre "Si")))
				(assert (regla (nombre "ReglaRegistroJuntaSuperiorUniversitaria")))
				(printout t " Regla RegistroJuntaSuperiorUniversitaria Estudiante Regular" crlf)
			)

		;--
		;Registro para Eleccion de Junta Superior Universitaria para Profesores y Egresados
		;--
			(defrule ReglaRegistroRectorProfesorEgresado "Regla Registro Junta Superior Universitaria"
				(operacion (nombre "registro"))
				(eleccion (tipo "junta superior universitaria")(nucleo ?n))
				(persona (tipo "profesor"|"egresado"))
				=>
				(assert(registro (nombre "Si")))
				(assert (regla (nombre "ReglaRegistroJuntaSuperiorUniversitaria")))
				(printout t " Regla RegistroJuntaSuperiorUniversitaria Profesor / Egresado" crlf)
			)
		
		;--
		; Registro para Eleccion de Consejo Universitario para Profesores
		;--
			(defrule ReglaRegistroConsejoUniversitarioProfesor "Regla Registro Consejo Universitario Profesor"
				(operacion (nombre "registro"))
				(eleccion (tipo "consejo universitario")(nucleo ?n))
				(persona (tipo "profesor"))
				=>
				(assert(registro (nombre "Si")))
				(assert (regla (nombre "ReglaRegistroConsejoUniversitario")))
				(printout t " Regla RegistroConsejoUniversitario Profesor " crlf)
			)
		
		;--
		; Registro para Eleccion de Consejo Universitario para Estudiantes
		;--
			(defrule ReglaRegistroConsejoUniversitarioEstudiante "Regla Registro Consejo Universitario Estudiante"
				(operacion (nombre "registro"))
				(eleccion (tipo "consejo universitario")(nucleo ?n))
				(persona (tipo "estudiante")(status "regular"))
				=>
				(assert(registro (nombre "Si")))
				(assert (regla (nombre "ReglaRegistroConsejoUniversitario")))
				(printout t " Regla RegistroConsejoUniversitario Estudiante " crlf)
			)
		
		;--
		; Registro para Consejo de Profesores de Nucleo
		;--
			(defrule ReglaRegistroConsejoProfesoresNucleo "Regla Consejo de Profesores de Nucleo"
				(operacion (nombre "registro"))
				(eleccion (tipo "consejo de profesores de nucleo")(nucleo ?n))
				(persona (tipo "profesor")(nucleo ?np & ?n))
				=>
				(assert(registro (nombre "Si")))
				(assert (regla (nombre "ReglaRegistroConsejoProfesoresNucleo")))
				(printout t " Regla Consejo de Profesores de Nucleo " ?n crlf)
			)

		;--
		; Registro para Consejo Electoral de Nucleo Profesores y Egresados
		;--
			(defrule ReglaRegistroConsejoElectoralNucleoProfesorEgresado "Regla Consejo Electoral de Nucleo Profesor/Egresado"
				(operacion (nombre "registro"))
				(eleccion (tipo "consejo electoral de nucleo")(nucleo ?n))
				(persona (tipo "profesor"|"egresado")(nucleo ?np & ?n))
				=>
				(assert(registro (nombre "Si")))
				(assert (regla (nombre "ReglaRegistroConsejoElectoralNucleoProfesorEgresado")))
				(printout t " Regla Consejo Electoral de Nucleo Profesor/Egresado " ?n crlf)
			)
		
		;--
		; Registro para Consejo Electoral de Nucleo Estudiantes
		;--
			(defrule ReglaRegistroConsejoElectoralNucleoEstudiante "Regla Postulacion Consejo Electoral de Nucleo Estudiantes"
				(operacion (nombre "registro"))
				(eleccion (tipo "consejo electoral de nucleo")(nucleo ?n))
				(persona (tipo "estudiante")(status "regular")(nucleo ?np & ?n))
				=>
				(assert(registro (nombre "Si")))
				(assert (regla (nombre "ReglaRegistroConsejoElectoralNucleoEstudiante")))
				(printout t " Regla Registro Consejo Electoral de Nucleo Estudiante" ?n crlf)
			)
		
	; ------------------------------- 
	; FIN REGLAS REGISTROS
	; -------------------------------

	; ------------------------------- 
	; REGLAS POSTULACIONES 
	; -------------------------------

	;--
	; Postulacion Rector, Vicerrector y Secretario
	;--
		(defrule ReglaPostulacionRector "Regla Postulacion Rector, Vicerrector y Secretario"
			(eleccion (tipo "rector, vicerrector y secretario"))
			(persona (tipo "profesor")(status "agregado"| "asociado" | "titular"))
			(operacion (nombre "postulacion"))
			=>
			(assert(candidato (nombre "Si")))
			(assert (regla (nombre "ReglaPostulacionRector")))
			(printout t " ReglaPostulacionRector " crlf)
		)

	;--
	; Postulacion para Junta Superior Universitaria o Tribunal Academico Profesores y Egresados
	;--
		(defrule ReglaPostulacionJSUTAProfesorEgresado "JSU o TA"
			(eleccion (tipo "junta superior universitaria" | "tribunal academico"))
			(persona (tipo "profesor" | "egresado"))
			(operacion (nombre "postulacion"))
			=>
			(assert(candidato (nombre "Si")))
			(assert (regla (nombre "ReglaPostulacionJSU/TA")))
		)

	;--
	; Postulacion para Junta Superior Universitaria o Tribunal Academico Estudiantes
	;--
		(defrule ReglaPostulacionJSUTAEstudiante "JSU o TA"
			(eleccion (tipo "junta superior universitaria" | "tribunal academico"))
			(persona (tipo "estudiante") (status "regular"))
			(operacion (nombre "postulacion"))
			=>
			(assert(candidato (nombre "Si")))
			(assert (regla (nombre "ReglaPostulacionJSU/TA")))
		)
		
	;--
	; Postulacion para Consejo Universitario Profesores
	;--
		(defrule ReglaPostulacionConsejoUniversitarioProfesor "Consejo Universitario Profesor"
			(declare (salience 1000))
			(eleccion (tipo "consejo universitario"))
			(persona (tipo "profesor"))
			(operacion (nombre "postulacion"))
			=>
			(assert(candidato (nombre "Si")))
			(assert (regla (nombre "ReglaPostulacionCU Profesor")))
		)
		
	;--
	; Postulacion para Consejo Universitario Estudiantes
	;--
		(defrule ReglaPostulacionConsejoUniversitarioEstudiante "Consejo Universitario Estudiante"
			(eleccion (tipo "consejo universitario"))
			(persona (tipo "profesor"))
			(operacion (nombre "postulacion"))
			=>
			(assert(candidato (nombre "Si")))
			(assert (regla (nombre "ReglaPostulacionCU Profesor")))
		)
		
	;--
	; Postulacion para Consejo Electoral de Nucleo Profesores y Egresados
	;--
		(defrule ReglaPostulacionConsejoElectoralNucleoProfesorEgresado "Regla Postulacion Consejo Electoral de Nucleo Profesores y Egresados"
			(operacion (nombre "postulacion"))
			(eleccion (tipo "consejo electoral de nucleo")(nucleo ?n))
			(persona (tipo "profesor"|"egresado")(nucleo ?np & ?n))
			=>
			(assert(candidato (nombre "Si")))
			(assert (regla (nombre "ReglaPostulacionConsejoElectoralNucleoProfesorEgresado")))
			(printout t " Regla Postulacion Consejo Electoral de Nucleo Profesores Egresados" ?n crlf)
		)
		
	;--
	; Postulacion para Consejo Electoral de Nucleo Estudiantes
	;--
		(defrule ReglaPostulacionConsejoElectoralNucleoEstudiante "Regla Postulacion Consejo Electoral de Nucleo Estudiantes"
			(operacion (nombre "postulacion"))
			(eleccion (tipo "consejo electoral de nucleo")(nucleo ?n))
			(persona (tipo "estudiante")(status "regular")(nucleo ?np & ?n))
			=>
			(assert(candidato (nombre "Si")))
			(assert (regla (nombre "ReglaPostulacionConsejoElectoralNucleoEstudiante")))
			(printout t " Regla Postulacion Consejo Electoral de Nucleo Estudiante" ?n crlf)
		)

	;--
	; Postulacion para Consejo de Profesores de Nucleo
	;--
		(defrule ReglaPostulacionConsejoProfesoresNucleo "Regla Postulacion Consejo de Profesores de Nucleo"
			(operacion (nombre "postulacion"))
			(eleccion (tipo "consejo de profesores de nucleo")(nucleo ?n))
			(persona (tipo "profesor")(nucleo ?np & ?n))
			=>
			(assert(candidato (nombre "Si")))
			(assert (regla (nombre "ReglaPostulacionConsejoProfesoresNucleo")))
			(printout t " Regla Postulacion Consejo de Profesores de Nucleo " ?n crlf)
		)

	; ------------------------------- 
	; FIN REGLAS POSTULACIONES 
	; -------------------------------

;---
;Fin Reglas
;---

