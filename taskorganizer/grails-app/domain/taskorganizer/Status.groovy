package taskorganizer

class Status {

    String  description
    String 	name

    static  constraints = {
        name blank:false, unique:true
    }
    
    @Override
    public String toString() {
        return "${name}";
    }
}
