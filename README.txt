THIS PROJECT CONSIST IN BUILDING DOCKER CONTAINERS WITH A WEB APP WHICH IS IN A DOCKER CONTAINER
THIS APP MUST BE ABLE TO BUILD CUSTOMIZED DOCKER CONTAINERS AND LIST THEM

I built the project with Spring Boot and Docker

--------------------------------------------------------

To build the app use the following lines : 

First use maven :
mvnw clean
mvnw package

Then : 
docker build -f Dockerfile -t springdocker .

(now the image is built)

To run the app (create a container named springdocker):
docker run -p 8080:8080 springdocker

Container with spring webapp is now launched on port 8080

You can now go to lo localhost:8080 with your browser