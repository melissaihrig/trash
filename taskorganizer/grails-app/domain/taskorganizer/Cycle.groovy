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

  public Status nextStatus() {
  	//Status nextStatus = 
	//return nextStatus  	
	return null
  }
}
