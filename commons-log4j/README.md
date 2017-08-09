
#### log4j


```
1、log4j.xml和log4j.properties两者只能选一，否则不能正常加载

2、默认情况下log4j就能初始化，只需要添加jar包和配置文件

3、也可以自己加载配置文件 参考LogInit

4、更详细讲解请参考  log4j使用.zip

```

#### 使用

##### 介绍
```
log4j--log for java(java的日志) 。Apache为我们提供了的一个强有力的日志操作包-Log4j。
```

##### 如何配置log4j
###### 第一步 添加maven依赖
```
<dependency>
  <groupId>log4j</groupId>
  <artifactId>log4j</artifactId>
  <version>1.2.8</version>
</dependency>
```
###### 第二步 添加配置文件
```
log4j.rootCategory=INFO, stdout , R

log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=[QC] %p [%t] %C.%M(%L) | %m%n

log4j.appender.R=org.apache.log4j.DailyRollingFileAppender
log4j.appender.R.File=D:\\Tomcat 5.5\\logs\\qc.log
log4j.appender.R.layout=org.apache.log4j.PatternLayout
log4j.appender.R.layout.ConversionPattern=%d-[TS] %p %t %c - %m%n

log4j.logger.com.neusoft=DEBUG
log4j.logger.com.opensymphony.oscache=ERROR
log4j.logger.net.sf.navigator=ERROR
log4j.logger.org.apache.commons=ERROR
log4j.logger.org.apache.struts=WARN
log4j.logger.org.displaytag=ERROR
log4j.logger.org.springframework=DEBUG
log4j.logger.com.ibatis.db=WARN
log4j.logger.org.apache.velocity=FATAL

log4j.logger.com.canoo.webtest=WARN

log4j.logger.org.hibernate.ps.PreparedStatementCache=WARN
log4j.logger.org.hibernate=DEBUG
log4j.logger.org.logicalcobwebs=WARN
```
###### 第三步
```
相应的修改其中属性，修改之前就必须知道这些都是干什么的，在第二部分讲解。
```
###### 第四步
```
在要输出日志的类中加入相关语句：
定义属性：static Logger logger = Logger.getLogger(LogDemo.class); //LogDemo为相关的类
在相应的方法中：
if (logger.isDebugEnabled()){
logger.debug(“System …..”);
}
```

##### log4j.properties配置文件讲解

