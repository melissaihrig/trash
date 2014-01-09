package taskorganizer

class Task {

	Date		dateCreated	
	String 		detail
	String 		description
	Status		status
	Long		weight

	static	belongsTo	= [project: Project]	// tells GORM to cascade commands: e.g., delete this object if the "parent" is deleted.
//	static	hasOne		= []	// tells GORM to associate another domain object as an owner in a 1-1 mapping
//	static	hasMany		= []	// tells GORM to associate other domain objects for a 1-n or n-m mapping
//	static	mappedBy	= []	// specifies which property should be used in a mapping 
	  
	static	constraints = {
		description blank:false, unique:true
		status nullable:false
		weight min:0L
    }
	

	@Override
	public String toString() {
		return description;
	}
}
