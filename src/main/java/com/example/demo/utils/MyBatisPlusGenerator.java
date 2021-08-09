package com.example.demo.utils;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;


/**
 * @Classname beanUtil
 * @Description MyBatis-Plus代码生成器
 * @Date 2021/6/24 17:38
 * @Created by
 * @Link https://www.cnblogs.com/36bian/p/13182248.html
 */

public class MyBatisPlusGenerator {

    private static final String AUTHOR = "Zhang.C";

    //模块名,包名
    private static final String MODULE_NAME = "";
    private static final String BASE_PACKAGE = "com.example.demo";
    //数据库
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mybatisplus";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "226942";
    //表
    private static final String[] TABLES = {"dept"};
    private static final String PREFIX = "";


    public static void main(String[] args) {
        //当前项目路径
        String projectPath = System.getProperty("user.dir") + "/" + MODULE_NAME;

        // 代码生成器
        AutoGenerator generator = new AutoGenerator();

        //数据库配置
        configDataSource(generator);
        //全局配置
        configGlobal(generator, projectPath);
        //包相关配置
        configPackage(generator);
        //策略配置
        configStrategy(generator);
        //自定义配置 ->还不知道啥用 挺乱先删了
//        cofnigCustom(generator, projectPath);
        //模版引擎配置
        configTemplate(generator);

        generator.execute();
    }

    /**
     * 进行数据库相关配置
     *
     * @param generator :
     * @author kevin
     * @date 2021/2/8 13:27
     */
    private static void configDataSource(AutoGenerator generator) {
        //数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl(JDBC_URL +
                "?useUnicode=true&characterEncoding=UTF-8&useSSL=false&zeroDateTimeBehavior=convertToNull&serverTimezone=UTC");
//        dataSourceConfig.setDbType(DbType.MYSQL);//会从driver中自动获取
        // dataSourceConfig.setSchemaName("public");
        dataSourceConfig.setDriverName(JDBC_DRIVER);
        dataSourceConfig.setUsername(JDBC_USERNAME);
        dataSourceConfig.setPassword(JDBC_PASSWORD);
        generator.setDataSource(dataSourceConfig);
    }

    /**
     * 进行全局配置
     *
     * @param generator   :
     * @param projectPath :
     * @author kevin
     * @date 2021/2/8 13:28
     */
    private static void configGlobal(AutoGenerator generator, String projectPath) {
        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        //生成文件输出存放路径 = 当前项目路径 + 想存放到项目中的路径
        String fileOutputPatch = projectPath.concat("/src/main/java");
        globalConfig.setOutputDir(fileOutputPatch);

        //设置作者
        globalConfig.setAuthor(AUTHOR);
        //生成完后是否打开输出目录
        globalConfig.setOpen(false);
        //是否覆盖生成过的已有文件
        globalConfig.setFileOverride(true);
        //是否开启activeRecord模式
//        globalConfig.setActiveRecord(true);
        // 是否在xml中添加二级缓存配置,默认false
        globalConfig.setEnableCache(false);
        // XML文件返回对象定义ResultMap
        globalConfig.setBaseResultMap(false);
        // XML返回对象字段列表columList
        globalConfig.setBaseColumnList(false);

        globalConfig.setDateType(DateType.ONLY_DATE);
        //设置主键字段类型
        globalConfig.setIdType(IdType.ASSIGN_UUID);
        //生成的文件名字定义，%s 会自动填充表实体属性
        globalConfig.setMapperName("%sMapper");
        globalConfig.setXmlName("%sMapper");
        globalConfig.setEntityName("%s");
        globalConfig.setServiceName("%sService");
        globalConfig.setServiceImplName("%sServiceImpl");
        globalConfig.setControllerName("%sController");
        //开启 swagger2 模式,实体属性 Swagger2 注解,默认false
        globalConfig.setSwagger2(true);
        generator.setGlobalConfig(globalConfig);
    }

    /**
     * 各个包配置
     *
     * @param generator :
     * @author kevin
     * @date 2021/2/8 13:34
     */
    private static void configPackage(AutoGenerator generator) {
        PackageConfig packageConfig = new PackageConfig();
//        packageConfig.setModuleName();
        packageConfig.setParent(BASE_PACKAGE);
        packageConfig.setController("controller");
        packageConfig.setService("service");
        packageConfig.setServiceImpl("service.impl");
        packageConfig.setEntity("entity");
        packageConfig.setMapper("mapper");
        packageConfig.setXml("mapper.xml");
        generator.setPackageInfo(packageConfig);
    }

    /**
     * 策略配置
     *
     * @param generator :
     * @author kevin
     * @date 2021/2/8 13:34
     */
    private static void configStrategy(AutoGenerator generator) {
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //全局大写命名
        //strategy.setCapitalMode(true)
        //全局下划线命名
        //strategy.setDbColumnUnderline(true)
        //表的前缀
        strategy.setTablePrefix(PREFIX);
        //表名下划线转为驼峰
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //字段名下划线转为驼峰
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //生成哪些表
        strategy.setInclude(TABLES);
        strategy.setControllerMappingHyphenStyle(true);
        //设置模版引擎的类型 freemarker使用ftl文件，velocity使用vm文件
        generator.setTemplateEngine(new FreemarkerTemplateEngine());
//        generator.setTemplateEngine(new VelocityTemplateEngine());
        //是否生成SerialVersionUID
        strategy.setEntitySerialVersionUID(false) ;
        //是否使用lombok
        strategy.setEntityLombokModel(true);
        //设置是否restful控制器
        strategy.setRestControllerStyle(true);
        //设置布尔类型字段是否去掉is前缀
        strategy.setEntityBooleanColumnRemoveIsPrefix(true);
        // 自定义实体父类
        // strategy.setSuperEntityClass("com.baomidou.demo.TestEntity");
        // 自定义实体，公共字段
        // strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
        // 自定义 mapper 父类
        // strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
        // 自定义 service 父类
        // strategy.setSuperServiceClass("com.baomidou.demo.TestService");
        // 自定义 service 实现类父类
        // strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
        // 自定义 controller 父类
        // strategy.setSuperControllerClass("com.baomidou.demo.TestController");
        // 【实体】是否生成字段常量（默认 false）
        // public static final String ID = "test_id";
        // strategy.setEntityColumnConstant(true);
        // 【实体】是否为构建者模型（默认 false）
        // public User setName(String name) {this.name = name; return this;}
        // strategy.setEntityBuilderModel(true);
        generator.setStrategy(strategy);
    }

    /**
     * 模版引擎配置
     *
     * @param generator :
     * @author kevin
     * @date 2021/2/8 13:59
     */
    private static void configTemplate(AutoGenerator generator) {
        //模板引擎配置 默认是VelocityTemplateEngine
        TemplateConfig templateConfig = new TemplateConfig();

//        templateConfig.setXml(null);
        generator.setTemplate(templateConfig);
    }
}
