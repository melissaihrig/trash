$(document).ready(function() 
{
	$(".contact-check").click(function()
	{
		var id = "#" + this.id;
		var idMensaje = "#mensaje" + this.id.split('-')[2];
 
	    if ($(id).prop("checked") == true)
	    {
		$(id).attr("value", true);
/*	        $(text).prop("disabled", false);
	        $(date).prop("disabled", false);
	        $(btnAdd).removeAttr("disabled");
	        $(btnDel).removeAttr("disabled");
*/	    }
	    else
	    {
		$(id).attr("value", false);
/*	        $(text).prop("disabled", true);
	        $(date).prop("disabled", true);
	        $(btnAdd).attr("disabled", "disabled");
	        $(btnDel).attr("disabled", "disabled");
*/
	    }
	
		$(idMensaje).text($(id).attr("value"));
	
	});
});
