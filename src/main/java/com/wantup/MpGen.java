package com.wantup;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import javax.sql.DataSource;
/**
 * @author 赵洛伟
 * @since 2019-06-04
 */
public class MpGen {

    /**
     * 代码生成器
     * 可以参看
     * https://mp.baomidou.com/guide/generator.html#%E4%BD%BF%E7%94%A8%E6%95%99%E7%A8%8B
     * https://blog.csdn.net/u014745069/article/details/80720980
     * https://www.cnblogs.com/shy-blog/p/10006451.html
     * @param args
     */
    public static void main(String[] args) {
        //1. 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setActiveRecord(true)//是否支持ar 模式 会继承一个model
                .setAuthor("赵洛伟")//设置作者
                .setIdType(IdType.AUTO)//设置id类型 主键自增
                .setOutputDir("C:\\Users\\10334\\Desktop\\mp")//指定生成路径
                .setFileOverride(true)//多次生成文件覆盖
                .setBaseResultMap(true)//基本的SQL映射
                .setBaseColumnList(true);//生成基本的SQL片段


        //2. 数据库配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)//设置数据库类型
                .setDriverName("com.mysql.jdbc.Driver")
                .setUrl("jdbc:mysql://localhost:3306/shop")
                .setUsername("root")
                .setPassword("123456");

        //3. 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true)//全局大写命名
                .setDbColumnUnderline(true)//指定表名字段名是否使用下划线
                .setNaming(NamingStrategy.underline_to_camel)//下划线转驼峰式命名
                .setColumnNaming(NamingStrategy.underline_to_camel)
                //.setTablePrefix("tbl_")//设置表名前缀
                .setInclude("tbl_user")//设置映射的表
                .setEntityLombokModel(true)//lombok配置
                .setEntityColumnConstant(true);//字段常量映射
                //.setEntityBuilderModel(true);
               // .setEntityBooleanColumnRemoveIsPrefix(true);


        //4. 包名策略配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.wantup")//指定父包
                .setMapper("mapper")
                .setService("service")
                .setController("controller")
                .setEntity("entity").setXml("xml");


        //5. 整合配置
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(globalConfig)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig);


        //6.执行
        autoGenerator.execute();


    }

}
