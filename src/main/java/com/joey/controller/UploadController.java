package com.joey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

/**
 * 〈上传controller〉
 *
 * @author Joey
 * @create 2019-01-11
 * @since 1.0.0
 */

@Controller
public class UploadController {

    /**
     * 单个文件上传
     * @return
     */
    @RequestMapping("/uploadPage")
    public String upload(){
        return "upload";
    }

    /**
     * 批量文件上传
     * @return
     */
    @RequestMapping("/uploadsPage")
    public String uploads(){
        return "uploads";
    }

    /**
     *
     * @param file 与html页面input提交的name属性一致
     * @param request
     * @return
     */
    @PostMapping("/upload")
    @ResponseBody
    public String uploadFile(MultipartFile file, HttpServletRequest request){
        try{
            //创建文件在服务器端的存放路径
            //String dir = request.getServletContext().getRealPath("/upload");
            //查看保存路径
            //System.out.println(dir);
            String dir = "D:\\IdeaProjects\\fcy\\SpringBoot\\load";
            File fileDir = new File(dir);
            if(!fileDir.exists()) {
                fileDir.mkdirs();

            }
            //生成文件在服务器端存放名称
            String fileSuffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            String fileName = UUID.randomUUID()+fileSuffix;
            //上传
            File files = new File(fileDir+"/"+fileName);
            file.transferTo(files);
        }catch (Exception e){
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";
    }


    /**
     *
     * @param file 与html页面input提交的name属性一致
     * @param request
     * @return
     */
    @PostMapping("/uploads")
    @ResponseBody
    public String uploadFiles(MultipartFile[] file, HttpServletRequest request){
        try{
            //创建文件在服务器端的存放路径
            //String dir = request.getServletContext().getRealPath("/upload");
            String dir = "D:\\IdeaProjects\\fcy\\SpringBoot\\load";
            File fileDir = new File(dir);
            if(!fileDir.exists()) {
                fileDir.mkdirs();
            }
            //生成文件在服务器端存放名称
            for(int i=0;i<file.length;i++){
                String fileSuffix = file[i].getOriginalFilename().substring(file[i].getOriginalFilename().lastIndexOf("."));
                String fileName = UUID.randomUUID()+fileSuffix;
                //上传
                File files = new File(fileDir+"/"+fileName);
                file[i].transferTo(files);
            }
        }catch (Exception e){
            e.printStackTrace();
            return "批量上传失败";
        }
        return "批量上传成功";
    }
}
