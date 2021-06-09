package com.tianxinag.Controller;


import org.apache.commons.io.FileUtils;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;


@Controller
public class FileController{
    /**
     * 跳转到页面
     * @return
     */
    @GetMapping("/upload")  //表示ReuqustMapping + 请求方式
    public String toUpload(){

        return "uploadFiles";
    }


    /**
     * 实现文件上传
     */

    @PostMapping("/uploadFile")
     public String uploadFile(MultipartFile[] fileUpload, Model model) {
         // 返回上传成功的状态信息。
         model.addAttribute("uploadStatus","上传成功");
         for(MultipartFile file:fileUpload){
             //获取上传文件的名字和后缀名
             String originalFilename=file.getOriginalFilename();
             //重新生成文件名
             String s = UUID.randomUUID() + "-" + originalFilename;
             //设置存储目录
             String dirPath="E:\\java\\phpStudy\\public\\file\\";
             //如果文件夹不存在
             File file1 = new File(dirPath);
             if (!file1.exists()){
                 file1.mkdir();
             }
             try {
                 file.transferTo(new File(dirPath+s));
             } catch (IOException e) {
                 model.addAttribute("uploadStatus","上传失败");
             }


         }

         return "uploadFiles";
     }
    @GetMapping("/toDownload")
     public String downLoad(){

        return "downLoad";
     }

    /**
     * 文件下载代码
     */
    @GetMapping("/download")
    public ResponseEntity<byte[]> fileDownLoad(String filename, HttpServletRequest request, HttpServletResponse resp) throws UnsupportedEncodingException {
       request.setCharacterEncoding("UTF-8");
       System.out.println(filename);
        //指定要下载的文件路径
        String dirPath = "E:\\java\\phpStudy\\public\\file\\";
        //创建文件对象
        File file;
        file = new File(dirPath + File.separator + filename);
        //设置响应头
        HttpHeaders httpHeaders = new HttpHeaders();
        //通知浏览器以下载的形式打开
        httpHeaders.setContentDispositionFormData("attachment", filename);
        //定义以流的形式下载返回数据文件。
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        resp.setContentType("text/html;charset=UTF-8");
        try {
            return new ResponseEntity<>(FileUtils.readFileToByteArray(file), httpHeaders, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage().getBytes(),HttpStatus.EXPECTATION_FAILED);
        }

    }


}
