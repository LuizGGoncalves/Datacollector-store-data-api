# DataCollector

<img src="https://programathor.com.br/blog/wp-content/uploads/2018/08/api-768x768.png" alt="exemplo imagem">

>Projeto com objetivo de criar duas Apis a primeira [Datacollector-get-send-data](https://github.com/LuizGGoncalves/Datacollector-get-send-data)  responsavel por coletar dados de uma Api externa e enviar
> para a segunda Api [Datacollector-store-data-api](https://github.com/LuizGGoncalves/Datacollector-store-data-api) para que sejam armazenados e depois acessados.


### Criado Utilizando
* SpringBoot
* JPA
* Hibernate
* Swagger
* MySql
* Junit5
* Mockito

## Fluxo de Funcionamento

### Salvando dados
+ Recebimento das Informaçoes pela Rota Post no formato Json
+ Verificaçao dos dados antigos no BD
+ Atualizaçao dos dados Antigos

### Enviando informaçoes
+ Recebimento da requisiçao na Rota Get
+ Busca de informaçao no BD
+ Entrega do dado buscado no formato Json

