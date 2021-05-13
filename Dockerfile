FROM openjdk:8
RUN mkdir app
COPY . /app
WORKDIR /app/application/src/main/java/vn/hoapm/springboot
RUN javac HoapmSpringApplication.java
CMD ["java", "HoapmSpringApplication"]