package com.pubudu.client;

import com.pubudu.ws.ImageServer;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;
import java.awt.*;
import java.io.File;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: pubudu
 * Date: 12/4/13
 * Time: 11:22 AM
 * To change this template use File | Settings | File Templates.
 */
public class ImageClient{

    public static void main(String[] args) throws Exception {

        URL url = new URL("http://localhost:9999/ws/image?wsdl");
        QName qname = new QName("http://ws.pubudu.com/", "ImageServerImplService");

        Service service = Service.create(url, qname);
        ImageServer imageServer = service.getPort(ImageServer.class);

        /************  test upload ****************/
        Image imgUpload = ImageIO.read(new File(File.separator+"home"+File.separator+"pubudu"+File.separator+"Development"+File.separator+"Workspace"+File.separator+"JAX_WS"+File.separator+"JAX-WS_MTOM"+File.separator+"rss.png"));


        //enable MTOM in client
        BindingProvider bp = (BindingProvider) imageServer;
        SOAPBinding binding = (SOAPBinding) bp.getBinding();
        binding.setMTOMEnabled(true);

        String status = imageServer.uploadImage(imgUpload);
        System.out.println("imageServer.uploadImage() : " + status);


        /************  test download  ***************/
        Image image = imageServer.downloadImage("rss.png");

        //display it in frame
        JFrame frame = new JFrame();
        frame.setSize(300, 300);
        JLabel label = new JLabel(new ImageIcon(image));
        frame.add(label);
        frame.setVisible(true);

        System.out.println("imageServer.downloadImage() : Download Successful!");

    }

}