FROM tomcat:9.0.37
MAINTAINER SaiSandeep

COPY target/AgoraTokenServer.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]
