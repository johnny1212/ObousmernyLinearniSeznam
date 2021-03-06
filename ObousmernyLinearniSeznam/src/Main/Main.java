package Main;

import LinearniSeznam.LinearniSeznam;

/**
 *
 * @author Johnny
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("LINEÁRNÍ SEZNAM");
        LinearniSeznam<String> sez = new LinearniSeznam<String>();
        sez.addNodeFirst("C");
        sez.addNodeFirst("B");
        sez.addNodeFirst("A");
        sez.addNodeLast("D");

        System.out.println("----");
        System.out.println("první: " + sez.getFirst());
        System.out.println("Aktuální: " + sez.getActual());
        System.out.println("Následující: " + sez.getAfterActual());
        System.out.println("poslední: " + sez.getLast());
        System.out.println("----");
    }
}
