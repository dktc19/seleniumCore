package net.fpt.utils;

import io.minio.MinioClient;
import io.minio.PutObjectOptions;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import io.minio.errors.MinioException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class MinIO {
    static final Logger logger = LoggerFactory.getLogger(MinIO.class);
    private MinioClient  minioClient;

    public final boolean uploadFileEnabled = Boolean.getBoolean("enableUploadFile");
    void initializeMinIOClient() throws  RuntimeException {
        try {
            // Create instance of minio client with configured service details
            minioClient = new MinioClient("upload-static.fpt.net",
                    80,
                    "U2VsZW5pdW0tY29yZS1zdGFn",
                    "c3RhZy1TZWxlbml1bS1jb3Jl",
                    false);
            // Check and create if bucket is available to store catalogue images
            //createBucketIfNotExists();
        }
        catch (InvalidEndpointException | InvalidPortException e) {
            throw new RuntimeException(String.format("MinIO Service is not initialized due to invalid Host:%s or PORT:%s", "", ""));
        }
        catch (Exception e) {
            throw new RuntimeException("Error occurred while initializing MinIO Service", e);
        }
    }

    public void minFileUploader(String fileName, File pathFile) throws IOException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            if(uploadFileEnabled) {
                if (minioClient == null)
                    initializeMinIOClient();

                // Prepare options with size and content type
                PutObjectOptions options = new PutObjectOptions(pathFile.length(), -1);
                options.setContentType("image/png");

                minioClient.putObject("sys", "selenium-core/stag/" + fileName, new FileInputStream(pathFile), options);

                logger.info(fileName + " is uploaded to hi-static successfully");
            } else {
                logger.warn("Disable upload file");
            }
        } catch (MinioException e) {
            logger.error("Error occurred: " + e);
        }
    }

    public void minFileUploader(String fileName, File pathFile,String contentType) throws IOException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            if(uploadFileEnabled) {
                if (minioClient == null)
                    initializeMinIOClient();

                // Prepare options with size and content type
                PutObjectOptions options = new PutObjectOptions(pathFile.length(), -1);
                options.setContentType(contentType);

                minioClient.putObject("sys", "selenium-core/stag/" + fileName, new FileInputStream(pathFile), options);

                logger.info(fileName + " is uploaded to hi-static successfully");
            } else {
                logger.warn("Disable upload file");
            }
        } catch (MinioException e) {
            logger.error("Error occurred: " + e);
        }
    }
}
