#base layer of image, java 11
FROM openjdk:11

# Create a new application directory for my app files
RUN mkdir /application


# Copy application files(i.e jar, war) from host machine to image filesystem
COPY target/directory-listing-0.0.1-SNAPSHOT.jar /application

#Set the directory for executing future commands
WORKDIR /application

# Run the main class(UniverseMain)
#
ENTRYPOINT ["java", "-jar", "directory-listing-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
