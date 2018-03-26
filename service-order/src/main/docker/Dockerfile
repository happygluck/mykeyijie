FROM java:8u111-jre
ENV APP_NAME @project.build.finalName@.@project.packaging@
ENV FOLDER_NAME @project.artifactId@
COPY $APP_NAME /home/project/$FOLDER_NAME/
WORKDIR /home/project/$FOLDER_NAME/
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "-Duser.timezone=GMT+08", "@project.build.finalName@.@project.packaging@"]