$(document).ready(function(){

	var directorioImagenes = "img/cartas/";
	var $canvas = $("#canvasJuego");
	
	var matrizTablero = new Object(); //cantidad de filas y columnas
	matrizTablero.cantFilas = 3;
	matrizTablero.cantColumnas = 8;

	var matrizAcumulacion = new Object();
	matrizAcumulacion.cantFilas = 4;
	matrizAcumulacion.cantColumnas = 2;

	var dimensionCartas = new Object(); //tamaño del archivo imagen de la cartas
	dimensionCartas.ancho = 71;	
	dimensionCartas.alto = 96;

	var dimensionAjustadaCarta = new Object; // dimensiones en la que se va a ver la carta

	var tableroGrafico = null;
	var tableroGraficoAcumulacion = null;
	var tableroLogico = null;
	var tableroAcumulacion = null;

	var dragCarta = null;

	var naipeIngles = ["c", "d", "p", "t"];

	/*
		crear cartas para baraja inglesa

			cantidad = cantidad de barajas que se quieren
	*/
	var crear_barajaInglesa = function(cantidad)
	{
		var carta, 
			baraja = new Array();
		
		for(var k = 0; k < cantidad; k++)
		{
			for(var j in naipeIngles)
			{	
				for(var i = 1; i <= 13; i++)
				{
					carta = new Object();
					carta.naipe = naipeIngles[j];
					carta.numero = i;
					carta.bocaAbajo = true;

					baraja.push(carta);
				}	
			}
		}

		return baraja;
	};

	/*
		mezcla las cartas de la baraja

			baraja = baraja a mezclar
	*/

	var mezclar_baraja = function(baraja)
	{
		var barajaMezclada = new Array(),
			numeroCarta;

		while(baraja.length != 0)
		{
			numeroCarta = Math.floor(Math.random()*baraja.length);
			barajaMezclada.push(baraja[numeroCarta]);
			baraja.splice(numeroCarta,1);
		}

		return barajaMezclada;
	};

	/*
		crea el tablero del regimiento. Solo es la parte donde se encuentran las cartas para jugar
			
			tablero = 8 x 3
	*/
	var crear_tablero_ppal = function()
	{
		return crear_tablero(matrizTablero.cantColumnas, matrizTablero.cantFilas);
	};

	/*
		creo el tablero donde se van depositando las cartas para completar el juego
			
			tablero = 2 x 4
	*/
	var crear_tablero_acumulacion = function()
	{
		return crear_tablero(matrizAcumulacion.cantColumnas, matrizAcumulacion.cantFilas);
	};

	var crear_tablero = function(cantColumnas, cantFilas)
	{
		var tablero = new Array(cantColumnas);

		for(var i = 0; i < cantColumnas; i++)
		{
			tablero[i] = new Array(cantFilas);

			for(var j = 0; j < cantFilas; j++)
			{
				tablero[i][j] = new Array();
			}
		}

		return tablero;
	};

	/*
		lógica para repartir las cartas para el regimento
		
		iniciliza el tablero de acumulación con el valor de las cartas que espera recibir
	*/
	var repartir_cartas_regimiento = function(baraja, tableroLogico, tableroAcumulacion)
	{ 
		var posEnBaraja = 0,
			cantDeCartasPorPosicion = (baraja.length /tableroLogico.length) - 2; // el 2 es por la carta de arriba y la de abajo

		for(var i = 0; i < tableroLogico.length; i++, posEnBaraja++)
		{
			tableroLogico[i][0].push(baraja[posEnBaraja]); // las cartas que están arriba
			tableroLogico[i][0][0].bocaAbajo = false;
		}

		for(var i = 0; i < tableroLogico.length; i++, posEnBaraja++)
		{
			tableroLogico[i][2].push(baraja[posEnBaraja]); // las cartas que están abajo
			tableroLogico[i][2][0].bocaAbajo = false;
		}

		for(var j = 0; j < cantDeCartasPorPosicion; j++)
		{
			tableroLogico[0][1].push(baraja[posEnBaraja]);
			tableroLogico[0][1][0].bocaAbajo = false;
			posEnBaraja++;

			for(var i = 1; i < tableroLogico.length; i++, posEnBaraja++)
			{
				tableroLogico[i][1].push(baraja[posEnBaraja]); // las cartas que están en el medio
			}
		}

		for(var j = 0; j < tableroAcumulacion.length; j++) // inicializa sin ninguna carta
		{
			for(var i = 0; i < tableroAcumulacion[j].length; i++)
			{
				tableroAcumulacion[j][i] = new Array();
				tableroAcumulacion[j][i].push({
					naipe: naipeIngles[i],
					numero: 13*j + 1*(1-j)
				});
			}
		}
	};

	/*
		determina las posiciones donde se van a encontrar las cartas en la vista
	*/	
	var init_grafica = function(tableroGrafico, tableroGraficoAcumulacion)
	{
		// canvas para el regimiento
		$canvas[0].getContext("2d");

		// para que ocupe toda la pantalla
		$canvas[0].width  = $(window).width();
		$canvas[0].height = $(window).height();

		// para escuchar eventos
		$("canvas").mousedown(funcion_mouse_down);
		$("canvas").mouseup(funcion_mouse_up);
		$("canvas").mousemove(funcion_mouse_move);
		$("canvas").dblclick(funcion_mouse_dobleClick);

		var anchoVentana = $canvas[0].width,
			altoVentana = $canvas[0].height,
			coefOffsetAlto = 0.04,
			coefOffsetAncho = (1 - 2.5 * (dimensionCartas.ancho/dimensionCartas.alto) * (altoVentana/anchoVentana) * (1 - 7 * coefOffsetAlto))/12,
			coefCartaAlto = (1 - 7 * coefOffsetAlto)/4,
			coefCartaAncho = (1 - 12 * coefOffsetAncho)/10,
			altoCarta = Math.round(coefCartaAlto * altoVentana),
			anchoCarta = Math.round(coefCartaAncho * anchoVentana),
			altoOffset = Math.round(coefOffsetAlto * altoVentana),
			anchoOffset = Math.round(coefOffsetAncho * anchoVentana),
			offsetX = anchoOffset,
			offsetY = Math.round((altoVentana - 3 * altoCarta)/2 - altoOffset),
			offsetXAux;

		dimensionAjustadaCarta.ancho = anchoCarta;
		dimensionAjustadaCarta.alto = altoCarta;

		/* tablero del juego. Donde están las cartas inicialmente*/
		for (var j = 0; j < matrizTablero.cantFilas; j++)
		{
			offsetX = anchoOffset;	

			for (var i = 0; i < matrizTablero.cantColumnas; i++)
			{
				tableroGrafico[i][j] = new Object();
				tableroGrafico[i][j].x = offsetX;
				tableroGrafico[i][j].y = offsetY;

				offsetX += anchoCarta + anchoOffset;
			}
			offsetY += altoCarta + altoOffset/3;
		}

		offsetX += anchoOffset;
		offsetY = Math.round((altoVentana - 4 * altoCarta - 3 * altoOffset)/2);

		/* donde van las K y los Ases */
		for(var j = 0; j < matrizAcumulacion.cantFilas; j++)
		{
			offsetXAux = offsetX;

			for (var i = 0; i < matrizAcumulacion.cantColumnas; i++)
			{
				tableroGraficoAcumulacion[i][j] = new Object();
				tableroGraficoAcumulacion[i][j].x = offsetXAux;
				tableroGraficoAcumulacion[i][j].y = offsetY;

				offsetXAux += anchoCarta + anchoOffset;
			}
			offsetY += altoCarta + altoOffset;
		}
	};

	/*
		carga el nombre del archivo imagen que representa a la carta
	*/
	var cargar_imagen_cartas = function(baraja)
	{
		var carta;

		for(var i = 0; i < baraja.length; i++)
		{
			carta = baraja[i];
			carta.path = directorioImagenes + carta.naipe + carta.numero + ".png";
		}
	};

	/*
		dibujar el rectángulo que representa las posiciones donde puede ir una carta
	*/

	var dibujar_tablero = function(tableroGrafico)
	{
		for (var j = 0; j < tableroGrafico.length; j++)
		{
			for (var i = 0; i < tableroGrafico[j].length; i++)
			{
				$("canvas").drawRect({
					fillStyle: "#500",
					x: tableroGrafico[j][i].x,
					y: tableroGrafico[j][i].y,
					width: dimensionAjustadaCarta.ancho,
					height: dimensionAjustadaCarta.alto,
					fromCenter: false
				});
			}
		}
	};

	var dibujar_cartas = function(tableroLogico)
	{
		var carta;
	//	$("#cartas").append("<p>Cartas<p>");
		for(var i = 0; i < tableroLogico.length; i++)
		{
			for (var j = 0; j < tableroLogico[i].length; j++)
			{
				carta = tableroLogico[i][j][0];
				
				if (carta != null)
				{
					$("canvas").drawImage({
						source: carta.path,
						x: carta.x,
						y: carta.y,
						width: dimensionAjustadaCarta.ancho,
						height: dimensionAjustadaCarta.alto,
						fromCenter: false
					});
					
					$("#cartas").append(carta.naipe+carta.numero + " ");
				}
			}
	//		$("#cartas").append("<p></p>");
		}
	};

	var dibujar_cartas_acumuladas = function(tableroLogicoAcumulacion)
	{
		var carta, posicionUltimaCarta;

		for(var i = 0; i < tableroLogicoAcumulacion.length; i++)
		{
			for (var j = 0; j < tableroLogicoAcumulacion[i].length; j++)
			{
				posicionUltimaCarta = tableroLogicoAcumulacion[i][j].length - 1; // la prox carta a recibir

				if (posicionUltimaCarta != 0) 
				{
					carta = tableroLogicoAcumulacion[i][j][posicionUltimaCarta-1].carta; // la últ carta colocada
					 				
					$("canvas").drawImage({
						source: carta.path,
						x: carta.x,
						y: carta.y,
						width: dimensionAjustadaCarta.ancho,
						height: dimensionAjustadaCarta.alto,
						fromCenter: false
					});						
				}
			}			
		}
	};

	var dibujar_tablero_actual = function(tableroLogico, tableroAcumulacion, tableroGrafico, tableroGraficoAcumulacion)
	{
		var source = "img/fondo00.png";

		$("canvas").drawImage({
			source: source,
			x: 0, y: 0,
			width: $canvas[0].width,
			height: $canvas[0].height,
			fromCenter: false,
			load: function()
				{
  					dibujar_tablero(tableroGrafico);
					dibujar_tablero(tableroGraficoAcumulacion);
					dibujar_cartas(tableroLogico);
					dibujar_cartas_acumuladas(tableroAcumulacion);
  				}
		});
	};

	/*
		seteo las posiciones iniciales de las cartas en la vista
	*/
	var init_posiciones = function(tableroLogico, tableroGrafico)
	{
		var carta;

		for(var i = 0; i < tableroLogico.length; i++)
		{
			for (var j = 0; j < tableroLogico[i].length; j++)
			{
				carta = tableroLogico[i][j][0];
				carta.x = tableroGrafico[i][j].x;
				carta.y = tableroGrafico[i][j].y;
			}
		}
	};

	// Reset the game when the player catches a monster
	var reset = function () {
		hero.x = canvas.width / 2;
		hero.y = canvas.height / 2;
	};

	// Update game objects
	var update = function (modifier) {
		if (38 in keysDown) { // Player holding up
			hero.y -= hero.speed * modifier;
		}
		if (40 in keysDown) { // Player holding down
			hero.y += hero.speed * modifier;
		}
		if (37 in keysDown) { // Player holding left
			hero.x -= hero.speed * modifier;
		}
		if (39 in keysDown) { // Player holding right
			hero.x += hero.speed * modifier;
		}

		// Are they touching?
		if (
			hero.x <= (monster.x + 32)
			&& monster.x <= (hero.x + 32)
			&& hero.y <= (monster.y + 32)
			&& monster.y <= (hero.y + 32)
		) {
			++monstersCaught;
			reset();
		}
	};

	// Draw everything
	var render = function () {
		if (bgReady) {
			ctx.drawImage(bgImage, 0, 0);
		}
		
		if (heroReady) {
			ctx.drawImage(heroImage, hero.x, hero.y);
		}

		if (monsterReady) {
			ctx.drawImage(monsterImage, monster.x, monster.y);
		}

		// Score
		ctx.fillStyle = "rgb(250, 250, 250)";
		ctx.font = "24px Helvetica";
		ctx.textAlign = "left";
		ctx.textBaseline = "top";
		ctx.fillText("Goblins caught: " + monstersCaught, 32, 32);
	};

	// The main game loop
	var main = function () {
		var now = Date.now();
		var delta = now - then;
		update(delta / 1000);
		render();

		then = now;
	};

	// Let's play this game!
	//reset();
	var then = Date.now();
	//setInterval(main, 1); // Execute as fast as possible

	/*
		Eventos del mouse
	*/
	
	var buscar_posicion_seleccionada_tablero = function(posicion)
	{
		var posicionSeleccionadaTablero = null; 												
		for(var j = 0; j < tableroGrafico.length; j++)
		{
			for(var i = 0; i < tableroGrafico[j].length; i++)
			{
				if(esta_seleccionada(tableroGrafico[j][i], posicion) == true)
				{
					posicionSeleccionadaTablero = { nroColumna:j,
													nroFila: i };

					return posicionSeleccionadaTablero;
				}
			}
		}
		
		return posicionSeleccionadaTablero;
	};
	
	var funcion_mouse_down = function (e)
	{
		var posicion = get_posicion_mouse(e),
			posicionSeleccionada = buscar_posicion_seleccionada_tablero(posicion),
			carta;
		
		if (posicionSeleccionada == null) {
			return;
		}
		
		if(tableroLogico[posicionSeleccionada.nroColumna][posicionSeleccionada.nroFila][0] == null) {
			return;
		}
		
		carta = tableroLogico[posicionSeleccionada.nroColumna][posicionSeleccionada.nroFila][0];
		
		dragCarta = {
			carta: carta,
			desplazamientoX: posicion.x - tableroLogico[posicionSeleccionada.nroColumna][posicionSeleccionada.nroFila][0].x, 
			desplazamientoY: posicion.y - tableroLogico[posicionSeleccionada.nroColumna][posicionSeleccionada.nroFila][0].y,
			posXanterior: carta.x,
			posYanterior: carta.y
		};

		return;
	};
	
	var funcion_mouse_up = function (e)
	{
		if (dragCarta == null) {
			return;
		}
		
		var posicion = get_posicion_mouse(e),
			posicionSeleccionada = buscar_posicion_seleccionada_tablero(posicion);
		
		if (posicionSeleccionada == null) //si qdó fuera de alguna posición válida vuelve a la posición anterioir
		{
			dragCarta.carta.x = dragCarta.posXanterior;
			dragCarta.carta.y = dragCarta.posYanterior;
		}
		else //ubicarla en la nueva posición.
		{
			dragCarta.carta.x = dragCarta.posXanterior;
//			dragCarta.carta.y = dragCarta.posYanterior;
		}
		
		dibujar_tablero_actual(tableroLogico, tableroAcumulacion, tableroGrafico, tableroGraficoAcumulacion);
		dragCarta = null;
	};

	var funcion_mouse_move = function (e)
	{
		if(dragCarta == null) {	
			return;
		}

		var carta = dragCarta.carta,
			posicionNueva = get_posicion_mouse(e);

		carta.x = posicionNueva.x - dragCarta.desplazamientoX;
		carta.y = posicionNueva.y - dragCarta.desplazamientoY;

		dibujar_tablero_actual(tableroLogico, tableroAcumulacion, tableroGrafico, tableroGraficoAcumulacion);
	};
	
	var funcion_mouse_dobleClick = function(e)
	{
		var posicion = get_posicion_mouse(e),
			posicionSeleccionada = buscar_posicion_seleccionada_tablero(posicion),	
			elementoCreciente,
			elementoDecreciente,
			carta;

		if(posicionSeleccionada == null) {
			return;
		}
		
		carta = tableroLogico[posicionSeleccionada.nroColumna][posicionSeleccionada.nroFila][0];
		
		if(carta == null) {
			return;
		}
		
		for(var k = 0; k < matrizAcumulacion.cantFilas; k++)
		{
			elementoCreciente = tableroAcumulacion[0][k][tableroAcumulacion[0][k].length - 1];
			elementoDecreciente = tableroAcumulacion[1][k][tableroAcumulacion[1][k].length - 1];
			
			if(elementoCreciente.naipe == carta.naipe)
			{
				if (elementoCreciente.numero == carta.numero && elementoDecreciente.numero == carta.numero)
				{
					alert("son iguales");
				}
				else if (elementoCreciente.numero == carta.numero)
				{
					actualizarTableros(carta, 0, k, elementoCreciente, posicionSeleccionada.nroColumna, posicionSeleccionada.nroFila, 1);
				}
				else if (elementoDecreciente.numero == carta.numero)
				{
					actualizarTableros(carta, 1, k, elementoDecreciente, posicionSeleccionada.nroColumna, posicionSeleccionada.nroFila, -1);		
				}
				
				dibujar_tablero_actual(tableroLogico, tableroAcumulacion, tableroGrafico, tableroGraficoAcumulacion);
				return;
			}
		}
	};

	var esta_seleccionada = function(posicionTablero, posicion)
	{
		var ladoIzquierdo = posicionTablero.x,
			ladoDerecho = dimensionAjustadaCarta.ancho + posicionTablero.x,
			ladoInferior = dimensionAjustadaCarta.alto + posicionTablero.y,
			ladoSuperior = posicionTablero.y;
		
		if(posicion.x <= ladoDerecho && posicion.x >= ladoIzquierdo && posicion.y >= ladoSuperior && posicion.y <= ladoInferior) {
			return true;			
		}
		
		return false;
	};

	var get_posicion_mouse = function(e)
	{
		var posicion = $canvas[0].getBoundingClientRect();
		var posicionMouse = {
		    x: e.clientX - posicion.left,
		    y: e.clientY - posicion.top
		};

		return posicionMouse;
	};
	

	var actualizarTableros = function(carta, columnaAcumulacion, filaAcumulacion, elemento, columnaTablero, filaTablero, sumar)
	{
		carta.x = tableroGraficoAcumulacion[columnaAcumulacion][filaAcumulacion].x;
		carta.y = tableroGraficoAcumulacion[columnaAcumulacion][filaAcumulacion].y;
								
		elemento.carta = carta;
																
		tableroAcumulacion[columnaAcumulacion][filaAcumulacion].push({
			naipe: elemento.naipe, 
			numero: elemento.numero + 1 * sumar
		});
		
		tableroLogico[columnaTablero][filaTablero].shift();
		
		if(tableroLogico[columnaTablero][filaTablero][0] != null) // hay una carta
		{
			tableroLogico[columnaTablero][filaTablero][0].x = tableroGrafico[columnaTablero][filaTablero].x;
			tableroLogico[columnaTablero][filaTablero][0].y = tableroGrafico[columnaTablero][filaTablero].y;
		}

		if(filaTablero != 1 && tableroLogico[columnaTablero][1].length !=0) // o sea, no es la fila del medio y ya no qdan cartas en ese lugar
		{
			tableroLogico[columnaTablero][filaTablero][0] = tableroLogico[columnaTablero][1][0];
			//muevo de lugar la carta que se encontraba en el centro
			tableroLogico[columnaTablero][filaTablero][0].x = tableroGrafico[columnaTablero][filaTablero].x;
			tableroLogico[columnaTablero][filaTablero][0].y = tableroGrafico[columnaTablero][filaTablero].y;
			
			tableroLogico[columnaTablero][1].shift();
			
			if(tableroLogico[columnaTablero][1][0] != null) // hay una carta
			{
				//ubico en el nuevo lugar la carta del centro
				tableroLogico[columnaTablero][1][0].x = tableroGrafico[columnaTablero][1].x;
				tableroLogico[columnaTablero][1][0].y = tableroGrafico[columnaTablero][1].y;
			}
		}
	};

	var cartas = crear_barajaInglesa(2);
	var mazo = mezclar_baraja(cartas);
	
	function regiment_game()
	{
		tableroLogico = crear_tablero_ppal();
		tableroAcumulacion = crear_tablero_acumulacion();
		
		tableroGrafico = crear_tablero_ppal();
		tableroGraficoAcumulacion = crear_tablero_acumulacion();

		init_grafica(tableroGrafico, tableroGraficoAcumulacion);
		cargar_imagen_cartas(mazo);
		repartir_cartas_regimiento(mazo, tableroLogico, tableroAcumulacion);
		init_posiciones(tableroLogico, tableroGrafico);
		dibujar_tablero_actual(tableroLogico, tableroAcumulacion, tableroGrafico, tableroGraficoAcumulacion);
	};
	
	regiment_game();
});

/*
 * 		carta
 * 			numero
 * 			naipe
 * 			bocaAbajo
 * 			x
 * 			y
 * 			path
 */