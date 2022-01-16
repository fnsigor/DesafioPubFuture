# Como rodar a aplicação:

## Instalação:
- Faça download do ZIP do projeto diretamente pelo GitHub ou clone o repositótio;
- Instale o servidor MySql e a ferramenta MySQL WorkBench;
- Instale a IDE NetBeans versão 12.2;
- Instale o JDK17;
- Instale os arquivos .jar;

Esses arquivos podem ser baixados através desta pasta no google drive:
https://drive.google.com/drive/folders/1qI6n-crOeBRVNdh43lexcQPKpi7flqre?usp=sharing

## Banco de dados:
- Através do MySQL Workbench, rode o script do banco de dados

## Projeto:
- No pacote pubfuture.dao, a classe ConnectionFactory é quem abre a conexão com o banco de dados. Para isso, essa classe usa o nome de usuário e senha utilizados para acessar o banco, além do número da porta do servidor.
- Se a porta do seu  servidor MySQL é diferente de 3306; seu nome de usuário é diferente de ”root” e sua  senha é diferente de “admin”, troque essas informações para os dados que você usa, caso contrário não será possível a conexão com o banco.

### - Após essas instalações e ajustes, você poderá rodar o projeto. Para isso, entre no pacote pub.future.view, que é onde se encontram as interfaces gráficas.
### - É recomendável utilizar o JFrame ContaTela como “tela principal” do sistema.

# Documentação

### Documentação técnica: https://docs.google.com/document/d/1gpZoLpgNOnENxzQBR01Lw940mU5j3IcS9MjFD73r7J0/edit?usp=sharing
### Documentação de uso: https://docs.google.com/document/d/1HntSjTlg0AKSD2Vu9j9SViyRBuC4z3WUxGRqOuuseNM/edit?usp=sharing
### Partes mais detalhadas da documentação podem ser encontradas diretamente no código fonte, em forma de comentários.
