#!/bin/sh
mvn clean package && docker build -t br.com.imerljak/projeto_tcc .
docker rm -f projeto_tcc || true && docker run -d -p 8080:8080 -p 4848:4848 --name projeto_tcc br.com.imerljak/projeto_tcc 
