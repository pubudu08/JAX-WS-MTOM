package com.pubudu.ws;

import javax.imageio.ImageIO;
import javax.jws.WebService;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.MTOM;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: pubudu
 * Date: 12/4/13
 * Time: 11:10 AM
 * To change this template use File | Settings | File Templates.
 */
@MTOM
@WebService(endpointInterface = "com.pubudu.ws.ImageServer")
public class ImageServerImpl implements ImageServer {
    @Override
    public Image downloadImage(String name) {

      /* file:///home/pubudu/Development/*/

        try {
            File image = new File(File.separator+"home"+File.separator+"pubudu"+File.separator+"Development"+File.separator+"Workspace"+File.separator+"JAX_WS"+File.separator+"JAX-WS_MTOM"+File.separator + name);
            return ImageIO.read(image);

        } catch (IOException e) {
            e.printStackTrace();
            return null;

        }
    }

    @Override
    public String uploadImage(Image data) {
        if (data != null) {
            return "Upload Successful";

        }
        throw new WebServiceException("Upload Failed!");
    }
}
