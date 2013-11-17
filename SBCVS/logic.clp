
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
		(persona (tipo ?t & "egresado"))
		=>
		(assert(registro (nombre "Si")))
		(assert (regla (nombre "ReglaRegistroRector")))
		(printout t " Regla RegistroRector Egresado" crlf)
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

; Consejo Universitario
(defrule ReglaPostulacionConsejoUniversitario "ConsejoUniversitario"
	(eleccion (tipo "consejo universitario"))
	(persona (tipo "profesor" | "estudiante"))
	(operacion (nombre "postulacion"))
	=>
	(assert(candidato (nombre "Si")))
	(assert (regla (nombre "ReglaPostulacionCU")))
	)

; Junta Superior Universitaria o Tribunal Academico
(defrule ReglaPostulacionJSUTA "JSU o TA"
	(eleccion (tipo "junta superior universitaria" | "tribunal academico"))
	(persona (tipo "profesor" | "estudiante" | "egresado"))
	(operacion (nombre "postulacion"))
	=>
	(assert(candidato (nombre "Si")))
	(assert (regla (nombre "ReglaPostulacionJSU/TA")))
	)

;Consejo Electoral de {Nucleo}
(defrule ReglaConsejoElectoralNucleo "Consejo Electoral de Nucleo"	
	(eleccion (tipo "consejo electoral de nucleo"))
	(persona (tipo "profesor" | "estudiante" | "egresado"))
	(operacion (nombre "postulacion"))
	=>
	(assert(candidato (nombre "Si")))
	(assert (regla (nombre "ReglaConsejoElectoralNucleo")))
)

;Consejo de Profesores de {Nucleo}
(defrule CPN "Consejo de Profesores de Nucleo"	
	(eleccion (tipo "consejo de profesores de nucleo"))
	(persona (tipo "profesor"))
	(operacion (nombre "postulacion"))
	=>
	(assert(candidato (nombre "Si")))
	(assert (regla (nombre "r5")))
)

; ------------------------------- 
; FIN REGLAS POSTULACIONES 
; -------------------------------

;---
;Fin Reglas
;---