###### 1 log4j.rootCategory=INFO, stdout , R
```
此句为将等级为INFO的日志信息输出到stdout和R这两个目的地，stdout和R的定义在下面的代码，可以任意起名。等级可分为OFF、FATAL、ERROR、WARN、INFO、DEBUG、ALL，如果配置OFF则不打出任何信息，如果配置为INFO这样只显示INFO, WARN, ERROR的log信息，而DEBUG信息不会被显示，具体讲解可参照第三部分定义配置文件中的logger。
```
###### 3 log4j.appender.stdout=org.apache.log4j.ConsoleAppender
```
此句为定义名为stdout的输出端是哪种类型，可以是
org.apache.log4j.ConsoleAppender（控制台），
org.apache.log4j.FileAppender（文件），
org.apache.log4j.DailyRollingFileAppender（每天产生一个日志文件），
org.apache.log4j.RollingFileAppender（文件大小到达指定尺寸的时候产生一个新的文件）
org.apache.log4j.WriterAppender（将日志信息以流格式发送到任意指定的地方）
具体讲解可参照第三部分定义配置文件中的Appender。
```
###### 4 log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
```
此句为定义名为stdout的输出端的layout是哪种类型，可以是
org.apache.log4j.HTMLLayout（以HTML表格形式布局），
org.apache.log4j.PatternLayout（可以灵活地指定布局模式），
org.apache.log4j.SimpleLayout（包含日志信息的级别和信息字符串），
org.apache.log4j.TTCCLayout（包含日志产生的时间、线程、类别等等信息）
具体讲解可参照第三部分定义配置文件中的Layout。
```
###### 5 log4j.appender.stdout.layout.ConversionPattern= [QC] %p [%t] %C.%M(%L) | %m%n
```
如果使用pattern布局就要指定的打印信息的具体格式ConversionPattern，打印参数如下：
%m 输出代码中指定的消息；
%M 输出打印该条日志的方法名；
%p 输出优先级，即DEBUG，INFO，WARN，ERROR，FATAL；
%r 输出自应用启动到输出该log信息耗费的毫秒数；
%c 输出所属的类目，通常就是所在类的全名；
%t 输出产生该日志事件的线程名；
%n 输出一个回车换行符，Windows平台为"rn”，Unix平台为"n”；
%d 输出日志时间点的日期或时间，默认格式为ISO8601，也可以在其后指定格式，比如：%d{yyyy-MM-dd HH:mm:ss,SSS}，输出类似：2002-10-18 22:10:28,921；
%l 输出日志事件的发生位置，及在代码中的行数；
[QC]是log信息的开头，可以为任意字符，一般为项目简称。
输出的信息
[TS] DEBUG [main] AbstractBeanFactory.getBean(189) | Returning cached instance of singleton bean 'MyAutoProxy'
具体讲解可参照第三部分定义配置文件中的格式化日志信息。
```
###### 7 log4j.appender.R=org.apache.log4j.DailyRollingFileAppender
```
此句与第3行一样。定义名为R的输出端的类型为每天产生一个日志文件。
```
###### 8 log4j.appender.R.File=D:\\Tomcat 5.5\\logs\\qc.log
```
此句为定义名为R的输出端的文件名为D:\\Tomcat 5.5\\logs\\qc.log可以自行修改。
```
###### 9 log4j.appender.R.layout=org.apache.log4j.PatternLayout
```
与第4行相同。
```
###### 10 log4j.appender.R.layout.ConversionPattern=%d-[TS] %p %t %c - %m%n
```
与第5行相同。
```
###### 12 log4j.logger.com. neusoft =DEBUG
```
指定com.neusoft包下的所有类的等级为DEBUG。
可以把com.neusoft改为自己项目所用的包名。
```
###### 13 log4j.logger.com.opensymphony.oscache=ERROR

###### 14 log4j.logger.net.sf.navigator=ERROR
```
这两句是把这两个包下出现的错误的等级设为ERROR，如果项目中没有配置EHCache，则不需要这两句。
```
###### 15 log4j.logger.org.apache.commons=ERROR

###### 16 log4j.logger.org.apache.struts=WARN
```
这两句是struts的包。
```
###### 17 log4j.logger.org.displaytag=ERROR
```
这句是displaytag的包。（QC问题列表页面所用）
```
###### 18 log4j.logger.org.springframework=DEBUG
```
此句为Spring的包。
```
###### 24 log4j.logger.org.hibernate.ps.PreparedStatementCache=WARN

###### 25 log4j.logger.org.hibernate=DEBUG
```
此两句是hibernate的包。
```

以上这些包的设置可根据项目的实际情况而自行定制。


