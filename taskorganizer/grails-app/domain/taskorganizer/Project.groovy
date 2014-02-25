package taskorganizer

class Project {
  
    Date    dateCreated
    Cycle   cycle
    String  name
    String  description
    byte[]  image
    
//  static  belongsTo   = []    // tells GORM to cascade commands: e.g., delete this object if the "parent" is deleted.
//  static  hasOne      = []    // tells GORM to associate another domain object as an owner in a 1-1 mapping
    static  hasMany     = [tasks: Task]  // tells GORM to associate other domain objects for a 1-n or n-m mapping

    static  constraints = {
        cycle nullable:false
        name blank:false, unique:true
        image maxSize: 1024 * 1024  // Limit upload file size to 1MB

    }
    

    @Override   // Override toString for a nicer / more descriptive UI 
    public String toString() {
      return "${name}"
    }

    public boolean hasImage() {
        return  image.length > 0
    }

    public int totalPoint() {
        int total = 0

        tasks.each { 
            total += it.weight
        }

        return total
    }

    public int currentPoint() {
        int total = 0

        tasks.each {
            if (it.status.id == cycle.status.last().id)
                total += it.weight
        }

        return total
    }

    public int percentageProgress() {

        if (currentPoint() == 0 ) {
            return 0
        }
        else {
            return currentPoint()/totalPoint()*100
        }

    }
}
