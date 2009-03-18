/**CONSULTA 13*/
/*
dar el nombre de los estudiantes que pueden consederarse candidatos a mejores setudantes de cada carrera en el presente plan, para ser candidato a mojr estudiante de una carrera debe tenerse en este momento el mejor promedio de su promocion y carrera, no haber perdido ninguna vez un curso, tener mas creditos aprobados que el resto de estudiantes de su promocion y carrera

Obtenemos todos los estudiantes tal que alguno de estos tenga el maximo promedio y que no exista algun  curso que haya perdido y que exista que para su carrera haya aprobado el numero de creditos dados.
*/
SELECT ES.CARNET,ES.PRIMER_NOMBRE||' '||ES.PRIMER_APELLIDO,CA.NOMBRE
FROM PLAN PL, CARRERA CA, ESTUDIANTE ES
WHERE CA.CARRERA = ES.CARRERA
AND PL.CARRERA = CA.CARRERA
AND EXISTS (
	SELECT CARNET1,MAX(PROM)
	FROM(
		SELECT AS1.CARNET"CARNET1", AVG(NOTA)"PROM"
		FROM ASIGNACION AS1, APROBACION AP1, PLAN PL1
		WHERE (	(PL1.ANIO_INICIO = AS1.ANIO AND PL1.CICLO_INICIO <= AS1.CICLO)
				OR (PL1.ANIO_FIN = AS1.ANIO AND PL1.CICLO_FIN >= AS1.CICLO)
				OR (PL1.ANIO_INICIO < AS1.ANIO AND PL1.ANIO_FIN > AS1.ANIO)
		)
		/*WHERE PL1.ANIO_INICIO <= AS1.ANIO
		AND PL1.ANIO_FIN > AS1.ANIO
		AND PL1.CICLO_INICIO <= AS1.CICLO
		AND PL1.CICLO_FIN > AS1.CICLO*/
		AND AP1.PLAN = PL1.PLAN
		AND AP1.CARRERA = PL1.CARRERA
		AND AP1.CICLO = AS1.CICLO
		AND AS1.NOTA >= AP1.NOTA_APROBACION
		AND AS1.ZONA >= AP1.ZONA_MINIMA	
		GROUP BY AS1.CARNET
	)
	GROUP BY CARNET1
	HAVING CARNET1 = ES.CARNET
) AND NOT EXISTS(
	SELECT 1
	FROM ASIGNACION AS1, APROBACION AP1, PLAN PL1
	WHERE AS1.CARNET = ES.CARNET
	AND PL1.ANIO_INICIO <= AS1.ANIO
	AND (	(PL1.ANIO_INICIO = AS1.ANIO AND PL1.CICLO_INICIO <= AS1.CICLO)
				OR (PL1.ANIO_FIN = AS1.ANIO AND PL1.CICLO_FIN >= AS1.CICLO)
				OR (PL1.ANIO_INICIO < AS1.ANIO AND PL1.ANIO_FIN > AS1.ANIO)
	)
	/*AND PL1.ANIO_FIN > AS1.ANIO
	AND PL1.CICLO_INICIO <= AS1.CICLO
	AND PL1.CICLO_FIN > AS1.CICLO
	*/
	AND AP1.PLAN = PL1.PLAN
	AND AP1.CARRERA = PL1.CARRERA
	AND AP1.CICLO = AS1.CICLO
	AND AS1.NOTA < AP1.NOTA_APROBACION
	AND AS1.ZONA < AP1.ZONA_MINIMA	
) AND EXISTS(
	SELECT CARRERA,MAX(NUM_CREDITOS)
	FROM (
		SELECT DISTINCT AS1.CARNET"CARNET", E2.CARRERA, COUNT(CU1.CREDITOS)"NUM_CREDITOS", SUBSTR(TO_CHAR(AS1.CARNET),1,4)"PROMO"
		FROM ASIGNACION AS1, APROBACION AP1, PLAN PL1,CARRERA CA2, ESTUDIANTE E2, PENSUM PE1,CURSO CU1
		WHERE E2.CARNET = AS1.CARNET
		AND CA2.CARRERA = E2.CARRERA
		AND PE1.CARRERA = E2.CARRERA
		AND AS1.CODIGO = PE1.CODIGO
		AND CU1.CURSO = AS1.CODIGO
		AND PE1.PLAN = PL1.PLAN
		AND (	(PL1.ANIO_INICIO = AS1.ANIO AND PL1.CICLO_INICIO <= AS1.CICLO)
				OR (PL1.ANIO_FIN = AS1.ANIO AND PL1.CICLO_FIN >= AS1.CICLO)
				OR (PL1.ANIO_INICIO < AS1.ANIO AND PL1.ANIO_FIN > AS1.ANIO)
		)
		/*AND PL1.ANIO_INICIO <= AS1.ANIO
		AND PL1.ANIO_FIN > AS1.ANIO
		AND PL1.CICLO_INICIO <= AS1.CICLO
		AND PL1.CICLO_FIN > AS1.CICLO*/
		AND AP1.PLAN = PL1.PLAN
		AND AP1.CARRERA = PL1.CARRERA
		AND AP1.CICLO = AS1.CICLO
		AND AS1.NOTA >= AP1.NOTA_APROBACION
		AND AS1.ZONA >= AP1.ZONA_MINIMA
		GROUP BY AS1.CARNET,E2.CARRERA
	)
	WHERE CARNET = ES.CARNET
	GROUP BY CARRERA
);


