# Islas inundadas

Los científicos están muy preocupados por el incremento del nivel del mar provocado por el cambio climático. Como consecuencia, el agua salada invade y cubre áreas como playas, ciudades costeras, manglares u otros paraísos turísticos y naturales. Una de las principales preocupaciones son muchas pequeñas islas de poca extensión y altitud que están en peligro de desaparecer junto con su fauna y flora.

Los científicos tienen mapas de estas islas. De cada cuadrante se conoce la altitud en metros sobre el nivel del mar (msnm). Aunque se conoce el incremento del nivel del mar en años pasados, no se sabe a ciencia cierta cómo se comportará el nivel del mar en años venideros, pues depende de la consciencia de la humanidad y las acciones que tome.

Sería de mucha utilidad un programa que dado un mapa de una isla y las proyecciones del nivel del mar a lo largo de varios años, indique para cada proyección el porcentaje del territorio de la isla que estará cubierta de agua. Un porcentaje de 100% indicaría la desaparición de la isla.

El programa recibiría en la entrada estándar las dimensiones del mapa (en número de filas y columnas). Luego la altura en msnm de cada cuadrante. Un valor de cero indica que el cuadrante está al nivel del mar o debajo de él. Finalmente, en la entrada estándar vienen las proyecciones de nivel del mar en varios años. Algunos científicos estiman que el nivel del mar siempre crecerá, otros que disminuirá, otros que fluctuará. De esta forma, los niveles podrían subir o bajar a lo largo del tiempo.

Como es natural, cuando el nivel del mar incrementa invade las zonas costeras con menor o igual altitud. Pero no necesariamente invade todos los cuadrantes que están bajo el nivel del mar. Por ejemplo, si dentro de la isla hay un valle más profundo que el nivel del mar pero protegido por montañas, el mar no lo invadirá a menos que sobrepase esas montañas.

Si el nivel del mar disminuye, las zonas costeras resurgen y no estarán cubiertas de agua. Si agua se queda apresada en un valle dentro de una isla, este eventualmente se secará por evaporación y por tanto, se considerará una zona no inundada.


**Entrada de ejemplo**:

	7 6

	0 0 2 1 1 0
	0 1 3 2 3 1
	0 0 3 1 4 1
	1 2 4 1 5 3
	2 4 6 3 6 0
	0 5 7 4 7 0
	0 0 6 5 0 0

	2020 1
	2025 2
	2030 4
	2035 3
	2040 0
	2045 7
	2050 8


**Salida de ejemplo**:

	2020: 1.0 45.2%
	2025: 2.0 59.5%
	2030: 4.0 81.0%
	2035: 3.0 71.4%
	2040: 0.0 31.0%
	2045: 7.0 100.0%
	2050: 8.0 100.0%

Nota: las alturas del mapa y los niveles del mar deben tratarse como números reales.
