Passos para execução da aplicação

1- Criar uma base de dados no MySQL com o nome 'biblioteca'

2- Atualizar o arquivo application.properties com as configurações username e password

3- Clonar o projeto

na pasta biblioteca-indt
$ git clone  git@github.com:jrmatos/biblioteca-indt.git

4- Instalar as dependências do front end

na pasta biblioteca-indt/src/main/resources/static
$ bower install

5- Instalar as dependências do maven e gerar o arquivo jar

na pasta biblioteca-indt
$ mvn clean install

6- Iniciar a aplicação

na pasta biblioteca-indt/target
$ java -jar biblioteca-indt-0.0.1-SNAPSHOT.jar

7- Se tudo ocorrer bem, a aplicação deve estar disponível em localhost:8090
