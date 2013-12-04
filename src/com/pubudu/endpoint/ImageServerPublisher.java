package com.pubudu.endpoint;

import com.pubudu.ws.ImageServerImpl;

import javax.xml.ws.Endpoint;

/**
 * Created with IntelliJ IDEA.
 * User: pubudu
 * Date: 12/4/13
 * Time: 11:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class ImageServerPublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9999/ws/image",new ImageServerImpl());
        System.out.println("Server Published");

    }
}
