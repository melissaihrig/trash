package taskorganizer

class Project {

//  Long    id
//  Long    version
    
    Date    dateCreated
    Cycle   cycle
    String  name
    String  description
    byte[]  image
    
//  static  belongsTo   = []    // tells GORM to cascade commands: e.g., delete this object if the "parent" is deleted.
//  static  hasOne      = []    // tells GORM to associate another domain object as an owner in a 1-1 mapping
    static  hasMany     = [task: Task]  // tells GORM to associate other domain objects for a 1-n or n-m mapping

    static  constraints = {
        cycle nullable:false
        name blank:false, unique:true
        image size: 1..9999999
    }
    

    @Override   // Override toString for a nicer / more descriptive UI 
    public String toString() {
      return "${name}";
    }
}
