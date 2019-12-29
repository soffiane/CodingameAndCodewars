/**
 * C'est un code issu d'un test technique sur skillvalue pour alteca
 * test sur les fonctionnalités de Java 8 : ici les references de methodes sur les constructeurs
 */
package codingame;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class User {
    private String firstName;
    private String lastName;
    private Optional<String> name;

    public User(String firstName) {
        this.firstName = firstName;
    }

    public Optional<String> getName(){
        return name;
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String firstName, String lastName, String name) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.name = Optional.ofNullable(name);
    }
}

class Pouet{
    public static void main(String... args){
        //Supplier<User> s = User::new; --> il n'y a pas le constructeur par defaut ici
        Function<String,User> f = User::new; // function prend un String en entree et renvoie un User = le constructeur a 1 parametre
        BiFunction<String,String,User> bf = User::new; //BiFunction prend deux String en entree et renvoie un User = le constructeur a 2 parametres
        User pouet = new User("Conner","John","Test");
        System.out.println(pouet.getName());
    }
}
