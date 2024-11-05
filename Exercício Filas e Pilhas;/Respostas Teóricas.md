1. O que é e para que serve uma pilha?

R: Pilha é um tipo abstrato de dados utiliado para armazenar elementos ao adicionar e remover elementos, limitado a funcionar de forma "LIFO"(Last in, First out), em que os dados mais recentemente adicionados serão o primeiro a ser removido em uma operação de remoção, simulando uma real pilha de objetos. 

2. Em que situações uma pilha pode ser utilizada?

R: Pode-se utilizar pilhas em listas ligadas

3. Suponha que uma pilha possua 4 valores na seguinte ordem: 1, 2, 3 e 4. Qual seria 
a sequência correta de operações de inserção (I) e eliminação (E) para se obter os 
registros na ordem 2 4 3 1?

R: Deve-se fazer: Eliminar {1,2,3}, Eliminar {1,2}, Eliminar {1}, Eliminar {}, Inserir(2) {2}, Inserir(4) {2, 4}, Inserir(3) {2, 4, 3}, Inserir(1) {2, 4, 3, 1}

EEEEIIII

4. Uma sequência de operações de inserção (I) e eliminação (E) numa pilha é dita válida se 
ela tem igual número de Is e Es e todas as operações podem ser efetuadas na pilha, ou
seja, a eliminação só pode acontecer se a pilha não estiver vazia. Formule uma regra
que permita determinar se uma sequência (ex: IIEE) é válida ou não.

R: def is_valid_sequence(sequence):
    count = 0
    for operation in sequence:
        if operation == 'I':
            count += 1
        elif operation == 'E':
            count -= 1
        if count < 0:
            return False
    return count == 0
