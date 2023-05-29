package generate;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.xiao.fang.zi.xiaofangziserver.controller.BaseController;
import com.xiao.fang.zi.xiaofangziserver.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public class GenerateCode {

    public static void main(String[] args) {

        String[] tables = {"article","file","like","story","user"};
        String dataUrl = "jdbc:mysql://***:3306/xiaofangzi?characterEncoding=UTF-8&useUnicode=true&useSSL=false&allowPublicKeyRetrieval=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=CTT";
        String driverName = "com.mysql.cj.jdbc.Driver";
        String username = "username";
        String password = "password";

        AutoGenerator mpg = new AutoGenerator();
        String projectPath = System.getProperty("user.dir");
        String templatePath = "/template/mapper.xml.ftl";
        String ENTITY_TEMPLATE = "/template/entity.java.ftl";
        String ENTITY_DTO_TEMPLATE = "/template/entityDto.java.ftl";
        String ENTITY_RESPONSE_DTO_TEMPLATE = "/template/entityResponseDto.java.ftl";
        List<FileOutConfig> focList = new ArrayList<>();
        TemplateConfig config = new TemplateConfig();
        config.setController("/template/controller.java");
        config.setService("/template/service.java");
        config.setServiceImpl("/template/serviceImpl.java");
        config.setMapper("/template/mapper.java");
        config.setEntity("/template/entity.java");
        mpg.setTemplate(config);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("xiaofangzi");
        gc.setOpen(false);
        gc.setFileOverride(true);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        gc.setServiceName("%sService");
        gc.setIdType(IdType.ASSIGN_UUID);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(false);
        mpg.setGlobalConfig(gc);
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(dataUrl);
        dsc.setDriverName(driverName);
        dsc.setUsername(username);
        dsc.setPassword(password);
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {

            }
        };
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(null);
        pc.setParent("com.xiao.fang.zi.xiaofangziserver");
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setMapper("mapper");
        focList.add(new FileOutConfig(ENTITY_DTO_TEMPLATE) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/src/main/java/com/xiao/fang/zi/xiaofangziserver/entity/queryDto/" + tableInfo.getEntityName() + "Dto" + StringPool.DOT_JAVA;
            }
        });
        focList.add(new FileOutConfig(ENTITY_RESPONSE_DTO_TEMPLATE) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/src/main/java/com/xiao/fang/zi/xiaofangziserver/entity/responseDto/" + tableInfo.getEntityName() + "ResponseDto" + StringPool.DOT_JAVA;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setPackageInfo(pc);
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude(tables);
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        strategy.setSuperControllerClass(BaseController.class);
        strategy.setSuperEntityClass(BaseEntity.class);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setEntityColumnConstant(true);
        strategy.setEntityBuilderModel(true);
        strategy.setEntityTableFieldAnnotationEnable(true);
//        String[] SuperEntityColumns = new String[]{"create_datetime", "update_datetime", "create_user_id", "update_user_id", "c_bsflag", "delete_user_id", "delete_datetime"};
//        strategy.setSuperEntityColumns(SuperEntityColumns);
        mpg.setStrategy(strategy);
        mpg.execute();


    }
}
