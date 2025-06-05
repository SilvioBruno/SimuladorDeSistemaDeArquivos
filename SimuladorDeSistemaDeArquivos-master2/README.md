
# Projeto de Sistema com Journaling

## Descrição
Este projeto é um sistema em Java que implementa um mecanismo de **journaling** para registrar operações realizadas, como criação e exclusão de arquivos e pastas.  
Cada entrada no journal inclui a operação, a descrição e o horário exato em que ocorreu, garantindo rastreabilidade e auditabilidade.

---

## Estrutura do Projeto

```
├── Sistema/           # Pacote principal do projeto
│   └── Journal.java   # Classe responsável por registrar logs de operações
│   └── Shell.java     # Classe para execução do programa Shell
│   └── File.java      # Classe Do Arquivo
│   └── Directory.java # Classe Do Diretório
│   └── FileSystemSimulator.java  # Classe Do Sistema De Arquivos
│
├── Journaling/        # Diretório onde os logs são salvos
│   └── journal.txt    # Arquivo de log que registra as operações
│
├── README.md          # Este arquivo, explicando a estrutura e uso do projeto
```

---

## Funcionamento

✅ Sempre que uma operação for realizada, ela será registrada no arquivo `journal.txt`, no formato:
```
[DataHora] [Operação] Descrição
```
Exemplo:
```
[2025-06-05 15:42:17] [Criar Pasta] nova_pasta
```

✅ O projeto cria automaticamente o diretório `Journaling/` e o arquivo `journal.txt` caso não existam.

---

## Como Executar

1. **Baixe o Zip do Arquivo no github** 
   No Link: 
   
2. **Execute o arquivo Shell**
   No terminal utilize os comandos que estão presentes no shell.java para os afins do projeto

3. **Enquanto executa o arquivo Shell abra o txt da pasta Journaling**
   Neste arquivo journal.txt, estarão sendo realizadas os registros de ações feitas durante a execução do shell

---

## Exemplo de Uso

```terminal

   Criar pasta - mkdir / pasta    
   Criar arquivo - touch /pasta silvio conteudo_texto
   Remover arquivo - rmfile /pasta silvio
   Remover diretorio - rmdir / pasta
   Renomear o arquivo - renamefile /pasta silvio pedro
   Renomear o Diretorio- renamedir / pasta pasta1
   Copiar arquivo - cpfile /pasta silvio silvio_copia /pasta1


```

Essas chamadas irão criar entradas no `journal.txt` automaticamente.

---

