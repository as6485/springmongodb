# springmongodb

Demonstrate essential functionalities of using Mongodb with Spring

### Reference : 	
https://www.youtube.com/watch?v=ssj0CGxv60k

### Prerequsites
Install Docker Desktop and compose and start the docker-compose.yaml. 
We can either do it from command line
```bash
C:\Program Files\Docker\Docker\resources\bin\docker.exe compose -f C:\Users\urmis\IdeaProjects\springmongodb\docker-compose.yaml -p springmongodb up -d
```
or simply run install the docker plugin for IntelliJ and we should get compose and run options in the docker-compose.yaml itself.
This will bring up mongodb and mongo-express at (http://localhost:8081)

### MongoTemplate and MongoRepository
The MongoTemplate follows the standard template pattern in Spring and provides a ready-to-go, basic API to the underlying persistence engine.
The repository follows the Spring Data-centric approach and comes with more flexible and complex API operations, based on the well-known access patterns in all Spring Data projects.
