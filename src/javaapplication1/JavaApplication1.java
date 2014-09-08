/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import eu.cophi.api.variants.Diff;
import eu.cophi.api.variants.Variant;
import eu.cophi.commons.In;
import eu.cophi.commons.Out;
import eu.cophi.model.api.Document;
import eu.cophi.model.api.Document.Extratext;
import eu.cophi.model.api.Document.Facsimile;
import eu.cophi.model.api.Document.Text;
import eu.cophi.modules.variants.builtin.Provider;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author angelodel80
 */
public class JavaApplication1 implements NewInterface {

    String content = null;

    final static int N = 10;
    final static int M = 10;
    
    public void test0(){
        int[][] matrix = new int[N][M];
        for(int i=0; i<N; i++)
            for(int j=0; j<M; j++)
                matrix[i][j] = i;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++)
                System.out.print(
                        matrix[i][j]);
            System.out.println("\n");
        
        }
    }
    
    /**
     * the override function
     */
    @Override
    public void test(String name) {
        //throw new UnsupportedOperationException("Not supported yet.");
        Logger.getLogger(JavaApplication1.class.getName())
                .log(Level.INFO, "JavaApplication test function");
        In in = new In(name);
        content = in.readAll();
        //in.isEmpty();
        in.close();
    }

    public String getContent() {
        return this.content;
    }

    @Override
    public void test2(String outName) {
        //throw new UnsupportedOperationException("Not supported yet.");
        Logger.getLogger(JavaApplication1.class.getName())
                .log(Level.INFO, "JavaApplication test2 function");
        Out out = new Out(outName);
        out.print(this.content);
        out.close();


    }

    @Override
    public void test3() {
        //throw new UnsupportedOperationException("Not supported yet.");
        Document doc = Document.getDefaultDoc();
        String name = doc.getIdentifier();
        Logger.getLogger(JavaApplication1.class.getName())
                .log(Level.INFO, name);

    }

    @Override
    public void test4() {
        //throw new UnsupportedOperationException("Not supported yet.");
        Document doc = Document.getDefaultDoc();
        String[] tokens = doc.getTokens();
        for (String token : tokens) {
            Logger.getLogger(JavaApplication1.class.getName())
                    .log(Level.INFO, token);
        }
    }

    @Override
    public void test5() {
        //throw new UnsupportedOperationException("Not supported yet.");
        Document doc = Document.getDefaultDoc();
        Integer[] pericopes = doc.getPericopes();
        for (Integer pericope : pericopes) {
            if (pericope == null) {
                continue;
            }
            Logger.getLogger(JavaApplication1.class.getName())
                    .log(Level.INFO, String.valueOf(pericope.intValue()));
        }
    }

    @Override
    public void test6() {
        //throw new UnsupportedOperationException("Not supported yet.");

        Document doc = Document.getDefaultDoc();
        String[] tokens = doc.getTokens();
        Integer[] pericopes = doc.getPericopes();

        process(tokens, pericopes);

    }

    private void process(String[] tokens, Integer[] pericopes) {
        int i = -1;
        int prec = 0;
        StringBuffer tokPer = new StringBuffer();
        for (Integer pericope : pericopes) {
            i++;
            if (pericope == null) {
                continue;
            }

            int curr = pericope.intValue();

            for (int j = prec; j <= curr; j++) {
                tokPer.append(tokens[j]).append("__");
            }
            prec = curr + 1;

            Logger.getLogger(JavaApplication1.class.getName())
                    .log(Level.INFO, tokPer.toString());

        }
    }

    /**
     *
     */
    @Override
    public void test7() {
        //throw new UnsupportedOperationException("Not supported yet.");
        Document doc = Document.getDefaultDoc();
        
        Text txt = doc.DEF_TEXT;
        Extratext etxt = doc.DEF_EXTRATEXT;
        Facsimile facs = doc.DEF_FACSIMILE;
        
        Logger.getLogger(JavaApplication1.class.getName())
                .log(Level.INFO, txt.getContent());
        
        Logger.getLogger(JavaApplication1.class.getName())
                .log(Level.INFO, etxt.getContent());
        
        Logger.getLogger(JavaApplication1.class.getName())
                .log(Level.INFO, facs.getContent());
        
    }
    
    @Override
    public void test8() {
        //throw new UnsupportedOperationException("Not supported yet.");
        Variant.Part lineDiff1 = new Variant.Part(Variant.CHANGE, 2, 1, 1);
        Variant.Part lineDiff2 = new Variant.Part(Variant.CHANGE, 2, 1, 1);
       // Variant.Part[] arrLineDiff1 = new Variant.Part[]{lineDiff1};
       //  Variant.Part[] arrLineDiff2 = new Variant.Part[]{lineDiff2};
        Variant variant = new Variant(Variant.CHANGE, 2, 2, 2, 2, "casa", "cosa", new Variant.Part[]{lineDiff1},new Variant.Part[]{lineDiff2});
         Logger.getLogger(JavaApplication1.class.getName())
                .log(Level.INFO, variant.toString());
         Logger.getLogger(JavaApplication1.class.getName())
                .log(Level.INFO, variant.getFirstText().concat(" : ").concat(variant.getSecondText()));
        int offset = variant.getFirstLineDiffs()[0].getEndPosition()+1-(variant.getFirstLineDiffs()[0].getStartPosition());
         Logger.getLogger(JavaApplication1.class.getName())
                .log(Level.INFO, 
                String.valueOf("offset base file: ")
                 .concat(
                    String.valueOf(offset)).concat(variant.getFirstText().substring(1, offset+1)));
        
    }

    
    
    @Override
    public void test9() throws ClassNotFoundException{
        //throw new UnsupportedOperationException("Not supported yet.");
        Provider provider = Provider.INSTANCE;
        Reader r1 = null;
        Reader r2 = null;
        if(provider instanceof Provider)
            Class.forName("eu.cophi.api.variants.Provider").cast(provider);
        try{
        r1 = new FileReader("src.txt");
        r2 = new FileReader("srcv.txt");
        }catch(FileNotFoundException fe){
            Logger.getLogger(JavaApplication1.class.getName())
                    .log(Level.SEVERE,fe.getMessage());
        }
        try {
            processReader(r1,r2);
        } catch (IOException ex) {
            Logger.getLogger(JavaApplication1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void processReader (Reader r1, Reader r2) throws IOException{
       int i = 0;
        while((i=r1.read())!=-1){
            char c = (char)i;
            System.out.println(c);       
        }
        i = 0;
        while((i=r2.read())!=-1){
            char c = (char)i;
            System.out.println(c);       
        } 
    }

     @Override
    public void test10() {
        //throw new UnsupportedOperationException("Not supported yet.");
         Diff.DiffInfo variants = null;
        try {
            variants = Diff.getDefault().createDiff(
                    "src", 
                    "srcTest", 
                    new FileReader("src.txt"), 
                    "src1", 
                    "src1Test", 
                    new FileReader("src1.txt"),
                    "text/plain");
            process(variants.getInitialDifferences());
        } catch (IOException ex) {
            Logger.getLogger(JavaApplication1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     private void process(Variant[] variants){
         if(variants.length>0)
            Logger.getLogger(JavaApplication1.class.getName()).log(Level.INFO, variants[0].toString());
         else
            Logger.getLogger(JavaApplication1.class.getName()).log(Level.INFO, "no difference in the file");

     }
     
      @Override
    public void test11() {
        //throw new UnsupportedOperationException("Not supported yet.");
         Diff.DiffInfo variants = null;
        try {
            variants = Diff.getDefault().createDiff(
                    "src", 
                    "srcTest", 
                    new FileReader("src.txt"), 
                    "srcv", 
                    "srcvTest", 
                    new FileReader("srcv.txt"),
                    "text/plain");
            processLines(variants.getInitialDifferences());
        } catch (IOException ex) {
            Logger.getLogger(JavaApplication1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     private void processLines(Variant[] variants){
         for(int i = 0; i<variants.length; i++){
            
             int t = variants[i].getType();
             
            int s1 = variants[i].getFirstStart();
            int e1 = variants[i].getFirstEnd();
            String txt1 = variants[i].getFirstText();
            
            int s2 = variants[i].getSecondStart();
            int e2 = variants[i].getSecondEnd();
            String txt2 = variants[i].getSecondText();
             String output = String.format("differenza n. %d - tipo [%d] \n"
                                     + "Primo File Inizio Riga: %d\t"
                                     + "Primo File Fine Riga: %d\t"
                                     + "Secondo File Inizio Riga: %d\t"
                                     + "Secondo File Fine Riga: %d\n\n"
                                     + "Testo Primo della variante: %s\n"
                                     + "Testo Secondo della variante: %s\n"
                                     , i+1,t,s1,e1,s2,e2,txt1,txt2);
            Logger.getLogger(JavaApplication1.class.getName()).log(Level.INFO, output); 
            
         }
     } 
   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JavaApplication1 app = new JavaApplication1();
        Logger.getLogger(JavaApplication1.class.getName())
                .log(Level.INFO, "JavaApplication main function");
//        try {
            //app.test(args[0]);
            //app.test2("out.txt");
            //app.test3();
            //app.test4();
            //app.test5();
            //app.test6();
            //app.test7();
            //app.test8();
//            app.test9();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(JavaApplication1.class.getName()).log(Level.SEVERE, null, ex);
//        }

//        String classTest = "classTest";
//        Class<?> C = classTest.getClass();
//        Class<?> Cs = String.class;
//        
//        System.out.println(C);
//        System.out.println(Cs);
//        
//        System.out.println(C.getName());
//        System.out.println(Cs.getName());
        
        //app.test10();
        //app.test11();
        app.test5();
        
    }

    
}
