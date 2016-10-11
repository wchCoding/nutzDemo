package com.wch.nutz;

import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.SetupBy;
import org.nutz.mvc.ioc.provider.ComboIocProvider;



@SetupBy(value = MainSetup.class)
/**
 * ComboIocProvider的args参数, 星号开头的是类名或内置缩写,剩余的是各加载器的参数
 * js 是JsonIocLoader,负责加载js/json结尾的ioc配置文件
 * anno 是AnnotationIocLoader,负责处理注解式Ioc, 例如@IocBean
 * tx 是TransIocLoader,负责加载内置的事务拦截器定义, 1.b.52开始自带
 * 对于js找不到，是版本过低，需要高一点的版本，并且要  *org.nutz.ioc.loader.json.JsonLoader
 * @author LP
 *
 */
@IocBy(type=ComboIocProvider.class, args={"*org.nutz.ioc.loader.json.JsonLoader", "conf/ioc/",
    "*anno", "com.wch.nutz",
    "*tx"})
//模块类自动扫描
@Modules(scanPackage = true)
public class MainModule {

}
