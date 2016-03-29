/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication2;

import java.io.BufferedReader;  
import java.io.File;  
import java.io.FileNotFoundException;  
import java.io.FileReader;  
import java.io.IOException;  
  
public class StaticsCodeingLine {  
  
    private static int whiteLines = 0;  
    private static int commentLines = 0;  
    private static int normalLines = 0;  
      
      
    public static void main(String[] args) {  
        File f = new File("d:\\JavaApplication2\\src\\javaapplication2\\StaticsCodeingLine.java");   
        sumCode(f);  
    }  
      
    private static void sumCode(File file) {   
        BufferedReader br = null;   
        boolean comment = false;   
        try {   
            br = new BufferedReader(new FileReader(file));   
            String line = "";   
            try {   
                while ((line = br.readLine()) != null) {   
                    line = line.trim();   
                    if (line.matches("^[\\s&&[^\\n]]*$")) {   
                        whiteLines++;   
                    } else if (line.startsWith("/*") && !line.endsWith("*/")) {   
                        commentLines++;   
                        comment = true;   
                    } else if (true == comment) {   
                        commentLines++;   
                        if (line.endsWith("*/")) {   
                            comment = false;   
                        }   
                    } else if (line.startsWith("//")) {   
                            commentLines++;   
                    } else {   
                        normalLines++;   
                    }   
                }   
            } catch (IOException e) {   
                    e.printStackTrace();   
            }   
        } catch (FileNotFoundException e) {   
                e.printStackTrace();   
        } finally {   
            if (br != null) {   
                try {   
                    System.out.println("空行数："+whiteLines);  
                    System.out.println("注释行数："+commentLines);  
                    System.out.println("代码行数："+normalLines);  
                    br.close();   
                    br = null;   
                } catch (IOException e) {   
                    e.printStackTrace();   
                }   
            }   
        }   
    }  
}  