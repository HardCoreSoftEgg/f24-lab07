package AndrewWebServices;

/*
 * InMemoryDatabase is a fake for the AndrewWS database which is used to improve test efficiency.
 * Remember, fakes are fully functional classes with simplified implementation.
 * What is the simplest core functionality that we need for a functional database?
 * 
 * Hint: there are two methods you need to implement
 */
public class InMemoryDatabase /* should there be something here? */ {
    // Implement your fake database here
    private String accountName;
    private  int password;

    public InMemoryDatabase() {
        this.accountName = "Scotty";
        this.password = 17214;

    }

    public boolean logIn(String accountName, int password) {
        if (accountName.equals(this.accountName) && this.password == password) {
            return true;
        }
        System.out.println("Login failed.");
        return false;
    }
    public String getRecommendation(String accountName) {
        if (accountName.equals(this.accountName)) {
            return "Animal House";
        }
        else{
            return "No recommendation";
        }
    }
}