##### log4j的详细讲解
###### 定义配置文件
```
Log4j支持两种配置文件格式，一种是XML（标准通用标记语言下的一个应用）格式的文件，一种是Java特性文件log4j.properties（键=值）。下面将介绍使用log4j.properties文件作为配置文件的方法:
①、配置根Logger
Logger 负责处理日志记录的大部分操作。
其语法为：
log4j.rootLogger = [ level ] , appenderName, appenderName, …
其中，level 是日志记录的优先级，分为OFF、FATAL、ERROR、WARN、INFO、DEBUG、ALL或者自定义的级别。Log4j建议只使用四个级别，优 先级从高到低分别是ERROR、WARN、INFO、DEBUG。通过在这里定义的级别，您可以控制到应用程序中 相应级别的日志信息的开关。比如在这里定义了INFO级别，只有等于及高于这个级别的才进行处理，则应用程序中所有DEBUG级别的日志信息将不被打印出 来。ALL:打印所有的日志，OFF：关闭所有的日志输出。 appenderName就是指定日志信息输出到哪个地方。可同时指定多个输出目的地。
②、配置日志信息输出目的地 Appender
Appender 负责控制日志记录操作的输出。
其语法为：
log4j.appender.appenderName = fully.qualified.name.of.appender.class
log4j.appender.appenderName.option1 = value1
log4j.appender.appenderName.optionN = valueN
这里的appenderName为在①里定义的，可任意起名。
其中，Log4j提供的appender有以下几种：
org.apache.log4j.ConsoleAppender（控制台），
org.apache.log4j.FileAppender（文件），
org.apache.log4j.DailyRollingFileAppender（每天产生一个日志文件），
org.apache.log4j.RollingFileAppender（文件大小到达指定尺寸的时候产生一个 新的文件），可通过log4j.appender.R.MaxFileSize=100KB设置文件大小，还可通过 log4j.appender.R.MaxBackupIndex=1设置为保存一个备份文件。
org.apache.log4j.WriterAppender（将日志信息以流格式发送到任意指定的地方）
例如：log4j.appender.stdout=org.apache.log4j.ConsoleAppender
定义一个名为stdout的输出目的地，ConsoleAppender为控制台。
③、配置日志信息的格式（布局）Layout
Layout 负责格式化Appender的输出。
其语法为：
log4j.appender.appenderName.layout = fully.qualified.name.of.layout.class
log4j.appender.appenderName.layout.option1 = value1
…
log4j.appender.appenderName.layout.optionN = valueN
其中，Log4j提供的layout有以下几种：
org.apache.log4j.HTMLLayout（以HTML表格形式布局），
org.apache.log4j.PatternLayout（可以灵活地指定布局模式），
org.apache.log4j.SimpleLayout（包含日志信息的级别和信息字符串），
org.apache.log4j.TTCCLayout（包含日志产生的时间、线程、类别等等信息）
格式化日志信息
Log4J采用类似C语言中的printf函数的打印格式格式化日志信息，打印参数如下：
%m 输出代码中指定的消息；
%M 输出打印该条日志的方法名；
%p 输出优先级，即DEBUG，INFO，WARN，ERROR，FATAL；
%r 输出自应用启动到输出该log信息耗费的毫秒数；
%c 输出所属的类目，通常就是所在类的全名；
%t 输出产生该日志事件的线程名；
%n 输出一个回车换行符，Windows平台为"rn”，Unix平台为"n”；
%d 输出日志时间点的日期或时间，默认格式为ISO8601，也可以在其后指定格式，比如：%d{yyyy-MM-dd HH:mm:ss,SSS}，输出类似：2002-10-18 22:10:28,921；
%l 输出日志事件的发生位置，及在代码中的行数。
运用在代码中
```
#### 我们在需要输出日志信息的类中做如下的三个工作：

