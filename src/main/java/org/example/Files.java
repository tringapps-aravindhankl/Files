package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Files {
        public static void main( String[] args ) throws FileNotFoundException
        {
            StringBuilder string=new StringBuilder();
            Map<String,Integer> map = new HashMap<>();
            Logger l=Logger.getLogger("hi");
            String urllink="C:\\Users\\Tringapps-User23\\Desktop\\java\\java.txt";
            File file=new File(urllink);
            Scanner scan=new Scanner(file);
            while(scan.hasNextLine())
            {
                string.append(scan.nextLine());
                string.append(" ");
            }
            String[] string1 = string.toString().split(" ");
            int t;
            for(int i=0;i<string1.length;i++) {
                t=1;
                for(int j=i+1;j<string1.length;j++) {
                    if(string1[i].equals(string1[j]) && !string1[i].equals("."))
                    {
                        t++;
                        string1[j]=".";
                    }
                }
                if(!string1[i].equals(".")) {
                    map.put(string1[i],t);
                }
            }
            PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
            queue.addAll(map.entrySet());
            while(!queue.isEmpty())
            {
                l.log(Level.INFO,()->" "+queue.poll());
            }
    }
}