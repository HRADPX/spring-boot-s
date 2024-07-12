package com.kuaishou.springboot.code.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-06-06
 */
public class ZipUtils {

    private static final Logger logger = LoggerFactory.getLogger(ZipUtils.class);

    private static final String ZIP_SUFFIX = "zip";

    private ZipUtils() {

    }

    /**
     * 压缩文件或文件夹，压缩后的文件保持原来的目录结构
     * @param srcFileOrDir 目标文件或文件夹全路径
     * @param zipFileName 压缩包的全路径名
     * @return {@code true} if zip success, otherwise {@code false}
     */
    public static boolean zip(String srcFileOrDir, String zipFileName) {

        if (StringUtils.isAnyBlank(srcFileOrDir, zipFileName)) {
            logger.info("[ZIP ERROR] srcFileOrDir or zipFile must not be empty!");
            return false;
        }
        if (StringUtils.endsWith(zipFileName, ZIP_SUFFIX)) {
            zipFileName += "." + ZIP_SUFFIX;
        }
        boolean zipRes = false;
        File sourceFile = new File(srcFileOrDir);
        if (!sourceFile.exists()) {
            logger.info("[ZIP ERROR] target file is not exist!");
            return false;
        }

        if (sourceFile.isFile()) {
            zipRes = compressFile(sourceFile, zipFileName);
        } else {
            zipRes = compressDir(sourceFile, zipFileName);
        }
        logger.info("[" + srcFileOrDir + "]-->[" + srcFileOrDir + zipFileName + "]压缩结果:[" + zipRes + "]");
        return zipRes;
    }

    private static void closeZipEntry(ZipOutputStream zipOutputStream) {
        try {
            if (zipOutputStream != null) {
                zipOutputStream.closeEntry();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean compressDir(File sourceDir, String zipFileName) {

        boolean zipRes = false;
        String sourceDirName = sourceDir.getName();
        if (!sourceDirName.endsWith(File.separator)) {
            sourceDirName += File.separator;
        }
        File[] files = sourceDir.listFiles();

        ZipOutputStream zipOutputStream = null;
        try {
            zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFileName));
            if (files != null && files.length > 0) {
                for (File file : files) {
                    compressFiles(file, file.getParent(), zipOutputStream);
                }
            }
            zipRes = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            IOUtils.close(zipOutputStream);
        }
        return zipRes;

    }

    private static void compressFiles(File file, String basePath, ZipOutputStream zipOutputStream) {

        if (file == null || zipOutputStream == null) {
            return;
        }
        if (file.isDirectory()) {
            ZipEntry entry = new ZipEntry(getEntryPath(file, basePath) + File.separator);
            try {
                zipOutputStream.putNextEntry(entry);
            } catch (IOException e) {
                e.printStackTrace();
            }

            File[] files = file.listFiles();
            if (files != null && files.length > 0) {
                for (File f : files) {
                    compressFiles(f, basePath, zipOutputStream);
                }
            }
        } else {
            String fileName = getEntryPath(file, basePath);
            ZipEntry entry = new ZipEntry(fileName);

            FileInputStream inputStream = null;
            try {
                inputStream = new FileInputStream(file);
                zipOutputStream.putNextEntry(entry);
                IOUtils.copy(inputStream, zipOutputStream);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                closeZipEntry(zipOutputStream);
                IOUtils.close(inputStream);
            }
        }
    }

    private static boolean compressFile(File sourceFile, String zipFileName) {
        ZipOutputStream zipOutputStream = null;
        boolean zipRes = false;
        try {
            zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFileName));
            ZipEntry entry = new ZipEntry(sourceFile.getName());
            FileInputStream inputStream = null;
            try {
                zipOutputStream.putNextEntry(entry);
                inputStream = new FileInputStream(sourceFile);
                IOUtils.copy(inputStream, zipOutputStream);
                zipRes = true;
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                closeZipEntry(zipOutputStream);
                IOUtils.close(inputStream);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            IOUtils.close(zipOutputStream);
        }
        return zipRes;

    }


    private static String getEntryPath(File file, String basePath) {
        return file.getPath().substring(basePath.length() + 1);
    }


}
