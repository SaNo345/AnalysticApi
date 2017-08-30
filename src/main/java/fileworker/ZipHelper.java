package fileworker;

import org.zeroturnaround.zip.ZipUtil;

import java.io.File;

/**
 * Created by Sano on 29.08.2017.
 */
public class ZipHelper {
    private static final String zipName = "data.zip";
      public static void zipFiles(String folderPath) {
          File zip = new File(zipName);
          if(zip.exists()){
              zip.delete();
          }
          ZipUtil.pack(new File(folderPath), new File(zipName));
      }



}
