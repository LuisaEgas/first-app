package com.test.myapp;

import com.example.myapp.UploadFile;
import org.junit.jupiter.api.Test;

public class UploadFileTest {

    UploadFile uploadFile = new UploadFile();

    @Test
    public void uploadFile1() {
        uploadFile.UploadFile("file1.csv");
    }

    @Test
    public void uploadFile2() {
        uploadFile.UploadFile("file2.csv");
    }

    @Test
    public void uploadFile3() {
        uploadFile.UploadFile("file3.csv");
    }

    @Test
    public void uploadFile4() {
        uploadFile.UploadFile("file4.csv");
    }
}
