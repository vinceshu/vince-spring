package com.vince.springframework.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author vinceshu
 * @data 2023/2/13 23:14
 * @description 系统文件
 */
public class FileSystemResource implements Resource{

    private final File file;

    private final String path;

    public FileSystemResource(String path) {
        this.file = new File(path);
        this.path = path;
    }

    public FileSystemResource(File file) {
        this.file = file;
        this.path = file.getPath();
    }

    public String getPath() {
        return path;
    }


    /**
     * 通过制定文件路径的方式读取文件信息，如txt、excel
     * @return
     * @throws FileNotFoundException
     */
    @Override
    public InputStream getInputStream() throws FileNotFoundException {
        return new FileInputStream(this.file);
    }
}
