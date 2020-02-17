package com.yudi.mymall.utils;

import org.apache.commons.lang3.StringUtils;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author yudi
 * @date 2020-02-16 21:18
 */
public class PmsUploadUtils {


    public static String uploadImage(MultipartFile multipartFile){
        String imgUrl = null;
        String path = PmsUploadUtils.class.getResource("/tracker.conf").getPath();
        try {
            ClientGlobal.init(path);
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getConnection();
            StorageClient storageClient = new StorageClient(trackerServer,null);
            byte[] bytes = multipartFile.getBytes();
            String originalFilename = multipartFile.getOriginalFilename();
            String file_ext_name = StringUtils.substringAfterLast(originalFilename, ".");
            String[] strings = storageClient.upload_file(bytes, file_ext_name, null);
            imgUrl = Constrant.FASTDFS_IP;
            for (String s : strings) {
               imgUrl += ("/" + s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imgUrl;
    }
}
