package com.phantom5702.my_generator.service;

import com.phantom5702.my_generator.dao.GeneratorDao;
import com.phantom5702.my_generator.util.GenUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

public class GeneratorService {

    @Autowired
    GeneratorDao generatorCode;

    public byte[] generatorCode(String[] tableNames) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
        for (String tableName : tableNames) {
            //查询表信息
            Map<String, String> table = generatorCode.queryTable(tableName);
            //查询列信息
            List<Map<String, String>> columns = generatorCode.queryColumns(tableName);
            //生成代码
            GenUtils.generatorCode(table, columns, zip);
        }
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }
}
