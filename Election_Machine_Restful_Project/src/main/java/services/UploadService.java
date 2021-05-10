package services;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("/uploadservice")
public class UploadService {
	@POST
	@Path("/uploadiamge")
	@Consumes({MediaType.MULTIPART_FORM_DATA})
	public void uploadImage( @FormDataParam("file") InputStream fileInputStream,
            @FormDataParam("file") FormDataContentDisposition fileMetaData,
            @Context ServletContext sc) 
            		throws Exception
	{
		System.out.println("upload service started");
		System.out.println("fileMetaData: " + fileMetaData);
		System.out.println("fileMetaData: " + fileMetaData.getFileName());
		String UPLOAD_PATH = System.getProperty("user.home") + "/git/ElectionMachine_Restful_Project/Election_Machine_Restful_Project/src/main/webapp/img/";
//		String UPLOAD_PATH = System.getProperty("user.home") + "/git/ElectionMachine_Restful_Project/Election_Machine_Restful_Project/src/main/webapp/tmp/";
	    try{
	        int read = 0;
	        byte[] bytes = new byte[1024];
	        
	        System.out.println("Identifying extension: ");
	        String fileName = fileMetaData.getFileName();
	        String ext = fileName.substring(fileName.lastIndexOf('.'));
	        System.out.println("ext: " + ext);
	        OutputStream out = new FileOutputStream(new File(UPLOAD_PATH + "profile" + ext));
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
	
	@POST
	@Path("/saveprofileimg")
	@Consumes({MediaType.MULTIPART_FORM_DATA})
	public Response saveImage( @FormDataParam("file") InputStream fileInputStream,
            @FormDataParam("file") FormDataContentDisposition fileMetaData, 
            @FormDataParam("photo") String photographer,
            @FormDataParam("camera") String camera,
            @Context ServletContext sc) 
            		throws Exception
	{
		System.out.println("upload service started");
		System.out.println("fileMetaData: " + fileMetaData);
		System.out.println("fileMetaData: " + fileMetaData.getFileName());
		String UPLOAD_PATH = System.getProperty("user.home") + "/git/ElectionMachine_Restful_Project/Election_Machine_Restful_Project/src/main/webapp/img/";
	    try{
	        int read = 0;
	        byte[] bytes = new byte[1024];
	 
	        OutputStream out = new FileOutputStream(new File(UPLOAD_PATH + fileMetaData.getFileName()));
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
	    return Response.ok("Data uploaded successfully !!"+
	    					" Phographer: "+photographer+
	    					" Camera: "+camera).build();
	}
	
	
	/*
	@POST
	@Path("/fileupload")
	@Consumes({MediaType.MULTIPART_FORM_DATA})
	public Response uploadFile( @FormDataParam("file") InputStream fileInputStream,
            @FormDataParam("file") FormDataContentDisposition fileMetaData, 
            @FormDataParam("photo") String photographer,
            @FormDataParam("camera") String camera,
            @Context ServletContext sc) 
            		throws Exception
	{
		System.out.println("upload service started");
		System.out.println("fileMetaData: " + fileMetaData);
		System.out.println("fileMetaData: " + fileMetaData.getFileName());
//		String UPLOAD_PATH=sc.getRealPath("D:/"); // We dont need getRealPath here!!
//		String UPLOAD_PATH="D:/";
		String UPLOAD_PATH = "C:/Users/kovac/git/ElectionMachine_Restful_Project/Election_Machine_Restful_Project/src/main/webapp/img";
	    try{
	        int read = 0;
	        byte[] bytes = new byte[1024];
	 
	        OutputStream out = new FileOutputStream(new File(UPLOAD_PATH + "/"+fileMetaData.getFileName()));
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
	    return Response.ok("Data uploaded successfully !!"+
	    					" Phographer: "+photographer+
	    					" Camera: "+camera).build();
	}
	*/
	
}





















/*
import java.io.File;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("/uploadservice")
public class UploadService {
	@POST
	@Path("/fileupload")
	@Consumes({MediaType.MULTIPART_FORM_DATA})
	public Response uploadFile( @FormDataParam("file") InputStream fileInputStream,
            @FormDataParam("file") FormDataContentDisposition fileMetaData, 
            @FormDataParam("photo") String photographer,
            @FormDataParam("camera") String camera,
            @Context ServletContext sc) 
            		throws Exception
	{
		
		String UPLOAD_PATH=sc.getRealPath("C:/Users/kovac/git/ElectionMachine_Restful_Project/Election_Machine_Restful_Project/src/main/webapp/img");
	    try{
	        int read = 0;
	        byte[] bytes = new byte[1024];
	 
	        OutputStream out = new FileOutputStream(new File(UPLOAD_PATH + "/"+fileMetaData.getFileName()));
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
	    return Response.ok("Data uploaded successfully !!"+
	    					" Phographer: "+photographer+
	    					" Camera: "+camera).build();
	}
	
	
}
*/