# cloud emociona

## Run database
docker run --name emociona-db -p 5432:5432 -e POSTGRES_DB=emociona -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=administrator -d postgres:10-alpine

## Stop database
docker stop emociona-db

## Start database
docker start emociona-db

## Remove database
docker rm -f emociona-db
