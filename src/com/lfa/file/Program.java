package com.lfa.file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the link of your image, mp3 or mp4 song and videos:");
        System.out.print("-> ");
        String link=input.nextLine();
        System.out.println();
        System.out.println("Enter the location of the drive where you want to store your file:");
        System.out.print("-> ");
        String location=input.nextLine();
        System.out.println();
        try{
            URL url=new URL(link);
            URLConnection conn=url.openConnection();
            String agent="Mozilla/5.0 (Windows NT 10.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36";
            conn.setRequestProperty("User-Agent", agent);
            InputStream is=conn.getInputStream();
            OutputStream os=new FileOutputStream(location);
            int i=0;
            byte[] data=new byte[1024];
            while((i=is.read(data))!=-1){
                os.write(data, 0, i);
            }
            is.close();
            os.close();
        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }
    
}
