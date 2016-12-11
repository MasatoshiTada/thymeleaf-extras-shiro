thymeleaf-extras-shiro
======================

Thymeleafdialect for Apache Shiro 1.3.
It has almost same features to Shiro's JSP tags.

Caution
=======

学習目的で作成したものですので、あまり詳細にはテストしていません。
本番環境には使わないでください。

Do not use for production.

Setup
=====

```bash
git clone https://github.com/MasatoshiTada/thymeleaf-extras-shiro.git
cd thymeleaf-extras-shiro
mvn clean package install
```

License
=======

Apache License 2.0

How to use
==========

- pom.xml
```xml
        <dependency>
            <groupId>com.suke_masa</groupId>
            <artifactId>thymeleaf-extras-shiro</artifactId>
            <version>1.0-SNAPSHOT</version>
            <scope>compile</scope>
        </dependency>
        <dependency>
            <groupId>org.thymeleaf</groupId>
            <artifactId>thymeleaf</artifactId>
            <version>3.0.2.RELEASE</version>
            <scope>compile</scope>
        </dependency>
        <dependency>
            <groupId>org.apache.shiro</groupId>
            <artifactId>shiro-core</artifactId>
            <version>1.3.2</version>
            <scope>compile</scope>
        </dependency>
        <dependency>
            <groupId>org.apache.shiro</groupId>
            <artifactId>shiro-web</artifactId>
            <version>1.3.2</version>
            <scope>compile</scope>
        </dependency>
```

- Namespace

```html
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      xmlns:shiro="http://suke_masa.com/thymeleaf/shiro">
```

- Attribute
  - `shiro:authenticated`
  - `shiro:guest`
  - `shiro:hasAnyRole`
  - `shiro:hasPermission`
  - `shiro:hasRole`
  - `shiro:lacksPermission`
  - `shiro:lacksRole`
  - `shiro:notAuthenticated`
  - `shiro:principal`
  - `shiro:user`
