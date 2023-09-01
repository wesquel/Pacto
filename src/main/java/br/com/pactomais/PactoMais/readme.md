<br/>
<p align="center">
  <img src="https://global-uploads.webflow.com/62a885726e4363caff93ccb8/62a886a5d88f2c8f43ddc7de_Logotipo_PactoMais_11.png" alt="Logo" width="500"/>
</p>
<br/>

# AVALIAÇÃO DESENVOLVEDOR

##### Nome: <ins>Weslley Addson Silva de Carvalho</ins>
##### Setor: DESENVOLVIMENTO
##### Cargo Função: DESENVOLVEDOR JAVA (Parte 01)
##### Data da prova: 31/08/2023


## Documentação da API

### Endpoint de Conta

---

*Realiza a criação da conta.*

```
  POST /conta
```

| Parâmetro  | Tipo     | Localização | Descrição        | Obrigatório |
|:-----------|:---------|:------------|:-----------------|:------------|
| `numero_conta` | `Long` | `body`      | Número de conta. | Sim         |

---

*Realiza a consulta da conta pelo id.*

```
  GET /conta/{conta_id}
```

| Parâmetro  | Tipo     | Localização | Descrição        | Obrigatório |
|:-----------|:---------|:------------|:-----------------|:------------|
| `conta_id` | `Long` | `path`      | Id da Conta. | Sim         |

### Endpoint de Transação

---

*Realiza a criação da transação.*

```
  POST /conta
```

| Parâmetro  | Tipo     | Localização | Descrição        | Obrigatório |
|:-----------|:---------|:------------|:-----------------|:------------|
| `conta_id` | `Long`   | `body`      | Número de conta. | Sim         |
| `tipo_operacao_id` | `Long`   | `body`      | Número da operação. | Sim         |
| `valor` | `Double`   | `body`      | Valor da Transação. | Sim         |