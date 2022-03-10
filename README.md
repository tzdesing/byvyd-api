# cloud emociona

## Run database
docker run --name emociona-db -p 5432:5432 -e POSTGRES_DB=emociona -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=12345 -d postgres:10-alpine
