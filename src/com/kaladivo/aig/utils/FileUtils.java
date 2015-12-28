package com.kaladivo.aig.utils;

import com.kaladivo.aig.images.Density;

import javax.activation.MimetypesFileTypeMap;
import java.io.File;

/**
 * Contains handy methods for working with Files.
 *
 * Created by kaladivo on 27.12.15.
 */
public class FileUtils {

    public static File getFileForResource(String imageName, String resourceType, Density d, File outputDir) {
        File folder = new File(outputDir, String.format("%s-%s", resourceType, d.toString().toLowerCase()));
        folder.mkdir();

        File resFile = new File(folder, String.format("%s", imageName));
        return resFile;
    }

    public static boolean isImage(File image) {
        MimetypesFileTypeMap mimetypesFileTypeMap = new MimetypesFileTypeMap();
        mimetypesFileTypeMap.addMimeTypes("image png tif jpg jpeg bmp");

        String mimeType = mimetypesFileTypeMap.getContentType(image);
        String type = mimeType.split("/")[0];
        return type.equals("image");
    }
}
