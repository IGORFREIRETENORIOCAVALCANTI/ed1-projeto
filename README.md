
# Estrutura de Dados 1 - 1º Projeto

• Autor: Igor Freire
• Deadline: 30 de setembro de 2024

### Legenda:
- [x] = Feito
- [ ] = A ser feito

### Avaliação:
- [x] Definição de Listas Encadeadas (5%): Implementar 3 tipos diferentes de listas 
encadeadas, simples, duplas e circulares para gerenciar os dados dos três cenários 
descritos abaixo.

- [x] Operações Básicas (15%): Desenvolver funções de inserção, remoção, busca e atualização 
para cada tipo de lista, garantindo que operem de forma eficiente e correta. Modele pelo 
menos 12 funções diferentes que realizem operações de inserção, remoção, busca e 
atualização em cada tipo de lista, distribuídas nos três casos.

- [ ] Integração dos Cenários (10%): Demonstrar como os três sistemas (clínica médica, 
gerenciamento de eventos e restaurante) podem ser integrados usando listas encadeadas, 
proporcionando uma solução coesa e funcional.

- [ ] Tomada de Decisão (10%): O analista da equipe deve elaborar pelo menos 5 perguntas que 
podem ser respondidas utilizando operações nas listas encadeadas para auxiliar na tomada 
de decisões estratégicas (por exemplo, como identificar os médicos mais solicitados em 
consultas ou os itens de pedido mais populares no restaurante).

- [ ] Toque Final ao Cliente (10%): Surpreenda o cliente com uma funcionalidade adicional que 
agregue valor ao sistema, como uma interface simples para visualização dos dados nas 
listas encadeadas.

- [x] Pitch (10% extra): Após a apresentação, haverá uma votação a ser decidido no dia, para 
determinar qual é o melhor dos projetos apresentados.


## Caso 1 - Sistema de Gerenciamento Clínica Médica
Objetivo: Desenvolver um sistema que gerencie as informações de uma clínica médica usando
listas encadeadas.
Requisitos:
- [x] Implementar uma lista encadeada para armazenar os dados dos pacientes, médicos e 
consultas.

- [x] As informações dos pacientes devem incluir nome, idade, histórico médico e data da última 
consulta.

- [x] As informações dos médicos devem incluir nome, especialidade e disponibilidade.

- [x] Implementar funções para inserir novos pacientes, agendar consultas, buscar pacientes ou 
médicos específicos e atualizar os registros de consultas.


## Caso 2 - Sistema de Gerenciamento de Eventos 
Objetivo: Criar um sistema de gerenciamento de eventos usando listas encadeadas.
Requisitos:
- [x] Implementar uma lista encadeada para gerenciar dados de eventos, participantes e 
inscrições.

- [x] As informações do evento devem incluir nome, data, local e capacidade.

- [x] As informações dos participantes devem incluir nome, número de inscrição e evento no qual 
estão inscritos.

- [x] Implementar funções para registrar novos participantes, cancelar inscrições, buscar por 
eventos ou participantes específicos e atualizar os dados de um evento.


## Caso 3 - Sistema de Gerenciamento de Restaurante
Objetivo: Desenvolver um sistema de gerenciamento de pedidos em um restaurante utilizando 
listas encadeadas.
Requisitos:
- [x] Implementar uma lista encadeada para gerenciar as mesas, pedidos e itens de pedido.

- [x] As informações das mesas devem incluir número da mesa, cliente associado e status 
(livre/ocupada).

- [x] As informações do pedido devem incluir descrição dos itens, quantidade e total a pagar.

- [x] Implementar funções para adicionar novos pedidos, fechar contas, buscar por mesas 
específicas ou pedidos e atualizar os dados dos itens pedidos.


# Estrutura de Dados 1 - 2º Projeto 

Deadline: 21 de novembro de 2024 

### Avaliação (50% da nota do módulo 2): 
- [ ] Definição da estrutura de dados (20%): Desenvolver e implementar a árvore 
binária, pilha e fila para cada caso de uso específico. Criar funções de inserção, 
remoção e busca para cada estrutura. 
- [x] Integração  dos  Cenários  (10%): Demonstrar a integração entre os sistemas 
(clínica, eventos e restaurante) através das estruturas de dados implementadas, 
possibilitando uma solução coesa e funcional.
- [ ] Tomada  de  Decisão (10%):  Elaborar e responder a 5 perguntas estratégicas 
usando as operações realizadas nas estruturas de dados, como: “Qual é o perfil 
de pacientes que mais usam os serviços da clínica?”, “Quais eventos possuiem 
maior fila de espera?”, e “Quais mesas são mais frequentemente reservadas?”.

Decisoes que foram tomadas neste projeto: 
- [ ] 1. Quais médicos ficam mais disponíveis?
- [ ] 2. Quais médicos ficam menos disponíveis?
- [ ] 3. Qual dia é mais comum de se ter emergência em um mês?
- [ ] 4. Quais events têm mais inscrições prioritárias?
- [ ] 5. Quais pacientes usam a emergência com mais frequência?

- [x] Entrega (5%): Envie o link do GitHub via Teams. No GitHub deve conter slides ou 
materiais  visuais  usados  durante  a  apresentação  e  um  readme  descrevendo  o 
projeto. A equipe toda deve ter acesso ao GitHub compartilhado (é um projeto em 
equipe). Adicione uma seção no readme detalhando a contribuição individual de 
cada integrante. 

 - [ ] Impressão Digital (5%): Surpreenda com algo diferenciado, interessante ou único 
ao seu projeto. 

Impressão Digital Utilizada:
- [ ] Se o cliente utilizou um serviço de clínica ou participou de um evento, no mesmo dia ele receberá desconto na conta final do restaurante


## Caso  1  -  Clínica  Médica  com  Gerenciamento  de  Consultas  Emergenciais  e 
Histórico de Pacientes 
- [x] Pilhas: Utilize uma pilha para armazenar o histórico de ações dos pacientes, 
permitindo desfazer consultas agendadas ou atualizações em caso de erro. 
- [ ] Filas: Implemente uma fila para gerenciar a ordem de atendimento de pacientes 
em  situações  emergenciais,  onde  os  pacientes  são  atendidos  em  ordem  de 
chegada. 
- [ ] Árvore Binária de Busca: Estruture os dados dos médicos de forma a facilitar a 
busca por especialidade e disponibilidade. 


## Caso 2 - Sistema de Eventos com Inscrição Prioritária e Busca de Participantes 
- [ ] Pilhas: Crie uma pilha para armazenar um histórico de eventos consultados, 
permitindo ao usuário retornar aos últimos eventos visualizados. 
- [ ] Filas:  Utilize  uma  fila  para  organizar  inscrições  com  prioridade  para  eventos 
populares, permitindo que inscritos prioritários sejam alocados rapidamente. 
- [ ] Árvore Binária de Busca: Armazene dados dos participantes em uma árvore 
binária de busca, facilitando a busca por nome e número de inscrição. 


## Caso 3 - Gestão de Restaurante com Pedidos e Consultas de Produtos Populares 
- [ ] Pilhas: Use uma pilha para armazenar um histórico de modificações nos pedidos 
de cada mesa, como adição ou remoção de itens, possibilitando o desfazer de 
alterações. 
- [ ] Filas:  Implemente  uma  fila  de  pedidos  para  organização  dos  mesmos,  com 
prioridade para pedidos com itens que demoram menos para serem preparados. 
- [ ] Árvore Binária de Busca: Estruture os itens do menu em uma árvore binária de 
busca, permitindo consultas rápidas para verificar a popularidade de cada item 
com base nas vendas anteriores.