```
1、导入所有需的commons-logging类：
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
2、在自己的类中定义一个org.apache.commons.logging.Log类的私有静态类成员：
private final Log log = LogFactory.getLog(getClass());
LogFactory.getLog()方法的参数使用的是当前类的class。
3、使用org.apache.commons.logging.Log类的成员方法输出日志信息：
if (log.isDebugEnabled()){
log.debug("111");
}
if (log.isInfoEnabled()){
log.info("222");
}
if (log.isWarnEnabled()){
log.warn("333");
}
if (log.isErrorEnabled()){
log.error("444");
}
if (log.isFatalEnabled()){
log.fatal("555");
}
2.3　如何应用记录器的层次
2.3.1　如何定义及获取不同层次的记录器
任何一个记录器的使用都有两个步骤：
1) 在配置文件中定义相应的记录器。
在配置文件中定义记录器的格式有两种
? 定义根记录器的格式为
log4j.rootLogger = [ level ], appendName1, appendName2, …appendNameN
? 定义一个非根记录器的格式为
log4j.logger.loggerName1 = [ level ], appendName1,…appendNameN

log4j.logger.loggerNameM = [ level ], appendName1, …appendNameN
我们可以定义任意个非根记录器。
2) 在代码中调用Logger类的取得记录器方法取得相应的记录器对象。
要取得根记录器对象可通过Logger.getRootLogger()函数，要取得非根记录器可通过Logger.getLogger()函数。
理论知道就讲到这里，纸上得来终觉浅，下面，我们来小小演练一下。
例4-a：
package TestLog4j;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Priority;
import TestLog4j.TestLog4j2.TestLog4j2;
public class TestLog4j
{
static Logger logger = Logger.getLogger(TestLog4j.class.getName());　//（2）
public TestLog4j(){}
public static void main(String[] args)
{
//同时输出到控制台和一个文件的实例并实现了Logger的继承
PropertyConfigurator.configure("F:\\nepalon\\log4j2.properties");
logger.debug("Start of the main() in TestLog4j");
logger.info("Just testing a log message with priority set to INFO");
logger.warn("Just testing a log message with priority set to WARN");
logger.error("Just testing a log message with priority set to ERROR");
logger.fatal("Just testing a log message with priority set to FATAL");
logger.log(Priority.WARN, "Testing a log message use a alternate form");
logger.debug(TestLog4j.class.getName());
TestLog4j2 testLog4j2 = new TestLog4j2();　//（1）
testLog4j2.testLog();
}
}
在类TestLog4j中我们调用了另一个类TestLog4j2，下面看一下类TestLog4j2的代码。
例4-b：
package TestLog4j.TestLog4j2;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Priority;
public class TestLog4j2
{
static Logger logger = Logger.getLogger(TestLog4j2.class.getName());　//（1）
public TestLog4j2(){}
public void testLog()
{
//同时输出到控制台和一个文件的实例
PropertyConfigurator.configure("F:\\nepalon\\log4j2.properties");
logger.debug("2Start of the main()");
logger.info("2Just testing a log message with priority set to INFO");
logger.warn("2Just testing a log message with priority set to WARN");
logger.error("2Just testing a log message with priority set to ERROR");
logger.fatal("2Just testing a log message with priority set to FATAL");
logger.log(Priority.DEBUG, "Testing a log message use a alternate form");
logger.debug("2End of the main()");
}
}
```
##### 最后我们来看一下配置文件。
```
例4-c：
log4j2.properties文件内容
#1区
#### Use two appenders, one to log to console, another to log to a file
log4j.rootLogger = debug, stdout,R
#2区
#Print only messages of priority WARN or higher for your category
log4j.logger.TestLog4j= , R
log4j.logger.TestLog4j.TestLog4j2=WARN
#3区
#### First appender writes to console
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
# Pattern to output the caller's file name and line number.
log4j.appender.stdout.layout.ConversionPattern=%5p [%t] (%F:%L) - %m%n
#4区
#### Second appender writes to a file
log4j.appender.R=org.apache.log4j.RollingFileAppender
log4j.appender.R.File=F:\\nepalon\\classes\\TestLog4j\\example.log
# Control the maximum log file size
log4j.appender.R.MaxFileSize=100KB
# Archive log files (one backup file here)
log4j.appender.R.MaxBackupIndex=1
log4j.appender.R.layout=org.apache.log4j.PatternLayout
log4j.appender.R.layout.ConversionPattern=%d{yyyy-MM-dd hh:mm:ss}:%p %t %c - %m%n
先看一下运行结果。
在控制台中的结果为：
DEBUG [main] (?:?) - Start of the main() in TestLog4j
INFO [main] (?:?) - Just testing a log message with priority set to INFO
WARN [main] (?:?) - Just testing a log message with priority set to WARN
ERROR [main] (?:?) - Just testing a log message with priority set to ERROR
FATAL [main] (?:?) - Just testing a log message with priority set to FATAL
WARN [main] (?:?) - Testing a log message use a alternate form
DEBUG [main] (?:?) - TestLog4j.TestLog4j
WARN [main] (?:?) - 2Just testing a log message with priority set to WARN
ERROR [main] (?:?) - 2Just testing a log message with priority set to ERROR
FATAL [main] (?:?) - 2Just testing a log message with priority set to FATAL
输出文件的结果为：
2003-12-19 04:19:44:DEBUG main TestLog4j.TestLog4j - Start of the main() in TestLog4j
2003-12-19 04:19:44:INFO main TestLog4j.TestLog4j - Just testing a log message with priority set to INFO
2003-12-19 04:19:44:WARN main TestLog4j.TestLog4j - Just testing a log message with priority set to WARN
2003-12-19 04:19:44:ERROR main TestLog4j.TestLog4j - Just testing a log message with priority set to ERROR
2003-12-19 04:19:44:FATAL main TestLog4j.TestLog4j - Just testing a log message with priority set to FATAL
2003-12-19 04:19:44:WARN main TestLog4j.TestLog4j - Testing a log message use a alternate form
2003-12-19 04:19:44:DEBUG main TestLog4j.TestLog4j - TestLog4j.TestLog4j
2003-12-19 04:19:44:WARN main TestLog4j.TestLog4j2.TestLog4j2 - 2Just testing a log message with priority set to WARN
2003-12-19 04:19:44:ERROR main TestLog4j.TestLog4j2.TestLog4j2 - 2Just testing a log message with priority set to ERROR
2003-12-19 04:19:44:FATAL main TestLog4j.TestLog4j2.TestLog4j2 - 2Just testing a log message with priority set to FATAL
首先，先来看一下配置文件都有些什么东西。
1) 在1区中定义了一个根记录器。这个根记录器具有DEBUG级别并有一个名称为stdout的输出端appender。
2) 2区中的内容是这一节的重点，也是应用到记录器层次的地方，但其实也只有两句，充分体现了log4j的简单性。在这里，我们定义了两个名称分别为TestLog4j和TestLog4j.TestLog4j2设计器。
? 在定义TestLog4j记录器时没有指定级别，所以它的级别继承自它的父记录器，即根记录器，所以它的级别也为DEBUG。在定义TestLog4j记 录器时又定义了一个名称为R的输出端，所以它的输出端有两个，一个从根记录器继承而来的名为stdout的输出端，另一个为在此定义的名为R的输出端。在 此需要注意的是，在定义记录器时必须先定义记录器的级别，然后才是记录器的输出端。如果只想定义输出端而不定义级别，则虽然级别可以为空，但逗号分隔符不 能省略。如定义TestLog4j记录器的做法。
? 在定义TestLog4j.TestLog4j2记录器时又指定了它的级别，由于一个记录器的级别只能有一个，所以新指定的级别将覆写掉它的父记录器的级别（这就象Java中的多态）。我们没有定义TestLog4j.TestLog4j2记录器的输出端，所以它的输出端将从它的父记录器中继承而来。它的父记录器为estLog4j记录器，所以它和estLog4j记录器一样具有两个名称分别为 stdout和R的输出端。
3) 剩下的3区和4区分别设置了两个输出端的参数值。
接下来，回到我们的代码，看一下是如何取得记录器，在取记录器时又发生了什么。
1) 例4-a中的代码（2）中，语句Logger.getLogger()中的参数TestLog4j.class.getName()的值为 TestLog4j. TestLog4j，所以此语句的结果是取得一个名为TestLog4j. TestLog4j的记录器的对象。但在配置文件中并没有定义这样的记录器，所以最终将返回与所需的名称TestLog4j. TestLog4j最接近的记录器对象，即名为TestLog4j的记录器的对象。
2) 例4-b中的代码（1）的原理与例4-a中的代码（2）相似，期望取得的是名为TestLog4j.TestLog4j2. TestLog4j2的记录器对象，但最终返回的是TestLog4j.TestLog4j2记录器的对象。

```

