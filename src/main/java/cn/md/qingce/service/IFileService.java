package cn.md.qingce.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface IFileService {
    public String uploadFile(MultipartFile file, HttpServletRequest request);

    public byte[] downLoad(String fileName);

    byte[] handlerFile(MultipartFile file, HttpServletRequest request);
}
