package client;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;

/**
 * @author Daniel
 * Servlet implementation class UploadClient
 * This class can be used to upload images using a servlet
 * Currently it is not in use.
 *
 */
@WebServlet("/uploadclient")
@MultipartConfig //Req. for request.getParts() method - Servlet 3.0 and above
public class UploadClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * This class can be used to upload images using a servlet
     * Currently it is not in use.
     * @see HttpServlet#HttpServlet()
     */
    public UploadClient() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// get absolute path ddd
			System.out.println(System.getProperty("user.home"));
			 		    
			String uploadPath = System.getProperty("user.home") + "/git/ElectionMachine_Restful_Project/Election_Machine_Restful_Project/src/main/webapp/img/";
		    FileDataBodyPart filePart = new FileDataBodyPart("file", new File(uploadPath));
		    System.out.println("****filePart: " + filePart);

		    FormDataMultiPart formDataMultiPart = new FormDataMultiPart();
		    System.out.println("FormDataMultipart created");
		    
		    FormDataMultiPart multipart = (FormDataMultiPart) formDataMultiPart.bodyPart(filePart);
		    System.out.println("formDataMultiPart.bodyPart(filePart)"); 
		    
		    Client client = ClientBuilder.newBuilder().register(MultiPartFeature.class).build();
		    System.out.println("Client created");
		    WebTarget target = client.target("http://127.0.0.1:8080/rest/uploadservice/fileupload");
		    System.out.println("WebTarget executed");
		        
		    Response resp = target.request().post(Entity.entity(multipart, multipart.getMediaType()));
		    System.out.println("Response created: " + resp);
		     
//		    Use response object to verify upload success
		    if (Response.Status.OK.toString().equals(resp.getStatusInfo().toString())) {
		    	request.setAttribute("message", "Your image is being processesed... Refresh this page so you can see the changes made.");
//		    	Print to console
		    	System.out.println("Upload OK!");
		    	System.out.println(resp.readEntity(String.class));
		    	
		    }
		    else {
		    	request.setAttribute("message", "Something went wrong! Please try it later...");
//		    	Print to console
		    	System.out.println("Response is: " + resp);
		    	System.out.println("Upload NOT OK!");
		    }
		     
		    formDataMultiPart.close();
		    multipart.close();
		}
		catch(Exception e) {
			System.out.println("Something went wrong!!");
		}
	}

}
