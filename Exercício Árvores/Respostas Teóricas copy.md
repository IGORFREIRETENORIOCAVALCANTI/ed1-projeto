21. Diferença entre uma ABB e uma AVL
ABB (Árvore Binária de Busca): É uma árvore binária em que, para cada nó, todos os elementos na subárvore esquerda são menores que o nó e todos os elementos na subárvore direita são maiores.

AVL: É uma árvore binária de busca auto-balanceada, onde a altura das subárvores esquerda e direita de cada nó difere em no máximo 1. Se essa condição não for atendida após uma inserção ou remoção, a árvore é reestruturada através de rotações para restaurar o balanceamento.

22. Diferença na Implementação da Função de Busca entre ABB e AVL
ABB: A função de busca simplesmente compara o valor procurado com os valores dos nós, percorrendo a árvore à esquerda se o valor for menor ou à direita se for maior, até encontrar o valor ou atingir um nó folha.

AVL: A função de busca em uma AVL é similar à da ABB, mas deve garantir que a árvore se mantenha balanceada após inserções e remoções, possivelmente exigindo rotações.


32. Árvore Binária Resultante
(a) Inserção dos valores 7, 8, 3, 4, 2, 1, 6, 5:

(b) Percurso em Pré-ordem, Em-ordem e Pós-ordem:

Pré-ordem: 7, 3, 2, 1, 4, 6, 5, 8

Em-ordem: 1, 2, 3, 4, 5, 6, 7, 8

Pós-ordem: 1, 2, 5, 6, 4, 3, 8, 7

(c) Remoção dos valores 7 e 6:
***32 letra c.png***

43. Análise da Árvore
(a) Nós folhas: 𝐵,𝐹,𝐼, 𝑂
 (b) Ancestrais de C: 𝐿,𝐺
 (c) Descendentes de C: 𝐵,𝐸,𝐹
 (d) Altura da árvore: 3 (considerando a raiz em altura 0)
 (e) Nós com grau 1: 𝐸, 𝑂; nós com grau 2: 𝐿,𝐺,𝐶
 (f) Caminhos de comprimento 3: Existem 3 caminhos de comprimento 3: L -> G -> C -> B, L -> G -> C -> E, L -> G -> C -> F

45. Busca por 363
(a) 2; 252; 401; 398; 330; 344; 397; 363. (b) 924; 220; 911; 244; 898; 258; 362; 363. (c) 925; 202; 911; 240; 912; 245; 363. (d) 2; 399; 387; 219; 266; 382; 381; 278; 363. (e) 935; 278; 347; 621; 299; 392; 358; 363.

Não é possível que a sequência (d) represente uma busca válida, já que depois de 399, 387 e 219, o valor 266 não poderia estar na mesma subárvore onde está o 363
