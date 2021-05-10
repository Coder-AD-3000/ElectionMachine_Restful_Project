package services;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("/uploadservice")
public class UploadService {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("emachinedb");
	
	@POST
	@Path("/uploadiamge")
	@Consumes({MediaType.MULTIPART_FORM_DATA})
	public void uploadImage( @FormDataParam("candidate_id") String candidate_id, @FormDataParam("file") InputStream fileInputStream,
            @FormDataParam("file") FormDataContentDisposition fileMetaData,
            @Context ServletContext sc) 
            		throws Exception
	{
		//Creating custom time and date format
		LocalDateTime myDateObj = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyymmddHHmmss");
	    String formattedDate = myDateObj.format(myFormatObj);
	    
	    //Reading img extension
        String fileName = fileMetaData.getFileName();
        String ext = fileName.substring(fileName.lastIndexOf('.'));
        System.out.println("extension: " + ext);
	    
        //Creating final img name with extension
	    String finalPicName = candidate_id + "profile" + formattedDate + ext;
	    System.out.println("finalPicName: " + finalPicName);
	    
	    //Amending DB
	    EntityManager em = emf.createEntityManager();
	    em.getTransaction().begin();
	    em.createNativeQuery("UPDATE candidate set pic=? where candidate_id=?").setParameter(1, finalPicName).setParameter(2, candidate_id).executeUpdate();
	    em.getTransaction().commit();
	    	    
	    //Creating upload path
		String UPLOAD_PATH = System.getProperty("user.home") + "/git/ElectionMachine_Restful_Project/Election_Machine_Restful_Project/src/main/webapp/img/";
	    
		//Trying to upload file
		try{
	        int read = 0;
	        byte[] bytes = new byte[1024];
	        
	        OutputStream out = new FileOutputStream(new File(UPLOAD_PATH + finalPicName));
	        while ((read = fileInputStream.read(bytes)) != -1) 
	        {
	            out.write(bytes, 0, read);
	        }
	        out.flush();
	        out.close();   
	    } 
	    catch (IOException e){
	        throw new WebApplicationException("Error while uploading file. Please try again !!");
	    }
//	    URI location = new URI("../jsp/profiletoupdateform.jsp");
//	    URI location = new URI("../jsp/index.jsp?msg=A_User_Added");
//	    return Response.temporaryRedirect(location).build();
//	    return Response.ok().link("/readmyprofile", "wdad").build();
//	    return Response.ok("Data uploaded successfully !!").build();
	}	
}
