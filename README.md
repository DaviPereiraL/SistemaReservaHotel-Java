# Sistema de Reserva de Hotel

Este é um projeto simples de um Sistema de Reserva de Hotel desenvolvido em Java. O sistema permite que os usuários pesquisem quartos disponíveis, façam reservas e verifiquem o status das reservas. O sistema utiliza conceitos de Programação Orientada a Objetos (POO), como encapsulamento, herança, polimorfismo e manipulação de listas.

## Funcionalidades

- **Cadastrar Hotel:** Permite o cadastro de novos hotéis no sistema.
- **Cadastrar Quarto em Hotel:** Permite adicionar quartos a um hotel específico.
- **Listar Hotéis Disponíveis:** Exibe a lista de todos os hotéis cadastrados no sistema.
- **Pesquisar Quartos Disponíveis:** Permite buscar quartos disponíveis em um hotel específico com base no tipo de quarto.
- **Fazer Reserva:** Permite ao usuário reservar um quarto disponível em um hotel.
- **Verificar Status da Reserva:** Permite ao usuário verificar o status da reserva de um quarto específico.

## Estrutura do Projeto

O projeto está estruturado da seguinte forma:

```plaintext
hotelreservation/
│
├── main/
│   └── Main.java            # Classe principal para interação com o usuário
│
├── models/
│   ├── Hotel.java           # Classe que representa um hotel
│   ├── Reservation.java     # Classe que representa uma reserva
│   ├── Room.java            # Classe que representa um quarto
│   └── User.java            # Classe que representa um usuário
│
├── services/
│   ├── HotelService.java    # Serviço para gerenciar hotéis
│   ├── ReservationService.java # Serviço para gerenciar reservas
│   └── UserService.java     # Serviço para gerenciar usuários
│
└── utils/
    ├── InputValidator.java  # Utilitário para validação de entradas de usuário
    └── DateUtils.java       # Utilitário para manipulação de datas
```

## Requisitos

- Java 8+

## Como Executar

1. Clone o repositório:

    ```bash
    git clone https://github.com/seu-usuario/sistema-reserva-hotel.git
    ```

2. Navegue até o diretório do projeto:

    ```bash
    cd sistema-reserva-hotel
    ```

3. Compile o projeto:

    ```bash
    javac -d bin src/hotelreservation/main/Main.java
    ```

4. Execute o sistema:

    ```bash
    java -cp bin hotelreservation.main.Main
    ```
## Uso
Ao iniciar o sistema, você será solicitado a inserir seu nome e email. Após o login, você poderá interagir com as seguintes opções:

1. Cadastrar hotel: Insira o nome do hotel.
2. Cadastrar quarto em hotel: Escolha um hotel existente e insira as informações do quarto (número, tipo, preço).
3. Listar hotéis disponíveis: Exibe todos os hotéis cadastrados.
4. Pesquisar quartos disponíveis: Busque quartos disponíveis em um hotel específico por tipo.
5. Fazer uma reserva: Escolha um quarto disponível e faça uma reserva.
6. Verificar status da reserva: Verifique o status de uma reserva para um quarto específico.
7. Sair: Encerra o programa.

## Imagem do sistema:

https://github.com/user-attachments/assets/e5bb1294-2d9f-4baf-b57a-f86bfd3c787c

## Contribuições
Contribuições são bem-vindas! Se você tiver alguma sugestão ou encontrar algum bug, fique à vontade para abrir uma issue ou enviar um pull request. Projeto para fins de estudo acadêmico em Java.

