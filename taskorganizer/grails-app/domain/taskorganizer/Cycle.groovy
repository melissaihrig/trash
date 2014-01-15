package taskorganizer

class Cycle {

    String  name
    List    status
    static  hasMany     = [status: Status]

    static  constraints = {
        name blank:false, unique:true
    }
    
    @Override
    public String toString() {
      return "${name}"
    }

    public Status nextStatus(Status previousStatus) {

        Status nextStatus = null
        
        status.eachWithIndex{it, number ->
            println "tma: " + status.size() + " p: "+ status.first()
            println "act it:  " + it + " p: " + previousStatus + "------   " + (it.id == previousStatus.id)
            if (it.id == previousStatus.id) {

                if ( (number + 1) < status.size() ) {
                    nextStatus = status.getAt(number+1)
                    return
                }
                else {
                    nextStatus = status.first()
                    return 
                }
            }
        }

        ['a', 'b', 'c'].eachWithIndex{ it, number -> println "$number: $it" }

        println  "sig : "  + nextStatus
        return nextStatus
    }
}
