# zero-conf
A configuration library for java, support Java properties, yaml, json and xml format.

## Features
* supports files in four formats: Java properties, JSON, XML and YAML.
* can load from classpath, files or URLs.
* can load config from Java system properties, like: java -jar app.jar -Dapp.version=1.0

## Maven dependency

```
<dependency>
    <groupId>com.bytebeats</groupId>
    <artifactId>zero-conf</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

## API Example
### load Properties
```
Config config = ConfigLoader.load("app.properties", Format.PROPERTIES);

System.out.println("app-name: "+ config.getString("app-name"));
System.out.println("app-version: "+ config.getDouble("app-version"));
System.out.println("proxy-allowed: "+ config.getBoolean("proxy-allowed"));
System.out.println("read_timeout: "+ config.getInteger("read_timeout"));
```

### read JSON
```
Config config = ConfigLoader.load("app.json", Format.JSON);
Configuration conf = config.toJavaBean(Configuration.class);
System.out.println(conf);
```

### read XML
```
Config config = ConfigLoader.load("app.xml", Format.XML);
Configuration conf = config.toJavaBean(Configuration.class);
System.out.println(conf);
```

### read YAML
```
Config config = ConfigLoader.load("app.yml", Format.YAML);
Configuration conf = config.toJavaBean(Configuration.class);
System.out.println(conf);
```

### read config file
```
Config config = ConfigLoader.parseFile(new File("/config/app.yml"), Format.YAML);
Configuration conf = config.toJavaBean(Configuration.class);
System.out.println(conf);
```

### read URL
```
Config config = ConfigLoader.parseURL(new URL("http://www.app.com/config/app.yml"), Format.YAML);
Configuration conf = config.toJavaBean(Configuration.class);
System.out.println(conf);
```

### read Java system properties
```
System.setProperty("app.version", "1.0");

Config config = ConfigLoader.load();
System.out.println("app.version: "+ config.getDouble("app.version"));
```