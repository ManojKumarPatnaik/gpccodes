def BinarySearch(arr, inicio, fin, numerobuscado):
    if fin > inicio:
        medio = int((inicio + (fin-1))/2)
        if arr[medio] == numerobuscado:
            return medio
        if arr[medio] > numerobuscado:
            return BinarySearch(arr, inicio, medio-1, numerobuscado)
        else:
            return BinarySearch(arr, medio+1, fin, numerobuscado)
    return -1


def exponentialsearch(arr, tam, buscado):
    if arr[0] == buscado:
        return 0
    i = int(1)
    while i < tam and arr[i] <= buscado:
        i = i*2
    return BinarySearch(arr, i//2, min(i, tam), buscado)


lista = [1, 2, 3, 4, 5, 6]
buscado = int(3)
resultado = int(exponentialsearch(lista, len(lista), buscado))

if resultado < 0:
    print("El elemento no se encuentra en el arreglo")
else:
    print("El elemento Esta en la posicion: ", resultado)
