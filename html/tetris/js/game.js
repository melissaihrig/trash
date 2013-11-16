$(document).ready(function(){

	var ANCHO_TABLERO = 12; //dos más para el borde
	var ALTO_TABLERO = 23; // 1 más para el borde inferior

    var LADO_CUADRADO = 30;

    var estado = {
        LIBRE: 0,
        OCUPADO: 1
    };

    function TableroTetris (ancho, alto, canvas) {
        this.canvas = canvas;
        this.ancho = ancho;
        this.alto = alto;
        this.altoZonaJuego = this.alto - 3;
        this.anchoZonaJuego = this.ancho - 2;
        this.tablero;
        this.colorBorde = "#D9D9D9";
        this.colorFondo = "#000000"
    };

    TableroTetris.prototype = {
        toString: function() {
            for(var columna = 0; columna < this.alto; columna++) {
                for (var fila = 0; fila < this.ancho; fila++) {
                    $("#test").append(this.tablero[columna][fila]);
                }
                $("#test").append("<br>");
            }
        },
        inicializar: function() {
            this.tablero = new Array(this.alto);
            for(var columna = 0; columna < this.alto; columna++) {
                this.tablero[columna] = new Array(this.alto)

                for(var fila = 0; fila < this.alto; fila++) {
                    this.tablero[columna][fila] = estado.LIBRE;
                }
            }
        },
        dibujarBorde: function() {
            //las dos últimas filas superiores no se dibujan
            for (var bordeDerecho = 0; bordeDerecho < this.alto - 2; bordeDerecho++) {
                this.dibujarCelda(this.colorBorde, 0, bordeDerecho * LADO_CUADRADO);
            }

            for (var bordeIzquierdo = 0; bordeIzquierdo < this.alto - 2; bordeIzquierdo++) {
                this.dibujarCelda(this.colorBorde, (this.ancho - 1) * LADO_CUADRADO, bordeIzquierdo * LADO_CUADRADO);
            }

            //no dibujo los dos extremos porque se dibujaron con los bordes
            for (var bordeInferior = 1; bordeInferior < this.ancho - 1; bordeInferior++) {
                this.dibujarCelda(this.colorBorde, bordeInferior * LADO_CUADRADO, (this.alto - 3) * LADO_CUADRADO);
            }
        },
        dibujarTablero: function() {
            for(var columna = 1; columna <= this.anchoZonaJuego; columna++) {
                for (var fila = 1; fila <= this.altoZonaJuego; fila++) {
                    this.dibujarCelda( this.tablero[columna][fila], LADO_CUADRADO * columna, LADO_CUADRADO * (this.altoZonaJuego - fila ));
                }
            }
        },
        dibujarCelda: function(color, x, y) {
            $("canvas").drawRect({
                strokeStyle: "#c33",
                strokeWidth: 1,
                fillStyle: color,
                x: x, y: y,
                width: LADO_CUADRADO,
                height: LADO_CUADRADO,
                fromCenter: false
            });
        },
        limpiar: function() {
            for(var columna = 1; columna <= this.anchoZonaJuego; columna++) {
                for (var fila = 1; fila <= this.altoZonaJuego; fila++) {
                    this.dibujarCelda( this.colorFondo, LADO_CUADRADO * columna, LADO_CUADRADO * (this.altoZonaJuego - fila ));
                }
            }
        }
    };

    function PiezaTetris(ancho, alto, canvas, color) {
        this.canvas = canvas; 
        this.ancho = ancho;             
        this.alto = alto;
        this.pieza;
        this.x = 0;
        this.y = 0;
        this.color = color;
    };

    PiezaTetris.prototype = {
        inicializar: function(pieza) {
            this.pieza = new Array(this.alto);
            for(var columna = 0; columna < this.alto; columna++) {
                this.pieza[columna] = new Array(this.ancho)

                for(var fila = 0; fila < this.ancho; fila++) {
                    this.pieza[columna][fila] = (pieza[this.ancho * columna + fila] == estado.OCUPADO ? this.color : "rgba(0, 0, 0, 0.2)");
                }
            }
       },
       dibujar: function() {
            for(var columna = 0; columna < this.ancho; columna++) {
                for(var fila = 0; fila < this.alto; fila++) {
                    this.dibujarCelda( this.pieza[columna][fila], (this.x + fila) * LADO_CUADRADO, (this.y + columna) * LADO_CUADRADO);
                }
            }
       },
       dibujarCelda: function(color, x, y) {
            $("canvas").drawRect({
                fillStyle: color,
                x: x, y: y,
                width: LADO_CUADRADO,
                height: LADO_CUADRADO,
                fromCenter: false
            });
       }
    };

    function PiezaO(canvas) {
        this.piezaTetris = new PiezaTetris(2, 2, canvas, "#400");
        this.piezaTetris.inicializar(new Array(this.color,
                estado.OCUPADO, 
                estado.OCUPADO,
                estado.OCUPADO));
    }

    function PiezaL(canvas) {
        this.piezaTetris = new PiezaTetris(3, 3, canvas, "#506");
        this.piezaTetris.inicializar(new Array(
                estado.LIBRE, estado.LIBRE, estado.LIBRE,
                estado.OCUPADO, estado.LIBRE, estado.LIBRE,
                estado.OCUPADO, estado.OCUPADO, estado.OCUPADO));
    }

    // function PiezaJ() {
    //     this.piezaTetris = new PiezaTetris(ANCHO_PIEZA_CUADRADO, ALTO_PIEZA_CUADRADO);
    //     this.piezaTetris.inicializar(new Array(estado.OCUPADO, estado.OCUPADO, estado.OCUPADO, estado.OCUPADO));
    // }

    // function PiezaI() {
    //     this.piezaTetris = new PiezaTetris(ANCHO_PIEZA_CUADRADO, ALTO_PIEZA_CUADRADO);
    //     this.piezaTetris.inicializar(new Array(estado.OCUPADO, estado.OCUPADO, estado.OCUPADO, estado.OCUPADO));
    // }

    // function PiezaT() {
    //     this.piezaTetris = new PiezaTetris(ANCHO_PIEZA_CUADRADO, ALTO_PIEZA_CUADRADO);
    //     this.piezaTetris.inicializar(new Array(estado.OCUPADO, estado.OCUPADO, estado.OCUPADO, estado.OCUPADO));
    // }

    // function PiezaS() {
    //     this.piezaTetris = new PiezaTetris(ANCHO_PIEZA_CUADRADO, ALTO_PIEZA_CUADRADO);
    //     this.piezaTetris.inicializar(new Array(estado.OCUPADO, estado.OCUPADO, estado.OCUPADO, estado.OCUPADO));
    // }

    // function PiezaZ() {
    //     this.piezaTetris = new PiezaTetris(ANCHO_PIEZA_CUADRADO, ALTO_PIEZA_CUADRADO);
    //     this.piezaTetris.inicializar(new Array(estado.OCUPADO, estado.OCUPADO, estado.OCUPADO, estado.OCUPADO));
    // }    


    //el canvas
    var $canvas = $("#canvasJuego");
    var ctx = $canvas[0].getContext("2d");

    // Canvas supported?
    if (ctx) {
        // para que ocupe toda la pantalla
        $canvas[0].width  = $(window).width();
        $canvas[0].height = $(window).height();

       window.addEventListener( "keydown", doKeyDown, true);
          
    } else {
        alert("Canvas not supported!");
    }

    function doKeyDown(event) {

    switch (event.keyCode) {
        case 38:  /* Up arrow was pressed */
            // if (y - dy > 0){
            //     y -= dy;
            // }
            break;
        case 40:  /* Down arrow was pressed */
            // if (y + dy < HEIGHT){
            //     y += dy;
            // }
            break;
        case 37:  /* Left arrow was pressed */
            if (piezaActual.x > 0){
                piezaActual.x--;
            }
            break;
        case 39:  /* Right arrow was pressed */
            if (piezaActual.x + piezaActual.ancho < tablero.ancho){
                piezaActual.x++;
            }
            break;
        }

        tablero.limpiar();
        piezaActual.dibujar();
    }

    var tablero;
    var piezaActual;

    tablero = new TableroTetris(ANCHO_TABLERO, ALTO_TABLERO, $canvas);
    tablero.inicializar();
    tablero.toString();
    tablero.dibujarBorde();

    piezaActual = new PiezaL($canvas).piezaTetris;
    piezaActual.x = (ANCHO_TABLERO/2 - 1);

    yu =0;

      function animate() {
    
        var yu = 0;
        // update
        

   //    while (true) {

            setInterval(bajar, 1000) //wait ten seconds before continuing

       // }
        // clear
        //context.clearRect(0, 0, canvas.width, canvas.height);

        // draw stuff

        // request new frame
        // requestAnimFrame(function() {
        //   animate();
        // });
      }

      function bajar() {
            piezaActual.y = yu;
            tablero.limpiar();
            piezaActual.dibujar();
            yu++;
      }
      animate();





//Piezas 
/*
L = #              ##       #
    #       ###     #       ###
    ##      #       #       

Pa= #
    #
    #
    #
*/  
});
