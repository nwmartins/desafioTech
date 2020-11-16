## REQUISITOS
Banco de dados PostgreSQL 9.6 ou superior.
Java 8 ou superior.
IDE capaz de importar projetos Maven (usei o IntelliJ IDEA)


## RECOMENDÁVEL
Software que execute requisições (utilizado o Postman).


## PREPARANDO A API 
+ Na busca do windows, digite "SQL Shell" e pressione enter
+ Insira as informações solicitadas
+ Uma vez logado como usuário "postgres", entre com o comando: "CREATE DATABASE desafioTech;" - E pressione ENTER
+ Logo em seguida devera retornar a mensagem "CREATE DATABASE"
+ Abra então a IDE escolhida para importar o projeto e faca a devida importação (Aguarde o download das dependências)
+ No Diretorio src.main.java.resources - tera um arquivo chamado "application.properties", abra-o
+ Se por acaso o Postgres estiver utilizando outra porta que não seja a padrão (5432), logo na primeira linha, se faz necessário a alteração para a porta de uso
+ Na 3º linha "spring.datasource.password=" logo apos, inserir a senha do usuário postgres
+ Salve o projeto. E o inicie


+ Se tudo ocorreu corretamente, o banco de dados deve ter sido criado, e a última linha do console devera ser algo como "Started ChallengeApplication"


## USANDO A API
Pode-se abrir o navegador e acessar "http://localhost:8080/swagger-ui.html", para ter acessos aos end points
Ou utilizar o software de requisições se nao quiser preencher todas as propriedades do JSON


### No Postman:
#### Comunication:
**GET =** http://localhost:8080/api/comunications


**GET =** http://localhost:8080/api/comunication/id


##### ATENÇÃO
Para o POST e PUT é necessário na aba "Headers" a seguinte configuração:
+ campo KEY = "Content-Type"
+ campo VALUE = "application/json"




**POST =** http://localhost:8080/api/comunication
###### Aba Body
    {
        "reciver": "Teste",
        "message": "Mensagem aqui",
        "dateTimeSend": "2020-11-16T00:27:39.132",
        "status": "CLOSED"
    }
    
**Obs:** Para o campo de status, somente os valores {"OPEN"; "CLOSED"} são aceitos

**PUT =** http://localhost:8080/api/comunication/id
###### Aba Body 
    {
        "reciver": "Teste Alterado",
        "message": "Mensagem aqui NOVA",
        "dateTimeSend": "2020-11-16T00:27:39.132",
        "status": "OPEN"
    }


**DELETE =** http://localhost:8080/api/comunication/id

## CONSIDERAÇÕES
De fato, a API não ficou (100%) implementada, principalmente na parte dos testes unitários, que não consegui faze-los rodar, e portanto não os terminei, e também acho que poderia ter uma classe de validação, mas por conta do tempo se esgotando não irei conseguir implementar.

Independentemente do resultado, estou muito grato pela oportunidade e experiência desde já.