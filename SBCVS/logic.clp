
;Fernando De Freitas
;iñaki De Tejada Plessmann
;Francisco López
;Ingenieria del Conocimiento
;Proyecto

;---
;Templates
;---

(deftemplate persona
(slot nombre (type STRING))
(slot cedula (type NUMBER))
(multislot tipo (type STRING))
(slot status (type STRING))
(slot nucleo (type STRING))
(slot escuela (type STRING))
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
	(estudiante si)
	(status irregular)
	=>
	(assert(candidato (nombre "No")))
	(assert (regla (nombre "r0")))
	)

;---
;Fin Reglas
;---