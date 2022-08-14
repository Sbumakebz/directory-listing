a. To Build run docker build -t directory-listing:0.1 . inside the project directory
b. To run/execute run
		1. docker run --publish 8080:8080 directory-listing:0.1
		2. curl http://localhost:8080//directory-listing//{directoryPath} Please note directoryPath will be a base64 encoded string
																				and a path that exists inside the container(directory-listing)