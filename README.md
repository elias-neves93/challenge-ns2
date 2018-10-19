## 1º Challenge

### Requirements
  - Docker
  - Java 8
  - Postman

### Deployment

After installed "Requirements" enter the project folder and run the following command.
```sh
$ docker run -it -d -p 27017:27017 mongo
```
and running application Java

## Tests routes API via Postman

> APIs endpoints
> GET http://localhost:8080/client [lista todos os clientes]
> GET http://localhost:8080/client/{id} [lista um cliente por ID]
> POST http://localhost:8080/client [cadastra um novo cliente]
> PUT http://localhost:8080/client/{id} [atualiza os dados de um cliente]
> DELETE http://localhost:8080/client/{id} [remove um cliente por ID]


## 2º Challenge

```java
import java.util.Scanner;

public class Telefone {

    public static void main(String[] args) {

        System.out.println("Digite seu telefone.");
        Scanner scanner = new Scanner(System.in);

       String TEL = scanner.next();

        scanner.close();
      
        System.out.println("Seu telefone: " + "(" + TEL.substring(0, 2) + ")" + TEL.substring(2, 7) + "-" + TEL.substring(7, 11));
    }
}
```

## 3º Challenge

```
SELECT DESC_PRODUTO, COUNT(*) QUANTIDADE FROM #ITENS_PEDIDOS_TESTE A
INNER JOIN #PEDIDOSTESTE B ON A.COD_PEDIDO = B.COD_PEDIDO 
GROUP BY DESC_PRODUTO HAVING COUNT(*) > 1
```

## 4º Challenge

```js
db.produto.find({"descricao": {$regex: /Alemanha/}})
```

