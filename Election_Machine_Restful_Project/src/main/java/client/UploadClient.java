package client;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;

/**
 * Servlet implementation class UploadClient
 */
@WebServlet("/uploadclient")
@MultipartConfig //Req. for request.getParts() method - Servlet 3.0 and above
public class UploadClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
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
			
			System.out.println("request.getParts(): " + request.getParts());
			
			// Get the image upload dd
		    Part inputFile = request.getPart("file");
		    String fileName = inputFile.getSubmittedFileName();
		    System.out.println("inputFile" + inputFile);
		    System.out.println("fileName" + fileName);
		    
		    File file = new File(fileName);
		    
		    System.out.println("file.getAbsolutePath(): " + file.getAbsolutePath());
		    System.out.println("file.getAbsolutePath(): " + 		    file.getPath());

		    System.out.println("file: " + file);
		    
		    
		    // Create input stream
//		    InputStream filecontent = inputFile.getInputStream();
//		    System.out.println("filecontent: " + filecontent);
		    
		    // Convert to File
		    
		    
//			
//			InputStream fileInputStream = request.getInputStream();
//			System.out.println("fileInputStream: " + fileInputStream);		
//			fileInputStream.toString();
//			System.out.println("fileInputStream.toString(): " + fileInputStream.toString());
			

//			FileDataBodyPart filePart = new FileDataBodyPart("file", new File(fileMetaData.getFileName()));
			FileDataBodyPart filePart = new FileDataBodyPart("file", new File("D:/123.jpg"));
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
		     
		    //Use response object to verify upload success
		    if (Response.Status.OK.toString().equals(resp.getStatusInfo().toString())) {
		    	System.out.println("Upload OK!");
		    	System.out.println(resp.readEntity(String.class));
		    }
		    else {
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
