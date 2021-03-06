;Declaracion del segmento de pila
PILA SEGMENT STACK
DB 256 DUP(0)
PILA ENDS

ASSUME CS:CODIGO,DS:CODIGO ;REGISTROS PARA DEFINIR BLOQUES DE DECLARACION DE VAR Y DE CODIGO

;**************************DECLARACION DE VARIABLES

CODIGO SEGMENT
	MENSAJE DW 0
	IZQ DB ' RECIBI  IZQUIERDA','$'
	TIT DB ' INICIANDO PROGRAMA','$'
	ARR DB ' RECIBI ARRIBA','$'
	DER DB ' RECIBI DERECHA','$'
	ADI DB ' ********************SALIDA**********************','$'
	BANDERA DW 0
	REGISTRO DW 0

;**************************SEGMENTO DE CODIGO


MAIN PROC FAR	; CODIGO PRINCIPAL
	MOV AX,CS
	MOV DS,AX
	;CALL INICIASER
	MOV MENSAJE,OFFSET TIT
	CALL ESCRIBIR

	SALTO:
	CALL SERIALREC
	;MOV AH,1
	;MOV DL,0FFH
	;INT 21H
	
	;CMP AL,'J'
	;JE ADIOS
	JMP SALTO


;***********************************************FLECHAS*********************************************************
MAIN ENDP
ESCRITURA PROC NEAR
	MOV MENSAJE,OFFSET IZQ
	CALL ESCRIBIR
	JMP SALTO
ESCRITURA ENDP
ESCRITURA2 PROC NEAR
	MOV MENSAJE,OFFSET ARR
	CALL ESCRIBIR
	JMP SALTO
ESCRITURA2 ENDP
ESCRITURA3 PROC NEAR
	MOV MENSAJE,OFFSET DER
	CALL ESCRIBIR
	JMP SALTO
ESCRITURA3 ENDP
FINAL PROC NEAR
	MOV MENSAJE,OFFSET ADI
	CALL ESCRIBIR
	JMP SALTO
FINAL ENDP


;*************************************************PUERTO SERIAL**************************************************


;**************************RUTINA PARA INICIALIZAR EL SERIAL
INICIASER PROC NEAR
	MOV SP,PILA
	MOV DX,0;ASIGNAR EL PUERTO COM
	MOV AL,0E3H
	MOV AH,0
	INT 14H
	JMP SALTO
INICIASER ENDP

;**************************RUTINA PARA LEER EN EL SERIAL
SERIALREC PROC NEAR


	MOV SP,PILA
	MOV DX,0;ASIGNAR EL PUERTO COM
	MOV AL,0E3H
	MOV AH,0
	INT 14H



	MOV DX,0;ELIGE PUERTO COM1
	MOV AH,2;ASIGNA FUNCION DE RECIBIR DATOS EN AH
	INT 14H
	CMP AL,10
	JE ESCRITURA2
	CMP AL,01
	JE ESCRITURA
	CMP AL,11
	JE ESCRITURA3
	;CMP AL,00
	;JE FINAL
	JMP SALTO
	
SERIALREC ENDP

;***************************************************ESCRIBIR******************************************************
ESCRIBIR PROC NEAR
	PUSH AX
	PUSH DX
	MOV AH,09H
	MOV DX,MENSAJE
	INT 21H
	MOV AH,06
	MOV DL,0DH
	INT 21H
	MOV AH,06H
	MOV DL,0AH
	INT 21H
	POP DX
	POP AX
	RET
ESCRIBIR ENDP

;**************************************************TECLADO*********************************************************


	ADIOS:

	MOV AH,06
	MOV DL,0DH
	INT 21H
	MOV AH,06H
	MOV DL,0AH
	INT 21H
	
	MOV AH,4CH
	INT 21H

	MOV AH,4CH
	INT 14H
CODIGO ENDS
END MAIN

