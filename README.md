# maven-mybatis
使用封装jar样例！
github的pageHelper使用
得有一个mybatis-config.xml文件。
spring中需要配置
<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="dataSource" />
		<!-- 自动扫描mapping.xml文件 -->
		<property name="mapperLocations" value="classpath:mapper/**" />
		<!-- mybatis配置文件，主要加了一个github插件 -->
		<property name="configLocation" value="classpath:mybatis-config.xml"/>
</bean>

class里使用样例,三段
1.Page<T> result = PageHelper.startPage(int pageNo,int pageSize)
2.mapper.selectAll(Object... param)
3.PageResponse.wrap(result)