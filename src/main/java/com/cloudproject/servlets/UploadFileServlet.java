package com.cloudproject.servlets;


import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cloudproject.constants.Constants;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

//https://happycoding.io/tutorials/google-cloud/cloud-storage

@WebServlet("/UploadFileServlet")
@MultipartConfig
public class UploadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static final Logger log = Logger.getLogger(UploadFileServlet.class.getName());
	 
	 public void doPost(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		    String message = request.getParameter("message");
		    
		    Part filePart = request.getPart("myFile");

		    String fileName = filePart.getSubmittedFileName();
		    InputStream fileInputStream = filePart.getInputStream();
		    uploadToCloudStorage(fileName, fileInputStream);
		    listToCloudStorage();
		    response.setContentType("text/html;");
		    response.getWriter().println("<p>Your message: File has been Successfully uploaded! </p>");
     }
	 
	 private static void listToCloudStorage() {
		 String projectId = Constants.getProjectId();
		 String bucketName = Constants.getBucketName();
		 Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
		 if(bucketName == null) {
			 for (Bucket bucket : storage.list().iterateAll()) {
				 System.out.println(bucket);
			 }
		 } else {
			 Bucket bucket = storage.get(bucketName);
			 if(bucket == null ) {
				 log.info("No such bucket");
				   return;
			 }
			 for(Blob blob : bucket.list().iterateAll()) {
				log.info(blob.getName());
			 }
		 }
	 }
	 
	 private static String uploadToCloudStorage(String fileName, InputStream fileInputStream) {
		 	String projectId = Constants.getProjectId();
		    String bucketName = Constants.getBucketName();
		    Storage storage =
		        StorageOptions.newBuilder().setProjectId(projectId).build().getService();
		    BlobId blobId = BlobId.of(bucketName, fileName);
		    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
		    Blob blob = storage.create(blobInfo, fileInputStream);
		    return blob.getMediaLink();
		  }
}
