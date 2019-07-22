# Gerenciador de Campeonatos

Este software possibilitar� o gerenciamento de campeonatos de mata-mata e de pontos corridos.

Com ele � poss�vel:
- Gerar aleatoriamente os confrontos de cada fase de um campeonato mata-mata;
- Registrar os resultados de um campeonato de pontos corridos, al�m de...;
- Visualizar a tabela de um campeonato em pontos corridos.

## Observa��es:

- Sobre os campeonatos em mata-mata:
  - O programa considera que s�o feitos em dois jogos cada duelo, em todas as fases;
  - Caso empate em n�mero de gols feitos, o crit�rio desempate usado � o de quantidade de gols feitos fora de casa;
  - E se continuar igual no crit�rio desempate, o programa considerar� que � preciso fazer disputa de p�naltis;
  - Quando h� o caso de disputa de p�naltis, o programa pede o placar da disputa, a fim de saber o time classificado.

## Imagens do Software

- Tela inicial

![Tela inicial do software, que cont�m uma pergunta questionando o tipo de campeonato que deseja registrar resultados](imagens/tela_inicial.png)

- Tela de campeonato de pontos corridos

![Tela de pontos corridos, que cont�m uma tabela mostrando os times participantes do campeonato](imagens/tela_pontoscorridos.png)

- Tela de campeonato mata-mata

![Tela de mata-mata, que mostra os confrontos sorteados para a fase de quartas-de-final do campeonato](imagens/tela_matamata_1.png)

![Tela de mata-mata, que mostra os confrontos sorteados em uma tabela, para registrar os resultados](imagens/tela_matamata_2.png)

## Uso

Para usar a aplica��o:

  1. Fazer o download: Duas formas de baixar o sistema:
  
    - Baixando o ZIP diretamente do reposit�rio, ou;
    - Fazendo o clone deste reposit�rio, atrav�s do comando:
    git clone https://github.com/rt-oliveira/Gerenciador-de-Campeonatos.git
    
  2. Compilar a aplica��o: Para compilar a aplica��o, e gerar o execut�vel *jar*, basta dar o seguinte comando na pasta da aplica��o:
    `ant`
	
  3. O arquivo *jar* ser� gerado com esse comando, e;
  
  4. Est� pronto para ser usado o Gerenciador de Campeonatos.
  
## Contribui��es
  
  - Para contribuir:
    1. Crie um fork deste reposit�rio
    2. Crie uma branch para fazer as altera��es
    3. Fa�a as altera��es necess�rias
    4. Fa�a um commit, e envie para seu reposit�rio remoto
    5. Crie um Pull Request

Ps.: Software desenvolvido em 2016 por Rafael Teixeira de Oliveira.


