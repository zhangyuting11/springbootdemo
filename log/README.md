### springboot 日志

#### 配置文件中配置


`
logging:
  level:
    com.zyt.log: debug #com.zyt.log设置日志级别为 debug
    root: info #root下设置级别为info
  file:
    #日志保存绝对路径
    path: D:\张玉庭\workspace\springboot-learning\springbootdemo\log\
    #日志名
    name: D:\张玉庭\workspace\springboot-learning\springbootdemo\log\mylog
    #自定义日志配置,当配置了config 则会去读取相应的日志配置文件
  config: classpath:logback-spring.xml
`  

#### 自定义配置文件 logback-spring.xml

###