/**
 * Code issu d'un test technique en ligne
 * pour tester les fonctionnalites des interfaces avec Java8
 * methode default
 */

package codingame;

public class Interfaces {

    public interface I1{
        default void log(){
            System.out.println("hello from I1");
        }
    }

    public interface I2 extends I1 {
        void log();
    }

    public class C1 implements I1,I2 {

        @Override
        public void log() {

        }
    }
}
