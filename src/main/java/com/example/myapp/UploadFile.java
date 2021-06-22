package com.example.myapp;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import java.io.File;

public class UploadFile {

    public void UploadFile(String name) {
        Regions clientRegion = Regions.US_WEST_1;
        String bucketName = "prueba-uno-bucket";
        String fileName = "C:\\Users\\lbolanos\\Documents\\Upload\\" + name;
        String fileObjKeyName = name;
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                System.out.println(fileName + ": El archivo no existe.");
            } else {
                AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                        .withRegion(clientRegion)
                        .build();

                PutObjectRequest request = new PutObjectRequest(bucketName, fileObjKeyName, file);
                ObjectMetadata metadata = new ObjectMetadata();
                metadata.setContentType("text/csv");
                metadata.addUserMetadata("title", "Example upload s3");
                request.setMetadata(metadata);
                s3Client.putObject(request);
                System.out.println(fileName + ": Archivo cargado a S3");
            }
        }
        catch (AmazonServiceException e) {
            e.printStackTrace();
        } catch (SdkClientException e) {
            e.printStackTrace();
        }
    }
}
