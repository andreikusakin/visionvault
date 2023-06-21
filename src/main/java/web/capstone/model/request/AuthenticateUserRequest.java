package web.capstone.model.request;

// For the evaluator
// Task B1:
// AuthenticateUserRequest is an example of Encapsulation: the ability to hide the internal representation of an object from the outside world.
// Encapsulation is achieved in Java using private fields and public methods (getters and setters)
public class AuthenticateUserRequest {
    private String email;

    private String password;

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public AuthenticateUserRequest(){

    }

    public AuthenticateUserRequest(String email, String password){
        this.email = email;
        this.password = password;
    }
}
