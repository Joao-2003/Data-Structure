def isnumber(s):
    try:
        float(s)
        return True
    except ValueError:
        return False

def obter_expressao(escolha):
    operadores = "+-*/()"
    entrada = input("Digite a expressão:\n")

    i = 0
    new_entrada = ""
    while i < len(entrada):
        if entrada[i] in operadores:
            if entrada[i] == '-' and i + 1 < len(entrada) and entrada[i + 1].isdigit():
                if i == 0 and escolha == "pe":
                  new_entrada += "- "
                elif i - 1 >= 0 and entrada[i - 1].isdigit() and escolha == "in":
                  new_entrada += " + " + entrada[i]
                else:
                  new_entrada += " " + entrada[i]
            else:
                new_entrada += " " + entrada[i] + " "
        else:
            new_entrada += entrada[i]
        i += 1

    new_entrada = ' '.join(new_entrada.split())
    print("Expressão tratada na notação escolhida pelo usuário: " + new_entrada)
    entrada_valida = all(char in "0123456789+-*/. ()" for char in entrada)
    if entrada_valida:
        return new_entrada
    else:
        print("A expressão contém caracteres inválidos.")
        return None

def resolver_posfixa(entrada):
    operadores = "+-*/"
    pilha = []
    for ficha in entrada.split():
        if ficha in operadores:
            y, x = pilha.pop(), pilha.pop()
            if ficha == '+':
                z = x + y
            elif ficha == '-':
                z = x - y
            elif ficha == '*':
                z = x * y
            else:
                z = x / y
            pilha.append(z)
        else:
            pilha.append(float(ficha))
    if len(pilha) == 1:
        return pilha.pop()
    else:
        raise Exception("Expressão inválida")

def resolver_prefixa(entrada):
    operadores = "+-*/"
    pilha = []
    for ficha in reversed(entrada.split()):
        if ficha in operadores:
            x = pilha.pop()
            y = pilha.pop()
            if ficha == '+':
                z = x + y
            elif ficha == '-':
                z = x - y
            elif ficha == '*':
                z = x * y
            else:
                z = x / y
            pilha.append(z)
        else:
            pilha.append(float(ficha))
    if len(pilha) == 1:
        return pilha.pop()
    else:
        raise Exception("Expressão inválida")

def infixa_para_posfixa(entrada):
    precedencia = {'+': 1, '-': 1, '*': 2, '/': 2}
    pilha = []
    saida = []
    for ficha in entrada.split():
        if isnumber(ficha):
            saida.append(ficha)
        elif ficha in '+-*/':
            while pilha and pilha[-1] in '+-*/' and precedencia[ficha] <= precedencia[pilha[-1]]:
                saida.append(pilha.pop())
            pilha.append(ficha)
        elif ficha == '(':
            pilha.append(ficha)
        elif ficha == ')':
            while pilha and pilha[-1] != '(':
                saida.append(pilha.pop())
            pilha.pop()
    while pilha:
        saida.append(pilha.pop())
    return ' '.join(saida)

def prefixa_para_posfixa(entrada):
    pilha = []
    for ficha in reversed(entrada.split()):
        if isnumber(ficha):
            pilha.append(ficha)
        else:
            x = pilha.pop()
            y = pilha.pop()
            pilha.append(x + " " + y + " " + ficha)
    return pilha[0] if pilha else ''

def posfixa_para_infixa(entrada):
    pilha = []
    for ficha in entrada.split():
        if isnumber(ficha):
            pilha.append(ficha)
        else:
            y = pilha.pop()
            x = pilha.pop()
            pilha.append("(" + x + " " + ficha + " " + y + ")")
    return pilha[0] if pilha else ''

def posfixa_para_prefixa(entrada):
    pilha = []
    for ficha in entrada.split():
        if isnumber(ficha):
            pilha.append(ficha)
        else:
            x = pilha.pop()
            y = pilha.pop()
            pilha.append(ficha + " " + y + " " + x)
    return pilha[0] if pilha else ''

def main():
    while True:
        print("\nVocê deseja resolver uma expressão na notação pós-fixa, pré-fixa ou infixa?")
        print("Espaços só são obrigatórios na notação pré-fixa depois de um '-' que seja um operador.")
        escolha = input("Digite 'po' para pós-fixa, 'pe' para pré-fixa ou 'in' para infixa: ")

        entrada = obter_expressao(escolha)
        if entrada is None:
            return

        if escolha == 'po':
            try:
                resultado = resolver_posfixa(entrada)
                print("O resultado é:", resultado)
                print("Na notação infixa, a expressão seria:", posfixa_para_infixa(entrada))
                print("Na notação pré-fixa, a expressão seria:", posfixa_para_prefixa(entrada))
            except Exception as e:
                print('Erro:', e)
        elif escolha == 'pe':
            try:
                resultado = resolver_prefixa(entrada)
                print("O resultado é:", resultado)
                entrada_posfixa = prefixa_para_posfixa(entrada)
                print("Na notação infixa, a expressão seria:", posfixa_para_infixa(entrada_posfixa))
                print("Na notação pós-fixa, a expressão seria:", entrada_posfixa)
            except Exception as e:
                print('Erro:', e)
        elif escolha == 'in':
            try:
                entrada_posfixa = infixa_para_posfixa(entrada)
                resultado = resolver_posfixa(entrada_posfixa)
                print("O resultado é:", resultado)
                print("Na notação pós-fixa, a expressão seria:", entrada_posfixa)
                print("Na notação pré-fixa, a expressão seria:", posfixa_para_prefixa(entrada_posfixa))
            except Exception as e:
                print('Erro:', e)
        else:
            print("Escolha inválida. Por favor, digite 'po' para pós-fixa, 'pe' para pré-fixa ou 'in' para infixa.")

        continuar = input("Deseja continuar? (s/n): \n")
        if continuar.lower() != 's':
            break

if __name__ == "__main__":
    main()
