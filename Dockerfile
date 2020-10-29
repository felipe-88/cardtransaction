From openjdk:8
copy ./target/card-transaction-0.0.1-SNAPSHOT.jar card-transaction-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","card-transaction-0.0.1-SNAPSHOT.jar"]