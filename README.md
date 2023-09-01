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


## Estrutura de dados sugerida


![image](https://github.com/wesquel/Pacto/assets/51407794/ac039f80-94f6-49fe-a630-c16aa70b73eb)

![image](https://github.com/wesquel/Pacto/assets/51407794/3f018289-cda7-4f4f-869d-e3e33adde4a2)

![image](https://github.com/wesquel/Pacto/assets/51407794/c6bf6111-9321-46b6-920e-43221ed983e6)

![image](https://github.com/wesquel/Pacto/assets/51407794/feb32915-fa12-4a8f-9efe-7ee7390e1c8f)




