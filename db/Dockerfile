#Using latest mysql image
FROM mysql:latest

#Setting work directory
WORKDIR /tmp

#Copying all files to the working directory of the container
COPY database/*.sql /tmp/
#Copying the world sql file (main sql  file) to docker-entrypoint-initdb.d
COPY database/world.sql /docker-entrypoint-initdb.d/

#Root password
ENV MYSQL_ROOT_PASSWORD password