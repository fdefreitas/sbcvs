
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

(defrule r0
	(persona (tipo "estudiante")
                 (status "irregular"))
	=>
	(assert(candidato (nombre "No")))
	(assert (regla (nombre "r0")))
)

;Eleccion Rector
(defrule r1 "eleccion rector"
	(eleccion (tipo "rector"))
	=>
	(assert(candidato (nombre "Si")))
	(assert (regla (nombre "r1")))
	)

; Eleccion Vicerrector
(defrule r2 "eleccion vicerrector"
	(eleccion (tipo "vicerrector"))
	=>
	(assert(candidato (nombre "Si")))
	(assert (regla (nombre "r2")))
)

;Eleccion Secretario
(defrule r3 "eleccion secretario"
	(eleccion (tipo "secretario"))
	=>
	(assert(candidato (nombre "Si")))
	(assert (regla (nombre "r3")))
)

;Decano de {Nucleo}
(defrule r4 "Decano de Nucleo"	
	(eleccion (tipo "decano") (nucleo ?n))
	(persona (tipo "profesor")(nucleo ?np & ?n))
	=>
	(assert(candidato (nombre "Si")))
	(assert (regla (nombre "r4")))
)
;---
;Fin Reglas
;---

