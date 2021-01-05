package com.jachs.springbootbatch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

/**
 * @author zhanchaohan
 * 
 */
public class ChangePackageName {
    private static final String Fpath="F:\\test\\spring-boot-batch\\src\\main\\java\\org";
    private static final String Tpath="F:\\test\\spring-boot-batch\\src\\main\\java\\com\\jachs\\springbootbatch";
    
    @Test
    public void Tesbc() throws Exception {
//        FileUtils.copyDirectory ( new File ( Fpath ), new File (Tpath) );
        File fFile=new File ( Tpath );
        File[] fList= fFile.listFiles ();
        for ( File file : fList ) {
            if(file.isDirectory ()) {
                new File ( Tpath+File.separator+file.getName () );
            }
        }
    }
}
