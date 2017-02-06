/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unlpp;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
 

/**
 *
 * @author user
 */
public class UNLPP {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        // TODO code application logic here
        ArrayList<String> lista = new ArrayList<String>();
        //201 507 2017
        //6536 6650 2016
        ArrayList<Dane> parametry = new ArrayList<Dane>();
        parametry.add(new Dane(513,577,2017));
     //   parametry.add(new Dane(6536,6650,2016));
        
        try {
            
            for(int _i=0; _i<parametry.size();_i++){        
                String str_ = "C:\\Users\\user\\Documents\\Laboratorium\\2";

                for(int i=parametry.get(_i)._od;i<=parametry.get(_i)._do;i++)
                {
                    String str1 = str_+"\\FS "+i+"_P_"+parametry.get(_i)._rok+".xml.sent";    
                    String str2 = str_+"_zrobione\\FS "+i+"_P_"+parametry.get(_i)._rok+".xml.sent";  
                    File txt = new File(str1);

                    if(!txt.isFile()){continue;}

                    String dane = "";
                    //  BufferedReader odczytaj = new BufferedReader(new FileReader(txt));
                    FileReader fileReader = new FileReader(txt);
                 //   FileWriter out = new FileWriter(txt);
                    BufferedReader odczytaj = new BufferedReader(fileReader);
                  //  BufferedWriter zapisuj = new BufferedWriter(out);
                    while ((dane = odczytaj.readLine()) != null) {

                        int a = 0,b = 0;

                        if(dane.indexOf("<BuyerOrderNumber>")!=-1)
                        {                   
                            a = dane.indexOf(">")+1;
                            if(dane.indexOf("brak")==-1)
                            {
                                if(dane.indexOf("_")!=-1)
                                {
                                   b = dane.indexOf("_")+1;      

                                   String str = dane.substring(0,a) + dane.substring(b);                           
                                   dane = str;
                                }           
                            }
                        }
                        lista.add(dane);

                     //   System.out.println(dane);
                        // tutaj dane które odczytasz zapisujesz gdzie chcesz
                    }
                    odczytaj.close();

                    FileWriter fileWriter = new FileWriter(str2);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                    try {
                      for (String line : lista) {
                        bufferedWriter.write(line);
                        bufferedWriter.newLine();
                      }
                    } finally {
                        bufferedWriter.close();
                        lista = new ArrayList<String>();
                    }
                }            
            }
        //    zapisuj.close();
        }
        catch (IOException e)
        {
        
        }
    }
    
}
