# projeto_tcc
Projeto de TCC para o curso de Sistema de Informação - IFFarroupilha - SB - 2018

# Build
mvn clean package && docker build -t br.com.imerljak/projeto_tcc .

# RUN

docker rm -f projeto_tcc || true && docker run -d -p 8080:8080 -p 4848:4848 --name projeto_tcc br.com.imerljak/projeto_tcc 