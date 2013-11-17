
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

;---
;Fin Templates
;---


;---
;Reglas
;---

; ------------------------------- 
; REGLAS REGISTROS 
; -------------------------------

(defrule r0
	(persona (tipo "estudiante")(status "irregular"))
	=>
	(assert(candidato (nombre "No")))
	(assert (regla (nombre "r0")))
)

(defrule r6
    ;(operacion(nombre "postular"))
    (eleccion (nucleo ?n))
    (persona (nucleo ?np & ?n))
    =>
    (assert(candidato (nombre "No")))
    (assert (regla (nombre "r6")))
	(printout t ?np " " ?n " r6 " crlf)
)

; ------------------------------- 
; FIN REGLAS REGISTROS
; -------------------------------

; ------------------------------- 
; REGLAS POSTULACIONES 
; -------------------------------

; Postulacion Rector, Vicerrector y Secretario
(defrule ReglaPostulacionRector "Regla Postulacion Rector, Vicerrector y Secretario"
	(eleccion (tipo "rector, vicerrector y secretario") (nucleo ?n))
	(persona (tipo "profesor")(status "agregado"| "asociado" | "titular"))
	=>
	(assert(candidato (nombre "Si")))
	(assert (regla (nombre "ReglaPostulacionRector")))
	(printout t " ReglaPostulacionRector " crlf)
	)

; Consejo Universitario
(defrule ReglaPostulacionConsejoUniversitario "ConsejoUniversitario"
	(eleccion (tipo "consejo universitario"))
	(persona (tipo "profesor" | "estudiante"))
	=>
	(assert(candidato (nombre "Si")))
	(assert (regla (nombre "ReglaPostulacionCU")))
	)

; Junta Superior Universitaria o Tribunal Academico
(defrule ReglaPostulacionJSUTA "JSU o TA"
	(eleccion (tipo "junta superior universitaria" | "tribunal academico"))
	(persona (tipo "profesor" | "estudiante" | "egresado"))
	=>
	(assert(candidato (nombre "Si")))
	(assert (regla (nombre "ReglaPostulacionJSU/TA")))
	)

;Consejo Electoral de {Nucleo}
(defrule ReglaConsejoElectoralNucleo "Consejo Electoral de Nucleo"	
	(eleccion (tipo "consejo electoral de nucleo") (nucleo ?n))
	(persona (tipo "profesor" | "estudiante" | "egresado")(nucleo ?np & ?n))
	=>
	(assert(candidato (nombre "Si")))
	(assert (regla (nombre "ReglaConsejoElectoralNucleo")))
)

;Consejo de Profesores de {Nucleo}
(defrule CPN "Consejo de Profesores de Nucleo"	
	(eleccion (tipo "consejo de profesores de nucleo") (nucleo ?n))
	(persona (tipo "profesor")(nucleo ?np & ?n))
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

