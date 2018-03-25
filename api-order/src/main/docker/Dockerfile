FROM java:8u111-jre
ENV APP_NAME @project.build.finalName@.@project.packaging@
COPY $APP_NAME /home/project/api-order/
WORKDIR /home/project/api-order/
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "-Duser.timezone=GMT+08", "@project.build.finalName@.@project.packaging@"]