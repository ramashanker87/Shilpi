class InvalidException extends Exception{
    public InvalidException(String message){
        super(message);
    }
}

public class shilpi_age_exception {

    public static void checkAge(int age) throws InvalidException{
        if(age<25){
            throw new InvalidException("Age should be more than 25 to apply.");
        }else{
            System.out.println("Age is okay. You can apply.");
        }
    }

    public static void main(String[] args){
        int[] ages={17,16,28,30,19};
        for(int age:ages){
            try{
                System.out.println("Age check: "+age);
                checkAge(age);
            }catch (InvalidException i){
                System.out.println("ERROR: "+i.getMessage());
            }
        }
    }
}