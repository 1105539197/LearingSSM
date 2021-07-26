package com.example.demo.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.example.demo.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Classname ImportController
 * @Description TODO
 * @Date 2021/7/26 11:01
 * @Created by ZhangChen
 */
@RestController
@Slf4j
@RequestMapping("/import")
public class ImportController {


    @PostMapping("/excel")
    public List<Student> importStudents(@RequestParam("file") MultipartFile file) {
        InputStream in;
        List<Student> list = null;
        ImportParams params = new ImportParams();
        params.setTitleRows(1);
        try {
            in = file.getInputStream();
            list = ExcelImportUtil.importExcel(in, Student.class, params);
        } catch (Exception e) {
            log.error("Excel导入失败!", e);
        }
        return list;
    }

    @PostMapping(value = "/picture",produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    public BufferedImage importPicture(@RequestParam("file") MultipartFile file) {
        try {
            return ImageIO.read(file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
