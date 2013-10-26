package security

class ShiroUser {
	
    String username
    String passwordHash
	
	String firstname
	String lastname
	
    
    static hasMany = [ roles: ShiroRole, permissions: String ]

    static constraints = {
        username(nullable: false, blank: false, unique: true)
    }
}
