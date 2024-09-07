import math
import tkinter as tk
import unittest


class Calculadora:
    def sumar(self, a, b):
        return a + b

    def restar(self, a, b):
        return a - b

    def multiplicar(self, a, b):
        return a * b

    def dividir(self, a, b):
        if b == 0:
            raise ValueError("División por cero")
        return a / b

    def raiz_cuadrada(self, a):
        return math.sqrt(a)

    def potencia(self, a, b):
        return math.pow(a, b)



def sumar():
    resultado.set(calculadora.sumar(float(entry1.get()), float(entry2.get())))

calculadora = Calculadora()
root = tk.Tk()
root.title("Calculadora")

entry1 = tk.Entry(root)
entry1.pack()
entry2 = tk.Entry(root)
entry2.pack()

resultado = tk.StringVar()
tk.Label(root, textvariable=resultado).pack()

tk.Button(root, text="Sumar", command=sumar).pack()

root.mainloop()

# Interfaz

import tkinter as tk
from tkinter import messagebox

class Calculadora:
    def sumar(self, a, b):
        return a + b

    def restar(self, a, b):
        return a - b

    def multiplicar(self, a, b):
        return a * b

    def dividir(self, a, b):
        if b == 0:
            raise ValueError("División por cero")
        return a / b

def realizar_operacion(operacion):
    try:
        a = float(entry1.get())
        b = float(entry2.get())
        if operacion == "sumar":
            resultado.set(calculadora.sumar(a, b))
        elif operacion == "restar":
            resultado.set(calculadora.restar(a, b))
        elif operacion == "multiplicar":
            resultado.set(calculadora.multiplicar(a, b))
        elif operacion == "dividir":
            resultado.set(calculadora.dividir(a, b))
    except ValueError as e:
        messagebox.showerror("Error", str(e))

calculadora = Calculadora()
root = tk.Tk()
root.title("Calculadora")

tk.Label(root, text="Número 1:").grid(row=0, column=0)
entry1 = tk.Entry(root)
entry1.grid(row=0, column=1)

tk.Label(root, text="Número 2:").grid(row=1, column=0)
entry2 = tk.Entry(root)
entry2.grid(row=1, column=1)

resultado = tk.StringVar()
tk.Label(root, text="Resultado:").grid(row=2, column=0)
tk.Label(root, textvariable=resultado).grid(row=2, column=1)

tk.Button(root, text="Sumar", command=lambda: realizar_operacion("sumar")).grid(row=3, column=0)
tk.Button(root, text="Restar", command=lambda: realizar_operacion("restar")).grid(row=3, column=1)
tk.Button(root, text="Multiplicar", command=lambda: realizar_operacion("multiplicar")).grid(row=4, column=0)
tk.Button(root, text="Dividir", command=lambda: realizar_operacion("dividir")).grid(row=4, column=1)

root.mainloop()
