FROM java:8u111-jre
ENV APP_NAME @project.build.finalName@.@project.packaging@
COPY $APP_NAME /home/project/oauth2/
WORKDIR /home/project/oauth2/
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "-Duser.timezone=GMT+08", "@project.build.finalName@.@project.packaging@"]