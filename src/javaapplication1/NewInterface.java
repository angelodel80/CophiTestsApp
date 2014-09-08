/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import eu.cophi.model.api.Document.IDoc;

/**
 *
 * @author angelodel80
 */
public interface NewInterface {
    /**
     * 
     */
    public void test(String inName); // test wrapper In
    public void test2(String outName); // test wrapper Out
    public void test3(); // test con la classe Doc
    public void test4(); // test con la classe Doc e tokens in log
    public void test5(); // test con la classe DOC e pericopes
    public void test6(); // test con la classe DOC e tokens in pericopes
    public void test7(); // test con la classe DOC e le annidate TEXT, PARATEXT, EXTRATEXT, METADATA FACS
    public void test8(); // test con la classe Variant ispirata dalla classe Difference del modulo netbeans diff
    public void test9() throws ClassNotFoundException; // test con la classe VariantProvider presa dalla implementazione buildin di netbeans
    public void test10(); //test con variant separando api e spi con un provider built in
    public void test11(); // test con variant per visualizzare le linee di differenza
}
