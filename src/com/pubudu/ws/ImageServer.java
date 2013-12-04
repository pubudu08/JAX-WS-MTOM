package com.pubudu.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: pubudu
 * Date: 12/4/13
 * Time: 11:07 AM
 * To change this template use File | Settings | File Templates.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ImageServer {

    @WebMethod
    Image downloadImage(String name);

    @WebMethod
    String uploadImage(Image data);

}
