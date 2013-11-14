/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package obousmernylinearniseznam;

import LinearniSeznam.LinearniSeznam;

/**
 *
 * @author Johnny
 */
public class ObousmernyLinearniSeznam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinearniSeznam sez = new LinearniSeznam();
        sez.addNodeFirst("B");
        sez.addNodeFirst("A");
        System.out.println(sez.getFirst());
    }
}
