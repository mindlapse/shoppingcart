FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD target/msvc-cart-1.0.0.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Xmx384m -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]