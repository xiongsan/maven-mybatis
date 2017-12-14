# maven-mybatis
maven 结合mybatis在结合react再结合redux管理项目
用maven管理项目,结合react

项目启动：tomcat跑起来，润喉如果webapp下没有node_modules文件，需要git切换到webapp目录下
本地调试：开发阶段
1，执行npm install安装node_modules
2，执行npm run start运行3000端口的



服务器发布阶段：
服务器版本，输出js在dist目录下
入口jsp debug模式下为http://localhost:3000/dist/main.bundle.js
构建时去掉http://localhost:3000/
并执行npm run build后执行maven install输出jar