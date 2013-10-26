import security.ShiroUser
import org.apache.shiro.crypto.hash.Sha256Hash

class BootStrap {

    def init = { servletContext ->
		
		def user = new ShiroUser(username: "user", 
								passwordHash: new Sha256Hash("pass").toHex(),
								firstname: "Usuario",
								lastname: "Apellido" )
		user.addToPermissions("*:*")
		user.save()
		
    }
    def destroy = {
    }
}
