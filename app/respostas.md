1. O ciclo de vida impacta diretamente o ciclo de vida pois é ele quem cuida da construção e
   destruição de uma activity, onde activitys pesadas sendo abertas uma dentro da outra levam a um
   alto consumo de memória, performance e até o rotacionamento da tela, uma vez que com a tela
   rotacionada, tudo precisa ser reconstruído novamente em uma nova orientação de tela.
   O ciclo de vida tem 4 estados, onCreate, sendo chamado quando a activity está sendo criada,
   onStart, sendo chamado após um onCreate ou um onResume, ele serve para inicializar a tela em
   geral, utilizado para iniciar animações e construção na tela. onRestart serve para re-exibir uma
   tela (por exemplo o usuário voltou para uma determinada tela), e por último o onDestroy, que
   serve para destruir uma activity

2. Manifesto: Trata-se do cabeçalho do projeto android, contém informações como: Versão da API do
   android, activities declaradas, ícone do aplicativo e entre outros
   Res: contém toda a parte de visualização do projeto android (layouts e drawables)
   R: Até onde sei, trata-se da classe que contém os IDs para cada elemento de todas as activities.
   Activitys: Responsável por estilizar e posicionar todos os elementos em uma tela

3. 