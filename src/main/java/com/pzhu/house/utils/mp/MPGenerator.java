package com.pzhu.house.utils.mp;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.util.Collections;

/**
 * Mybatis-Plus 代码生成器
 */
public class MPGenerator {

    public static void main(String[] args) {
        final String url = "jdbc:mysql://localhost:3306/house?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=UTC";
        final String username = "root";
        final String password = "root";
        final String jarPath = System.getProperty("user.dir");
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("WuSJ") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .outputDir(jarPath + "/src/main/java/com/pzhu/house/model/entity/lease"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("") // 设置父包名
                            .entity("model")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, jarPath + "/src/main/resources/mapper/lease")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("complaint_info") // 设置需要生成的表名
                            .enableCapitalMode()
                            .entityBuilder()
                            .enableChainModel()
                            .enableLombok()
                            .enableActiveRecord()
                            .versionColumnName("revision").build()
                            .controllerBuilder()
                            .enableHyphenStyle()
                            .enableRestStyle().build()
                            .serviceBuilder()
                            .mapperBuilder()
                            .enableMapperAnnotation()
                            .enableBaseResultMap()
                            .build();

                })
                .templateEngine(new VelocityTemplateEngine()) // 使用Velocity引擎模板
                .execute();
    }

}
