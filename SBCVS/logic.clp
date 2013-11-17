
;Fernando De Freitas
;Iñaki De Tejada Plessmann
;Francisco López
;Ingenieria del Conocimiento
;Proyecto

;---
;Templates
;---

(deftemplate persona
(slot nombre (type STRING))
(slot cedula (type STRING))
(multislot tipo (type STRING))
(slot status (type STRING))
(slot nucleo (type STRING))
(slot escuela (type STRING))
)

(deftemplate operacion
	(slot nombre (type STRING))	
)

(deftemplate eleccion
	(slot tipo (type STRING))
	(slot nucleo (type STRING))
)

(deftemplate regla
	(slot nombre (type STRING))
)

(deftemplate candidato
	(slot nombre (type STRING))
)

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
; -------------------------------

; --
; Regla Registro para Eleccion de Rector para Estudiantes Regulares
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
;Regla Registro para Eleccion de Rector para Profesores
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
;Regla Registro para Eleccion de Rector para Egresados
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
; Regla Registro para Eleccion de Junta Superior Universitaria para Estudiantes Regulares
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
;Regla Registro para Eleccion de Junta Superior Universitaria para Profesores y Egresados
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
; Regla Registro para Eleccion de Consejo Universitario para Profesores
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
; Regla Registro para Eleccion de Consejo Universitario para Estudiantes
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
; Regla Registro para Consejo de Profesores de Nucleo
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
; Regla Registro para Consejo Electoral de Nucleo
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
; Regla Registro para Consejo Electoral de Nucleo Estudiantes
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
; Postulacion Junta Superior Universitaria o Tribunal Academico
;--
	(defrule ReglaPostulacionJSUTAProfesorEgresado "JSU o TA"
		(eleccion (tipo "junta superior universitaria" | "tribunal academico"))
		(persona (tipo "profesor" | "egresado"))
		(operacion (nombre "postulacion"))
		=>
		(assert(candidato (nombre "Si")))
		(assert (regla (nombre "ReglaPostulacionJSU/TA")))
	)

	(defrule ReglaPostulacionJSUTAEstudiante "JSU o TA"
		(eleccion (tipo "junta superior universitaria" | "tribunal academico"))
		(persona (tipo "estudiante") (status "regular"))
		(operacion (nombre "postulacion"))
		=>
		(assert(candidato (nombre "Si")))
		(assert (regla (nombre "ReglaPostulacionJSU/TA")))
	)
	
;--
; Consejo Universitario
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
	
	(defrule ReglaPostulacionConsejoUniversitarioEstudiante "Consejo Universitario Estudiante"
		(eleccion (tipo "consejo universitario"))
		(persona (tipo "profesor"))
		(operacion (nombre "postulacion"))
		=>
		(assert(candidato (nombre "Si")))
		(assert (regla (nombre "ReglaPostulacionCU Profesor")))
	)
	
;--
; Regla Postulacion para Consejo Electoral de Nucleo Profesores Egresados
;--
	(defrule ReglaPostulacionConsejoElectoralNucleoProfesorEgresado "Regla Postulacion Consejo Electoral de Nucleo Profesores Egresados"
		(operacion (nombre "postulacion"))
		(eleccion (tipo "consejo electoral de nucleo")(nucleo ?n))
		(persona (tipo "profesor"|"egresado")(nucleo ?np & ?n))
		=>
		(assert(candidato (nombre "Si")))
		(assert (regla (nombre "ReglaPostulacionConsejoElectoralNucleoProfesorEgresado")))
		(printout t " Regla Postulacion Consejo Electoral de Nucleo Profesores Egresados" ?n crlf)
	)
	
;--
; Regla Postulacion para Consejo Electoral de Nucleo Estudiantes
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
; Regla Postulacion para Consejo de Profesores de Nucleo
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

