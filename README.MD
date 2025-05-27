# 📦 API de Embalagem - Yan Miranda

Esta é uma API desenvolvida com Spring Boot para processar pedidos e alocar produtos em caixas, considerando as dimensões de cada item. O retorno informa em qual caixa cada produto deve ser colocado, ou se ele não cabe em nenhuma disponível.

---

## 🚀 Como rodar com Docker

### ✅ Pré-requisitos

- [Docker](https://www.docker.com/get-started) instalado na sua máquina.
- Java 17 (usado na build).
- Maven (ou utilize o wrapper `./mvnw`).

---
### 🛠️ Passos para rodar a aplicação

1. **Gerar o `.jar` da aplicação**:
    
    ```bash
    mvnw clean package -DskipTests
    ```
    OBS: Recomendo rodar diretamente na aba do maven no intellij

2. **Construir a imagem Docker**:
    
    ```bash
    docker build -t embalagem-api .
    ```

3. **Executar o container**:
    
    ```bash
    docker run -p 8080:8080 embalagem-api
    ```

4. **Acessar a documentação da API**:

    [http://localhost:8080/swagger-ui/index.html#/](http://localhost:8080/swagger-ui/index.html#/)
