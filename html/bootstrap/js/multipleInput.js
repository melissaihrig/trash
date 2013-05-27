$(document).ready(function() 
{
	$(".input-file").change(function() {

		borrarNombresDeArchivo( this );

		for(var i=0; i< $(this).get(0).files.length; i++)
		{				
			var nombre = $(this).get(0).files.item(i).name;
			$(this).parent().find(".input-file-ul").append( "<li>" + nombre + "</li>" );
		}
	  
	});

	var  borrarNombresDeArchivo = function( idBoton ) {
		$(idBoton).parent().find(".input-file-ul").children().remove();
	};
});
