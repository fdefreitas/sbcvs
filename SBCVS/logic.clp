
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

; ------------------------------- 
; FIN REGLAS REGISTROS
; -------------------------------

; ------------------------------- 
; REGLAS POSTULACIONES 
; -------------------------------

; Postulacion Rector
(defrule ReglaPostulacionRector "Regla Postulacion Rector"
	(eleccion (tipo "rector, vicerrector y secretario"))
	(persona (tipo "profesor")(status "agregado"| "asociado" | "titular"))
	=>
	(assert(candidato (nombre "Si")))
	(assert (regla (nombre "r1")))
	)

;Decano de {Nucleo}
(defrule r4 "Decano de Nucleo"	
	(eleccion (tipo "decano") (nucleo ?n))
	(persona (tipo "profesor")(nucleo ?np & ?n))
	=>
	(assert(candidato (nombre "Si")))
	(assert (regla (nombre "r4")))
)

; ------------------------------- 
; FIN REGLAS POSTULACIONES 
; -------------------------------

;---
;Fin Reglas
;---

