''' Max-Min en Array
 
    - Se inicializan como max y min a los 2 primeros valores de la lista.
    - A partir del 3ro de empieza a comparar cada elemento con max y min.
    - Complejidad Tiempo: O(n).
'''


from sys import stdin, stdout
rl = stdin.readline
wr = stdout.write


class Pair:

    def __init__(self):
        self.min = 0
        self.max = 0


def get_Max_Min(arr, n):

    minmax = Pair()

    if n == 1:
        minmax.max_ = arr[0]
        minmax.min_ = arr[0]
        return minmax

    if arr[0] > arr[1]:
        minmax.max_ = arr[0]
        minmax.min_ = arr[1]
    else:
        minmax.max_ = arr[1]
        minmax.min_ = arr[0]

    for i in range(2, n):
        if arr[i] > minmax.max_:
            minmax.max_ = arr[i]
        elif arr[i] < minmax.min_:
            minmax.min_ = arr[i]

    return minmax


arr = list(map(int, rl().split()))
n = len(arr)
result = get_Max_Min(arr, n)
wr(f'El menor es {result.min_}\n')
wr(f'El mayor es {result.max_}\n')
