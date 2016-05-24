## TwitterInterface

### Package 'twitter'
- Enum "TwetterAuth.java" armazena os keys de acesso da conta Twitter,
- Classe "TwitterDef.java"  inicia a API executa as autenticações e retorna a instância do Twitter4j

### Package 'app'
- Classe 'Tweet' é instanciada com o objeto de cada tweet retornado na pesquisa. Seus atributos contem a menor célula de informações.
- Classe TwitterQueries contém todos os mecanismos para realizar a pesquisa e organizar as instâncias da classe 'Tweet' em uma lista. Seus métodos ordenam essa lista e também filtram.

### Classe métodos TwitterQueries


- void sortTweets(SortTweetsBy)
Método ordena a lista interna de objetos Tweet de acordo com o critério selecionado em seu argumento. Por definição este método deve ser chamado antes do método 'getQueryResult(TweetType)' para se obter um resultado ordenado como se deseja.

As opções de ordenamento são:
SortTweetsBy.DATE_NEW_TO_OLD, -> Ordena tweets por data mais novas no menores índices da lista
SortTweetsBy.DATE_OLD_TO_NEW, -> Ordena tweets por data mais antigas no menores índices da lista
SortTweetsBy.NAME_A_TO_Z,	  -> Ordena tweets em ordem alfabética pelo 'ScreenName' comecando nos menores índices
SortTweetsBy.NAME_Z_TO_A;	  -> Ordena tweets em ordem alfabética pelo 'ScreenName' comecando nos maiores índices


- List<Tweet> getQueryResult(TweetType)
Retorna uma cópia da lista interna de objetos Tweet aplicando os filtros selecionados. Os filtros são selecionados através do argumento deste método

As opções definidas são:
TweetType.ALL,			 -> Retorna todos os tweets da lista
TweetType.RETWEET,		 -> Retorna somente tweets que foram retweetados
TweetType.RETWEETED,	 -> Retorna somente tweets que foram retweetados de outros usuários
TweetType.RETWEETEDBYME, -> Retorna somente os tweets que eu retweetei
TweetType.FAVORITED;	 -> Retorna somente tweets favoritados


