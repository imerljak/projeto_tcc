FROM airhacks/glassfish
COPY ./target/projeto_tcc.war ${DEPLOYMENT_DIR}
