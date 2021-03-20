package com.dmj.controller.admin;

import com.alibaba.fastjson.JSON;
import com.dmj.utils.SystemConstant;
import com.dmj.utils.UUIDUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin/file")
public class FileController {

    /**
     * 文件上传
     * @param file
     * @return
     */
    @RequestMapping("/uploadFile")
    public String uploadFile(MultipartFile file){
        //创建Map集合保存返回的JSON数据
        Map<String,Object> map = new HashMap<String,Object>();
        //判断是否有选中文件
        if(!file.isEmpty()){
            //获取源文件的名称
            String oldFileName = file.getOriginalFilename();
            //获取文件的后缀名
            String extension = FilenameUtils.getExtension(oldFileName);
            //重命名旧文件
            String newFileName = UUIDUtils.randomUUID()+"."+extension;
            //为了解决同一个文件夹下文件过多的问题，使用日期作为文件夹管理
            String datePath = new SimpleDateFormat("yyyyMMdd").format(new Date());
            //组装最终的文件名
            String finalName = datePath + "/" + newFileName;
            //创建文件对象
            //参数1：文件上传的地址  参数2：文件名称
            File dest = new File(SystemConstant.IMAGE_UPLOAD_PATH,finalName);
            //判断该文件夹是否存在，不存在则创建文件夹
            if(!dest.getParentFile().exists()){
                dest.getParentFile().mkdirs();//创建文件夹
            }

            try {
                //进行文件上传
                file.transferTo(dest);
                map.put("code",0);//状态码
                map.put("msg","上传成功");//执行消息
                Map<String,Object> dataMap = new HashMap<String,Object>();
                dataMap.put("src","/hotel/show/"+finalName);
                map.put("data",dataMap);//文件数据
                map.put("imagePath",finalName);//隐藏域的值，只保留日期文件夹+重命名后的文件名

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return JSON.toJSONString(map);
    }

}
